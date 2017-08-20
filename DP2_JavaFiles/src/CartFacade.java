package com.metacube.ShoppingCart.Facade;

import com.metacube.ShoppingCart.Dao.CartDao;
import com.metacube.ShoppingCart.Dao.DaoFactory;
import com.metacube.ShoppingCart.Dao.ProductDao;
import com.metacube.ShoppingCart.Dao.Impl.CartDaoInMemoryImpl;
import com.metacube.ShoppingCart.Dao.Impl.ProductInMemoryDao;
import com.metacube.ShoppingCart.Enumerations.Status;
import com.metacube.ShoppingCart.TO.CartEntry;

public class CartFacade {
    //getting Dao Instance from factory
    ProductDao productDaoInstance=(ProductInMemoryDao)DaoFactory.getProductDaoInstance("In_Memory");
    CartDao cartDaoInstance=new CartDaoInMemoryImpl();
    
    //add to cart validations
    public boolean addToCart(CartEntry cartEntry){
        if((productDaoInstance.getProduct(cartEntry.getProductId()))!=null) {//check 9if product id is valid or not
            if(cartDaoInstance.getItemFromCart(cartEntry.getProductId())!=null){//if product is already in cart just increase its quantity
                int existingQuantity=cartDaoInstance.getItemFromCart(cartEntry.getProductId()).getQuantity();
                cartEntry.setQuantity(cartEntry.getQuantity()+existingQuantity);
                double existingOrderCost=cartDaoInstance.getItemFromCart(cartEntry.getProductId()).getCostOfOrder();
                cartEntry.setCostOfOrder(existingOrderCost+cartEntry.getCostOfOrder());
            }
            cartDaoInstance.addItemToCart(cartEntry);
            return true;
        } else{
            return false;
        }
    }
    
    public Status removeFromCart(CartEntry cartEntry){
        if(cartDaoInstance.removeFromCart(cartEntry.getProductId())) {//check if product exists in cart or not
            return Status.SUCCESS_REMOVECART;
        } else {
            return Status.FAILURE_REMOVECART;
        }
    }
    
    public String displayCart() {
        if(cartDaoInstance.isEmpty()){
            return Status.CART_EMPTY+"";
        } else {
            return cartDaoInstance.displayCart();
        }
    }
    public String checkoutCart(){
        if(cartDaoInstance.isEmpty()){
            return Status.CART_EMPTY+"";
        } else {
            return cartDaoInstance.checkout();
        }
    }
}
