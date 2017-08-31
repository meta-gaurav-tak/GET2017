package com.metacube.Sorters;

import com.metacube.Utility.Utility;

public class CountingSort {
    
    int count[];
    public int[] sort(int[] arr) {
        int maxValueOfArray = Utility.getMaximumFromArray(arr);
        int minValueOfArray = Utility.getMinimumFromArray(arr);
        System.out.println(maxValueOfArray);
        System.out.println(minValueOfArray);
        count = new int[maxValueOfArray - minValueOfArray+1];
        int output[] = new int[arr.length];
        for (int i=0; i < arr.length; i++) {
            count[arr[i] - minValueOfArray]++; 
        }
        /*int j=0;
        for(int i=0; i<count.length;i++) {
            if(count[i]!=0) {
                while(count[i] != 0){
                output[j++] = i;
                count[i]--;
                }
            }
        }*/
        
        for(int i=1; i<count.length;i++) {
            count[i] += count[i-1];
        }
        for(int i=0; i<count.length;i++) {
            if(count[i] != 0) {
                System.out.println(i + " -->" +count[i]);
            }
        }
        for (int i=output.length - 1; i >= 0; i--) {
            output[count[arr[i] - minValueOfArray] - 1] = arr[i];
            count[arr[i] - minValueOfArray]--;
        }
        return output;
    }
    
    public static void main(String args[]) {
        int arr[] = {1,4,5,6,5,4,6,7,-99,88,22,67,99,1,4,6,6,6,99,88,5};
        CountingSort cs = new CountingSort();
        int output[] = cs.sort(arr);
        for(int i = 0; i<output.length;i++) {
            System.out.print(output[i]+ " ");
        }
        
    }
}
