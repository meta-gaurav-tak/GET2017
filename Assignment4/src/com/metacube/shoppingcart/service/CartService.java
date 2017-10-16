package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.model.CartItem;

public interface CartService {
	Iterable<CartItem> getAll(String id);

	CartItem addToCart(String pname, double price, int productId, String userId);

	Boolean checkout(String id);
}
