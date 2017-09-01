package com.metacube.Sorters;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.Exceptions.ArrayUndefinedException;

public class TestSorters {
    int arrayToSort[];
    @Before 
    public void initializeArray() {
        arrayToSort = new int[] {1,5,78,-1,0,-907,1007,1007,1,105,23,5,5,90,88};
    }
    @Test
    public void testQuickSort() {
        int sorted[];
        try {
            sorted = new QuickSort().sort(arrayToSort);
            int expected[] = {-907,-1,0,1,1,5,5,5,23,78,88,90,105,1007,1007};
            assertArrayEquals(expected, sorted);
        } catch (ArrayUndefinedException e) {
            e.getMessage();
        }
        
    }
    @Test
    public void testBubbleSort() {
        int sorted[];
        try {
            sorted = new BubbleSort().sort(arrayToSort);
            int expected[] = {-907,-1,0,1,1,5,5,5,23,78,88,90,105,1007,1007};
            assertArrayEquals(expected, sorted);
        } catch (ArrayUndefinedException e) {
            e.getMessage();
        }
        
    }
    @Test
    public void testCountingSort() {
        int sorted[];
        try {
            sorted = new CountingSort().sort(arrayToSort);
            int expected[] = {-907,-1,0,1,1,5,5,5,23,78,88,90,105,1007,1007};
            assertArrayEquals(expected, sorted);
        } catch (ArrayUndefinedException e) {
           e.getMessage();
        }
    }
    @Test
    public void testRadixSort() {
        int sorted[];
        try {
            sorted = new RadixSort().sort(arrayToSort);
            int expected[] = {-907,-1,0,1,1,5,5,5,23,78,88,90,105,1007,1007};
            assertArrayEquals(expected, sorted);
        } catch (ArrayUndefinedException e) {
            e.getMessage();
        }  
    }
    
    @Test(expected = ArrayUndefinedException.class)
    public void testNullException() throws ArrayUndefinedException {
        new RadixSort().sort(null);
    }
    
    @Test(expected = ArrayUndefinedException.class)
    public void testEmptyException() throws ArrayUndefinedException {
        new QuickSort().sort(new int[] {});
    }
}
