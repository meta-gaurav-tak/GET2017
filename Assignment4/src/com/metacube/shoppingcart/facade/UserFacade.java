package com.metacube.shoppingcart.facade;

import org.json.simple.JSONObject;

import com.metacube.shoppingcart.dto.UserDto;

public interface UserFacade {
	Iterable<UserDto> getAllUsers();
	JSONObject authenticate(String username, String password);
    UserDto getUserByUserName(String userName);
}
