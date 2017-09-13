package com.metacube.Utility;

import java.util.Scanner;

public class Utility {
    private static Scanner scan = new Scanner(System.in);
    
    public static String getStringInput() {
        return scan.nextLine().trim();
    }
    
    public static int getChoiceInput() {
        boolean flag = true;
        int value = 0;
        do {
            try {
                value = Integer.parseInt(scan.nextLine());
                if(String.class.isInstance(value) || value < 1 || value > 4) {
                    throw new NumberFormatException();
                }
                flag = false;
            } catch(NumberFormatException e) {
                System.out.println("Enter a valid choice ");
            }
        } while(flag);
        
        return value;    
    }
}
