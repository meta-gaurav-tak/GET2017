package com.metacube.Utility;


import java.util.Scanner;

public class Utility {
    private static Scanner scan = new Scanner(System.in);
    
    public static int getIntegerInput() {
        boolean flag = true;
        int value = 0;
        do {
            try {
                value = Integer.parseInt(scan.nextLine());
                if(String.class.isInstance(value)) {
                    throw new NumberFormatException();
                }
                flag = false;
            } catch(NumberFormatException e) {
                System.out.println(" Enter an integer value ");
            }
        } while(flag);
        return value;    
    }
    public static String getStringInput() {
        return scan.nextLine().trim();
    }
    public static int getPositiveIntegerInput() {
        boolean flag = true;
        int value = 0;
        do {
            try {
                value = Integer.parseInt(scan.nextLine());
                if(String.class.isInstance(value) && value <= 0) {
                    throw new NumberFormatException();
                }
                flag = false;
            } catch(NumberFormatException e) {
                System.out.println(" Enter an integer value ");
            }
        } while(flag);
        
        return value;   
    }
    public static int getMaximumFromArray(int[] array) {
        int max = array[0];
        for (int count = 1; count < array.length; count++) {
            if (max < array[count]) {
                max = array[count];
            }
        }

        return max;
    }
    public static int getMinimumFromArray(int[] array) {
        int min = array[0];
        for (int count = 1; count < array.length; count++) {
            if (min > array[count]) {
                min = array[count];
            }
        }

        return min;
    }
    public static void printMenu(){
        System.out.println("1. Update the array");
        System.out.println("2. Comparison Sorting");
        System.out.println("3. Linear Sorting");
        System.out.println("4. Exit");
    }
    
    public static int getChoiceInput() {
        boolean flag = true;
        int value = 0;
        do {
            try {
                value = Integer.parseInt(scan.next());
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
