package com.metacube.Sorters;

import com.metacube.Exceptions.ArrayUndefinedException;
import com.metacube.Utility.Utility;


public class RadixSort implements ArraySorter {
    /**
     * This is an overridden sort method that sorts using Radix  sort
     */
    @Override
    public int[] sort(int arrayToSort[]) throws ArrayUndefinedException {
        if(arrayToSort == null || arrayToSort.length == 0) {
            throw new ArrayUndefinedException("The array to sort is either empty or null");
        }

        int minValueOfArray = Utility.getMinimumFromArray(arrayToSort);
        int currentPlace = 1;
        /*
         * to deal with negative values
         * make all array elements positive by adding minimum value
         */
        if(minValueOfArray < 0) {
            for(int i = 0; i < arrayToSort.length; i++ ) {
                arrayToSort[i] = arrayToSort[i] - minValueOfArray;
            }
        }
        /*
         * Perform counting sort for each decimal place
         */
        while(Utility.getMaximumFromArray(arrayToSort)/currentPlace > 0) {
            arrayToSort = countingSortDecimalBase10(arrayToSort,currentPlace);
            currentPlace *= 10;
        }
        /*
         * if negative values occurred
         * restore the negative values
         */
        if(minValueOfArray < 0) {
            for(int i = 0; i < arrayToSort.length; i++ ) {
                arrayToSort[i] = arrayToSort[i] + minValueOfArray;
            }
        }
        return arrayToSort;
    }
    
    /*
     * Counting sort for a decimal base 10 numbers by digits' place
     */
    public int[] countingSortDecimalBase10(int[] arr, int currentPlace) {
        int count[] = new int[19];
        int output[] = new int[arr.length];
        for (int i=0; i < arr.length; i++) {
            count[(arr[i] / currentPlace) % 10]++; 
        }
        
        for(int i=1; i<count.length;i++) {
            count[i] += count[i-1];
        }

        for (int i=output.length-1; i>=0; i--) {
            output[count[( arr[i] / currentPlace ) % 10] - 1] = arr[i];
            count[(arr[i] / currentPlace) % 10]--;
        }
        return output;
    }
    
    /*public static void main(String args[]) {
        int arr[] = {1,5,802,401,555,4,6,-905,7,88,22,67,99,1,99,88,5};
        RadixSort cs = new RadixSort();
        int output[] = cs.sort(arr);
        for(int i = 0; i<output.length;i++) {
            System.out.print(output[i]+ " ");
        }*/
        
    
}
