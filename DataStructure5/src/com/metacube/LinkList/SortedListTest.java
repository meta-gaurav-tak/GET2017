package com.metacube.LinkList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SortedListTest {
    SortedLikList<Integer> sll;
    @Before
    public void initiateSortedList() {
        sll = new SortedLikList<Integer>();
    }
    
    @Test
    public void addToListTest() {
        sll.add(1);
        sll.add(5);
        sll.add(3);
        sll.add(1);
        sll.add(-1);
        sll.add(-5);
        sll.add(7);
        sll.add(0);
        String actual = sll.getSortedList().toString();
        String expected = "[-5, -1, 0, 1, 1, 3, 5, 7]";
        assertEquals(expected,actual);
    }
    
    @Test
    public void addToListTestNegative() {
        sll.add(1);
        sll.add(5);
        sll.add(3);
        sll.add(1);
        sll.add(7);
        sll.add(0);
        sll.add(-1);
        sll.add(-5);
        String actual = sll.getSortedList().toString();
        String expected = "[1, 5, 3, 1, 7, 0, -1, -5]";
        assertNotEquals(expected,actual);
    }
}
