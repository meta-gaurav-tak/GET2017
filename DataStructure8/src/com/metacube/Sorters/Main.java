package com.metacube.Sorters;

import com.metacube.Utility.Utility;

public class Main {
    public static void main(String args[]) {
        
        System.out.println("Enter the size of array ");
        int arraySize = Utility.getIntegerInput();
        int [] arrayToSort = new int [arraySize]; //deal negative array size 
        
        System.out.println(" Enter an integer array ");
        for (int i = 0; i < arrayToSort.length; i++) {
            arrayToSort[i] = Utility.getIntegerInput();
        }
        do {
        Utility.printMenu();
        int choice = Utility.getChoiceInput();
        
        switch(choice) {
            case 1:
                System.out.println("Enter the size of array ");
                arraySize = Utility.getIntegerInput();
                arrayToSort = new int [arraySize];
                
                System.out.println(" Enter an integer array ");
                for (int i = 0; i < arrayToSort.length; i++) {
                    arrayToSort[i] = Utility.getIntegerInput();
                }
                break;
            case 2:
                if(arrayToSort.length <= 10) {
                    System.out.println("//continue with bubble sort");
                    BubbleSort sort = new BubbleSort();
                    arrayToSort = sort.bubbleSort(arrayToSort);
                } else {
                    System.out.println("Quicksort");
                    QuickSort sort = new QuickSort();
                    arrayToSort = sort.quickSort(arrayToSort,0,arrayToSort.length-1);
                    // continue with quicksort
                }
                printArray(arrayToSort);
                break;
            case 3:
                if(Utility.getMaximumFromArray(arrayToSort)/100 >0) {
                    System.out.println("Radix sort");
                    // continue with radix sort
                    RadixSort radixSorter = new RadixSort();
                    arrayToSort = radixSorter.radixSort(arrayToSort);
                } else {
                    System.out.println("Counting Sort");
                    //continue with counting sort
                    CountingSort countingSorter = new CountingSort();
                    arrayToSort = countingSorter.sort(arrayToSort);
                }
                printArray(arrayToSort);
                break;
            case 4:
                System.out.println("Thank you for using this Sorter");
                System.exit(0);
        }
        }while(true);
        
    }
    
    private static void printArray(int[] array) {
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + " ");
        }
        System.out.println();
    }
}
