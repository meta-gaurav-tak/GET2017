package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.model.User;
import com.metacube.shoppingcart.service.UserService;

@Component("userFacade")
public class DefaultUserFacade implements UserFacade {
	@Autowired
	UserService userService;

	public DefaultUserFacade() {

	}

	public void setUserService(final UserService userService) {
		this.userService = userService;
	}

	public UserService getUserService() {
		return userService;
	}

	public DefaultUserFacade(UserService userService) {
		this.userService = userService;
	}

	@Override
	public Iterable<UserDto> getAllUsers() {
		List<UserDto> userDtoList = new ArrayList<>();
		for (User user : userService.getAllUsers()) {
			userDtoList.add(modelToDto(user));
		}

		return userDtoList;
	}

	@Override
	public UserDto getUserByUserName(final String userName) {
		return modelToDto(userService.getUserById(userName));
	}

	protected User dtoToModel(UserDto userDto) {
		if (userDto == null) {
			return null;
		}
		User user = new User();
		user.setId(userDto.getId());
		user.setUsername(userDto.getUserName());
		user.setPassword(userDto.getPassword());
		return user;
	}

	protected UserDto modelToDto(User user) {
		if (user == null) {
			return null;
		}
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getUsername());
		userDto.setPassword(user.getPassword());
		return userDto;
	}

	@Override
	public JSONObject authenticate(String username, String password) {
	    UserDto user = getUserByUserName(username);
	    if ((username.equals(user.getUserName()))
                && (password.equals(user.getPassword()))) {
            JSONObject obj = new JSONObject();
            obj.put("authenticationFlag", true);
            obj.put("userId", user.getId());
            return obj;
        } else {
            JSONObject obj = new JSONObject();
            obj.put("authenticationFlag", false);
            obj.put("userId", -1);
            System.out.print(obj);
            return obj;
        }
	}
}
