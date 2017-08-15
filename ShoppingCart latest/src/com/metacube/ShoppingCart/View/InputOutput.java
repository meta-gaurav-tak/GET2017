package com.metacube.ShoppingCart.View;

import java.util.Scanner;

import com.metacube.ShoppingCart.Controller.ShoppingStoreController;
import com.metacube.ShoppingCart.Facade.CartFacade;
import com.metacube.ShoppingCart.Facade.ProductFacade;
import com.metacube.ShoppingCart.TO.CartEntry;

public class InputOutput {
    //Display the view and takes input and renders output
    public static void displayMenu(ProductFacade productOperations,CartFacade shoppingCart){
        int productCount=1;
        Scanner sc=new Scanner(System.in);
        CartEntry cartEntry;
        while(true){
            System.out.println();
            System.out.println("Welcome to Shopping Store");
            System.out.println("Enter Your Choice");
            System.out.println("1. Add To Cart\n2. Remove From cart\n3. DisplayCart\n4. Checkout\n0. Exit ");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    cartEntry=new CartEntry();
                    cartEntry.setEntryNumber(productCount++);
                    do{
                        System.out.println("enter a valid product id from the list");
                        cartEntry.setProductId(sc.next());
                    }while(productOperations.getProductById(cartEntry.getProductId())==null);
                    do{
                        System.out.println("Enter a valid quantity for product");
                        cartEntry.setQuantity(sc.nextInt());
                    }while(cartEntry.getQuantity()<1);
                    //call to controller
                    System.out.println(ShoppingStoreController.addProductCart(cartEntry, productOperations, shoppingCart));
                    break;
                case 2:
                    cartEntry=new CartEntry();
                    cartEntry.setProductId(sc.next());
                    System.out.println(ShoppingStoreController.removeProductCart(cartEntry, productOperations, shoppingCart));
                case 3:
                    System.out.println(ShoppingStoreController.displayCart(productOperations, shoppingCart));
                    break;
                case 4:
                    System.out.println(ShoppingStoreController.checkout(productOperations, shoppingCart));
                    break;
                case 0:
                    System.exit(0);  
            }
        }
    }
}
