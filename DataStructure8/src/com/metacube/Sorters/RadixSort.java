package com.metacube.Sorters;

import com.metacube.Utility.Utility;


public class RadixSort {
    public int[] radixSort(int arr[]) {

        int minValueOfArray = Utility.getMinimumFromArray(arr);
        int currentPlace = 1;
        if(minValueOfArray < 0) {
            for(int i = 0; i < arr.length; i++ ) {
                arr[i] = arr[i] - minValueOfArray;
            }
        }
        while(Utility.getMaximumFromArray(arr)/currentPlace > 0) {
            arr = countingSortDecimalBase10(arr,currentPlace);
            currentPlace *= 10;
        }
        if(minValueOfArray < 0) {
            for(int i = 0; i < arr.length; i++ ) {
                arr[i] = arr[i] + minValueOfArray;
            }
        }
        return arr;
    }
    
    
    public int[] countingSortDecimalBase10(int[] arr, int currentPlace) {
        int count[] = new int[19];
      
        //System.out.println(minValueMSD);
        int output[] = new int[arr.length];
        for (int i=0; i < arr.length; i++) {
            count[(arr[i]/currentPlace)%10]++; 
        }
        
        for(int i=1; i<count.length;i++) {
            count[i] += count[i-1];
        }

        for (int i=output.length-1; i>=0; i--) {
            output[count[(arr[i]/currentPlace)%10]-1] = arr[i];
            count[(arr[i]/currentPlace)%10]--;
        }
        return output;
    }
    
    public static void main(String args[]) {
        int arr[] = {1,5,802,401,555,4,6,-905,7,88,22,67,99,1,99,88,5};
        RadixSort cs = new RadixSort();
        int output[] = cs.radixSort(arr);
        for(int i = 0; i<output.length;i++) {
            System.out.print(output[i]+ " ");
        }
        
    }
}
