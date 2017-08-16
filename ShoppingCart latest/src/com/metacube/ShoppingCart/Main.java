package com.metacube.ShoppingCart;

import com.metacube.ShoppingCart.Facade.FacadeFactory;
import com.metacube.ShoppingCart.Facade.ProductFacade;
import com.metacube.ShoppingCart.View.InputOutput;

public class Main {

    public static void main(String args[]){
        
        ProductFacade productOperations=FacadeFactory.getProductFacadeDaoInstance();
        productOperations.readProductsFromFile();
        //to display input menu , take inputs and render output
        InputOutput.displayMenu(productOperations);
    }
}
