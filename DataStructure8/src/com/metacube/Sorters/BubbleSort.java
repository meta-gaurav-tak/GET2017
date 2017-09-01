package com.metacube.Sorters;

import com.metacube.Exceptions.ArrayUndefinedException;

public class BubbleSort implements ArraySorter {
    /**
     * This is an overridden sort method that sorts using bubble sort
     */
    @Override
    public int[] sort(int[] arrayToSort) throws ArrayUndefinedException {
        if(arrayToSort == null || arrayToSort.length == 0) {
            throw new ArrayUndefinedException("The array to sort is either empty or null");
        }
        for(int passIndex = 0; passIndex < arrayToSort.length; passIndex++) {
            for(int internalIndex = 1; internalIndex < arrayToSort.length - passIndex; internalIndex++) {   //reducing iterations in each pass
                if( arrayToSort[internalIndex-1] > arrayToSort[internalIndex] ) {
                    int temp = arrayToSort[internalIndex-1];
                    arrayToSort[internalIndex-1] = arrayToSort[internalIndex];
                    arrayToSort[internalIndex] = temp;
                }
            }
        }
        return arrayToSort;
    }
    /*public static void main(String args[]) {
        BubbleSort sort = new BubbleSort();
        int arr[] = {1,5,78,-1,0,-907,1007,1007,1,105,23,5,5,90,88};
        int output[] = sort.sort(arr);
        for(int i = 0; i<output.length;i++) {
            System.out.print(output[i]+ ",");
        }
    }*/
}
