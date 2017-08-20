package com.metacube.ShoppingCart.Dao;

import com.metacube.ShoppingCart.TO.CartEntry;

public interface CartDao {
    public abstract void addItemToCart(CartEntry cartEntry);
    public abstract boolean removeFromCart(String productId);
    public String generateBill();
    public String displayCart();
    public String checkout();
    public boolean isEmpty();
    public CartEntry getItemFromCart(String productId);
}
