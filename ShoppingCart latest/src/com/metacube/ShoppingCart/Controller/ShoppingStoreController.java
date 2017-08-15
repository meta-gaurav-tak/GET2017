package com.metacube.ShoppingCart.Controller;

import com.metacube.ShoppingCart.Enumerations.Status;
import com.metacube.ShoppingCart.Facade.CartFacade;
import com.metacube.ShoppingCart.Facade.ProductFacade;
import com.metacube.ShoppingCart.TO.CartEntry;

public class ShoppingStoreController {
    
    public static Status addProductCart(CartEntry cartEntry,ProductFacade productOperations,CartFacade shoppingCart){
        if(cartEntry!=null && cartEntry.getProductId()!="" && cartEntry.getQuantity()>0) {
            cartEntry.setCostOfOrder(cartEntry.getQuantity()
                    *productOperations.getProductById(cartEntry.getProductId()).getProductRate());
            if(shoppingCart.addToCart(cartEntry)){
                return Status.SUCCESS_ADDTOCART;
            } else {
                return Status.FAILURE_ADDTOCART;
            }
        } else {
            return Status.INVALID_CARTENTRY;
        }
    }
    public static Status removeProductCart(CartEntry cartEntry,ProductFacade productOperations,CartFacade shoppingCart){
        if(cartEntry!=null && cartEntry.getProductId()!="") {
            return shoppingCart.removeFromCart(cartEntry);
        } else {
            return Status.INVALID_CARTENTRY;
        }
    }
    public static String displayCart(ProductFacade productOperations,CartFacade shoppingCart) {
        return shoppingCart.displayCart();
    }
    public static String checkout(ProductFacade productOperations,CartFacade shoppingCart){
        return shoppingCart.checkoutCart();
    }
}
