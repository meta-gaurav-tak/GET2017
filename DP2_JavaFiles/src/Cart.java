package com.metacube.ShoppingCart.TO;

import java.util.Map;

public class Cart {
    private Map<String,CartEntry> itemsInCart;

    public Map<String, CartEntry> getItemsInCart() {
        return itemsInCart;
    }

    public void setItemsInCart(Map<String, CartEntry> itemsInCart) {
        this.itemsInCart = itemsInCart;
    }
    
}
