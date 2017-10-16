package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.model.CartItem;

public interface CartFacade {

	Iterable<CartItem> getAll(final String id);

	CartItem addToCart(String pname, double price, int productId, String userId);

	Boolean checkout(String id);

}
