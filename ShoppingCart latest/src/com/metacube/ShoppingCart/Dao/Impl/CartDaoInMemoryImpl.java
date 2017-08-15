package com.metacube.ShoppingCart.Dao.Impl;

import java.util.HashMap;

import com.metacube.ShoppingCart.Dao.CartDao;
import com.metacube.ShoppingCart.TO.CartEntry;

public class CartDaoInMemoryImpl implements CartDao {
    
    private HashMap<String,CartEntry> itemsInCart;
    
    public CartDaoInMemoryImpl() {
        super();
        this.itemsInCart=new HashMap<String, CartEntry>();
    }

    @Override
    public  void addItemToCart(CartEntry cartEntry) {
         itemsInCart.put(cartEntry.getProductId(),cartEntry);
    }

    @Override
    public boolean removeFromCart(String productId) {
        if(itemsInCart.containsKey(productId)){
            itemsInCart.remove(productId);
        } else{
            return false;
        }
        return true;
    }

    @Override
    public String generateBill() {
        String billString="#################Your Order#################\n Entry No.  Product     Quantity    Subtotal \n";
        billString+=displayCart();
        return billString;
    }
    @Override
    public String checkout(){
        String bill=generateBill();
        itemsInCart.clear();
        return bill; 
    }
    @Override
    public String displayCart(){
        String cartString="Cart items: -\n";
        Double totalBill=0.0;
        int itemNumber=1;
        for(CartEntry currentItem:itemsInCart.values()){
            cartString+=(itemNumber++)+"\t"+currentItem.getProductId()+"\t "+
                    currentItem.getQuantity()+" x "+(currentItem.getCostOfOrder()/currentItem.getQuantity())
                    +" = "+currentItem.getCostOfOrder()+"\n";
            totalBill+=currentItem.getCostOfOrder();
        }
        cartString+="\t\t\t\tTotal = "+totalBill;
        return cartString;
    }
    @Override
    public boolean isEmpty(){
        return itemsInCart.isEmpty();
    }
    @Override
    public CartEntry getItemFromCart(String productId){
        return itemsInCart.get(productId);
    }
}
