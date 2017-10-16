
package com.metacube.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.facade.CartFacade;
import com.metacube.shoppingcart.facade.OrderFacade;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.facade.UserFacade;
import com.metacube.shoppingcart.model.CartItem;
import com.metacube.shoppingcart.model.Order;
import com.metacube.shoppingcart.model.OrderDetail;

/**
 * The Class ProductController.
 */
@CrossOrigin
@Controller
@RequestMapping("/ShoppingApplication")
public class ShoppingCartController {

	/** The product facade. */
	@Autowired
	ProductFacade productFacade;

	@Autowired
	UserFacade userFacade;

	@Autowired
	CartFacade cartFacade;

	@Autowired
	OrderFacade orderFacade;
	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	@RequestMapping(value = "/product/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<ProductDto> getProducts() {
		return productFacade.getAllProducts();
	}

	/**
	 * Gets the by id.
	 *
	 * @param id
	 *            the id
	 * @return the by id
	 */
	@RequestMapping(value = "/product/getOne/{id}")
	public @ResponseBody ProductDto getById(@PathVariable("id") int id) {
		return productFacade.getProductById(id);
	}

	/**
	 * Delete by id.
	 *
	 * @param id
	 *            the id
	 * @return the boolean
	 */
	@RequestMapping(value = "/product/delete/{id}")
	public @ResponseBody Boolean deleteById(@PathVariable("id") int id) {
		return productFacade.deleteById(id);
	}

	/**
	 * Save.
	 *
	 * @param product
	 *            the product
	 * @return the product dto
	 */
	@RequestMapping(value = "/product/save", method = RequestMethod.POST)
	public @ResponseBody ProductDto save(@RequestBody ProductDto product) {
		return productFacade.save(product.getId(), product.getName(),
				product.getPrice());
	}

	/**
	 * Update by id.
	 *
	 * @param product
	 *            the product
	 * @return the product dto
	 */
	@RequestMapping(value = "/product/update", method = RequestMethod.POST)
	public @ResponseBody ProductDto updateById(@RequestBody ProductDto product) {
		return productFacade.update(product.getId(), product.getName(),
				product.getPrice());
	}
	@RequestMapping(value = "/getUser/{username}/{password}")
	public @ResponseBody Object getById(
			@PathVariable("username") String username,
			@PathVariable("password") String password) {
		return userFacade.authenticate(username,password);
		
	}
	@RequestMapping(value = "/getCart/{userName}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<CartItem> getAllCartItems(
			@PathVariable("userName") String userName) {
		return cartFacade.getAll(userName);
	}

	@RequestMapping(value = "/saveToCart", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody CartItem addtoCart(@RequestBody CartItem cart) {
		return cartFacade.addToCart(cart.getProduct().getName(), cart.getProduct().getPrice(),
				cart.getProduct().getId(), cart.getUser().getUsername());
	}

	@RequestMapping(value = "/checkout/{id}")
	public @ResponseBody Boolean checkout(@PathVariable("id") String userName) {
		return cartFacade.checkout(userName);
	}

	@RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
	public @ResponseBody boolean saveOrder(@PathVariable("id") String userName,
			@RequestBody Order order) {
		return orderFacade.saveOrder(userName, order);
	}

	@RequestMapping(value = "/getAllOrder/{userName}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<Order> getAllOrder(
			@PathVariable("userName") String userName) {
		return orderFacade.getAllOrder(userName);
	}

	@RequestMapping(value = "/getOrderDetail/{orderId}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<OrderDetail> getOrderDetail(
			@PathVariable("orderId") int orderId) {
		return orderFacade.getOrderDetail(orderId);
	}

}
