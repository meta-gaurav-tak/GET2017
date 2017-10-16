package com.metacube.shoppingcart.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.model.CartItem;
import com.metacube.shoppingcart.service.CartService;

@Component("cartFacade")
public class DefaultCartFacade implements CartFacade {

	@Autowired
	CartService cartService;

	public DefaultCartFacade() {

	}

	public DefaultCartFacade(CartService cartService) {
		this.cartService = cartService;
	}

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}


	@Override
	public Iterable<CartItem> getAll(final String userName) {
		return cartService.getAll(userName);

	}

	@Override
	public CartItem addToCart(String productName, double price, int productId,
			String userName) {
		return cartService.addToCart(productName, price, productId, userName);
	}

	@Override
	public Boolean checkout(String userName) {
		return cartService.checkout(userName);
	}
}
