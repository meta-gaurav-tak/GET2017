package com.metacube.Sorters;

import com.metacube.Exceptions.ArrayUndefinedException;
import com.metacube.Utility.Utility;

public class Main {
    public static void main(String args[]) {
        ArraySorter sorterObject;
        
        System.out.println("Enter the size of array ");
        int arraySize = Utility.getPositiveIntegerInput();
        int [] arrayToSort = new int [arraySize]; 
        
        System.out.println(" Enter an integer array ");
        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = Utility.getIntegerInput();
        }
        
        do {
        
            Menu.printMenu();
            int choice = Utility.getChoiceInput();
            
            switch(choice) {
            
                case 1:
                    System.out.println("Enter the size of array ");
                    arraySize = Utility.getPositiveIntegerInput();
                    arrayToSort = new int [arraySize];
                    
                    System.out.println(" Enter an integer array ");
                    for (int i = 0; i < arrayToSort.length; i++) {
                        arrayToSort[i] = Utility.getIntegerInput();
                    }
                    break;
                    
                case 2:
                    if(arrayToSort.length <= 10) {    
                        sorterObject = new BubbleSort();
                        try {
                            arrayToSort = sorterObject.sort(arrayToSort);
                        } catch (ArrayUndefinedException e) {
                            e.getMessage();
                        }
                        printArray(arrayToSort,"Bubble Sort");
                    } else {
                        sorterObject = new QuickSort();
                        try {
                            arrayToSort = sorterObject.sort(arrayToSort);
                        } catch (ArrayUndefinedException e) {
                            e.getMessage();
                        }
                        printArray(arrayToSort,"Quick Sort");
                    }        
                    break;
                    
                case 3:
                    if(Utility.getMaximumFromArray(arrayToSort)/100 >0) {
                        // continue with radix sort
                        sorterObject = new RadixSort();
                        try {
                            arrayToSort = sorterObject.sort(arrayToSort);
                        } catch (ArrayUndefinedException e) {
                            e.getMessage();
                        }
                        printArray(arrayToSort,"Radix Sort");
                    } else {
                       //continue with counting sort
                        sorterObject = new CountingSort();
                        try {
                            arrayToSort = sorterObject.sort(arrayToSort);
                        } catch (ArrayUndefinedException e) {
                            e.getMessage();
                        }
                        printArray(arrayToSort,"Counting Sort");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using this Sorter");
                    System.exit(0);
            }
        }while(true);
        
    }
    
    private static void printArray(int[] array, String sortingTechnique) {
        System.out.println("System has used " +sortingTechnique+" sorting technique and sorted list as below :");
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + " ");
        }
        System.out.println();
    }
}
