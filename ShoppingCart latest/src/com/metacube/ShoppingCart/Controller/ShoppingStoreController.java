package com.metacube.ShoppingCart.Controller;

import com.metacube.ShoppingCart.Enumerations.Status;
import com.metacube.ShoppingCart.Facade.CartFacade;
import com.metacube.ShoppingCart.Facade.FacadeFactory;
import com.metacube.ShoppingCart.Facade.ProductFacade;
import com.metacube.ShoppingCart.TO.CartEntry;

/**
 * The Class ShoppingStoreController.
 */
public class ShoppingStoreController {
	
	/** The cartFacade object */
	private static CartFacade shoppingCart=FacadeFactory.getCartFacadeDaoInstance();
	
	/** The productfacade object */
	private static ProductFacade productOperations=FacadeFactory.getProductFacadeDaoInstance();
    
    /**
     * Adds the product to cart.
     *
     * @param cartEntry the cart entry object from  view
     * @return the status code
     */
    public static Status addProductCart(CartEntry cartEntry){
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
    
    /**
     * Removes the product from cart.
     *
     * @param cartEntry the cart entry from the view
     * @return the status code to view
     */
    public static Status removeProductCart(CartEntry cartEntry){
        if(cartEntry!=null && cartEntry.getProductId()!="") {
            return shoppingCart.removeFromCart(cartEntry);
        } else {
            return Status.INVALID_CARTENTRY;
        }
    }
    
    /**
     * Display cart.
     *
     * @return the string returns either the bill string or a status flag
     */
    public static String displayCart() {
        return shoppingCart.displayCart();
    }
    
    /**
     * Checkout.
     *
     * @return checkout string returns either the bill string or a status flag and clears cart
     */
    public static String checkout(){
        return shoppingCart.checkoutCart();
    }
}
