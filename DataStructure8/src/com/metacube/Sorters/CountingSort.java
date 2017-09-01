package com.metacube.Sorters;

import com.metacube.Exceptions.ArrayUndefinedException;
import com.metacube.Utility.Utility;

public class CountingSort implements ArraySorter{
    
    int count[];            //holds the count/frequency for each number in the array
    /**
     * This is an overridden sort method that sorts using Counting  sort
     */
    @Override
    public int[] sort(int[] arrayToSort) throws ArrayUndefinedException {
        if(arrayToSort == null || arrayToSort.length == 0) {
            throw new ArrayUndefinedException("The array to sort is either empty or null");
        }
        int maxValueOfArray = Utility.getMaximumFromArray(arrayToSort);
        int minValueOfArray = Utility.getMinimumFromArray(arrayToSort);
        count = new int[maxValueOfArray - minValueOfArray+1];
        int output[] = new int[arrayToSort.length];
        for (int i=0; i < arrayToSort.length; i++) {
            count[arrayToSort[i] - minValueOfArray]++; 
        }
        //one more logic
        /*int j=0;
        for(int i=0; i<count.length;i++) {
            if(count[i]!=0) {
                while(count[i] != 0){
                output[j++] = i;
                count[i]--;
                }
            }
        }*/
        
        //store a cumulative count for the number so that it represents its last index in the sorted array
        for(int i=1; i<count.length;i++) {
            count[i] += count[i-1];
        }
        
        for (int i=output.length - 1; i >= 0; i--) {
            //put the array element at its proper index in sorted order
            output[count[arrayToSort[i] - minValueOfArray] - 1] = arrayToSort[i];  
            count[arrayToSort[i] - minValueOfArray]--;
        }
        return output;
    }
    
    /*public static void main(String args[]) {
        int arr[] = {1,4,5,6,5,4,6,7,-99,88,22,67,99,1,4,6,6,6,99,88,5};
        CountingSort cs = new CountingSort();
        int output[] = cs.sort(arr);
        for(int i = 0; i<output.length;i++) {
            System.out.print(output[i]+ " ");
        }*/
        
}
