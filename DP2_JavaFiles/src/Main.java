package com.metacube.ShoppingCart;
import com.metacube.ShoppingCart.Facade.CartFacade;
import com.metacube.ShoppingCart.Facade.ProductFacade;
import com.metacube.ShoppingCart.View.InputOutput;

public class Main {
    public static void main(String args[]){
        CartFacade shoppingCart=new CartFacade();
        ProductFacade productOperations=new ProductFacade();
        productOperations.readProductsFromFile();
        //to display input menu , take inputs and render output
        InputOutput.displayMenu(productOperations, shoppingCart);
    }
}
