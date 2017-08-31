package com.metacube.Sorters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testSorters {
    int arrayToSort[];
    @Before 
    public void initializeArray() {
        arrayToSort = new int[] {1,5,78,-1,0,-907,1007,1007,1,105,23,5,5,90,88};
    }
    @Test
    public void testQuickSort() {
        int sorted[] = new QuickSort().quickSort(arrayToSort,0,arrayToSort.length-1);
        int expected[] = {-907,-1,0,1,1,5,5,5,23,78,88,90,105,1007,1007};
        assertArrayEquals(expected, sorted);
    }
    @Test
    public void testBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();
        int sorted[] = bubbleSort.bubbleSort(arrayToSort);
        int expected[] = {-907,-1,0,1,1,5,5,5,23,78,88,90,105,1007,1007};
        assertArrayEquals(expected, sorted);
    }
    @Test
    public void testCountingSort() {
        int sorted[] = new CountingSort().sort(arrayToSort);
        int expected[] = {-907,-1,0,1,1,5,5,5,23,78,88,90,105,1007,1007};
        assertArrayEquals(expected, sorted);
    }
    @Test
    public void testRadixSort() {
        int sorted[] = new RadixSort().radixSort(arrayToSort);
        int expected[] = {-907,-1,0,1,1,5,5,5,23,78,88,90,105,1007,1007};
        assertArrayEquals(expected, sorted);
    }

}
