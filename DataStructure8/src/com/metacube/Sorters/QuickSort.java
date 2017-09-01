package com.metacube.Sorters;

import com.metacube.Exceptions.ArrayUndefinedException;

public class QuickSort implements ArraySorter {
    /**
     * This is an overridden sort method that sorts using Quick sort
     */
    @Override
    public int[] sort(int[] arrayToSort) throws ArrayUndefinedException {
        if(arrayToSort == null || arrayToSort.length == 0) {
            throw new ArrayUndefinedException("The array to sort is either empty or null");
        }
        return quickSort(arrayToSort,0,arrayToSort.length - 1);
    }
    /**
     * This method performs re-arrangemnt of pivot element to its actual location in the sorted order 
     * @param startIndex
     * @param endIndex
     * @return the index location of pivot in sorted order
     */
    public int sortPartition(int[] arrayToSort, int startIndex, int endIndex) {
        int pivotIndex=startIndex;
        int leftIndexer=startIndex+1;
        int rightIndexer=endIndex;
        while(leftIndexer<rightIndexer)    {
            /*loop while find any element smaller than pivot is found*/
            while(arrayToSort[rightIndexer]>=arrayToSort[pivotIndex] && rightIndexer>leftIndexer) {
                rightIndexer--;
            }
            /*loop while find any element greater than pivot is found*/
            while(arrayToSort[leftIndexer]<=arrayToSort[pivotIndex] && rightIndexer>leftIndexer) {
                leftIndexer++;
            }
            /*swapping the right and left pointer elements*/
            if(rightIndexer>leftIndexer) {
                int temp=arrayToSort[leftIndexer];
                arrayToSort[leftIndexer]=arrayToSort[rightIndexer];
                arrayToSort[rightIndexer]=temp;
            }
        }
        /*Swapping to shift pivot to its correct location in sorted order*/
        if(arrayToSort[rightIndexer]<arrayToSort[pivotIndex]) {
            int temp=arrayToSort[rightIndexer];
            arrayToSort[rightIndexer]=arrayToSort[pivotIndex];
            arrayToSort[pivotIndex]=temp;
            pivotIndex=rightIndexer;
        }
        return pivotIndex;
    }
    /**
     * This method is the divide and conquer approach of quicksort i.e.. recursive quicksort logic
     * @param startIndex
     * @param endIndex
     */
    public int[] quickSort(int[] arrayToSort,int startIndex,int endIndex) {
        int pivotIndex;
        if(startIndex>=endIndex) {
            return arrayToSort;
        } else {
            pivotIndex=sortPartition(arrayToSort,startIndex,endIndex);
            quickSort(arrayToSort,startIndex,pivotIndex-1);    // Recursively call quick sort with left part of the partitioned array
            quickSort(arrayToSort,pivotIndex+1,endIndex);    // Recursively call quick sort with right part of the partitioned array
            return arrayToSort;
        }
}
    
}
