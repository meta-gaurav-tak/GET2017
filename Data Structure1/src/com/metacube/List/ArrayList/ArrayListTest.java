package com.metacube.List.ArrayList;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayListTest {
    ArrayListImplementation<Integer> arrayListObject;
    @Test
    public void listAddTest() {
        arrayListObject = new ArrayListImplementation<Integer>();
        arrayListObject.add(new Integer(2));
        arrayListObject.add(new Integer(5));
        arrayListObject.add(new Integer(1));
        arrayListObject.add(new Integer(23));
        arrayListObject.add(new Integer(14));
        assertEquals(new Integer(5),arrayListObject.get(1));
    }
    @Test
    public void retriveTest() {
        arrayListObject = new ArrayListImplementation<Integer>();
        arrayListObject.add(new Integer(2));
        arrayListObject.add(new Integer(5));
        arrayListObject.add(new Integer(1));
        arrayListObject.add(new Integer(23));
        arrayListObject.add(new Integer(14));
        assertEquals(3,arrayListObject.retrieve(23));
    }
    @Test
    public void retrieveAfterTest() {
        arrayListObject = new ArrayListImplementation<Integer>();
        arrayListObject.add(new Integer(2));
        arrayListObject.add(new Integer(5));
        arrayListObject.add(new Integer(1));
        arrayListObject.add(new Integer(23));
        arrayListObject.add(new Integer(14));
        arrayListObject.add(new Integer(1));
        assertEquals(5,arrayListObject.retrieve(1,3));
    }
    @Test
    public void removeTest() {
        arrayListObject = new ArrayListImplementation<Integer>();
        arrayListObject.add(new Integer(2));
        arrayListObject.add(new Integer(5));
        arrayListObject.add(new Integer(1));
        arrayListObject.add(new Integer(23));
        arrayListObject.add(new Integer(14));
        arrayListObject.add(new Integer(1));
        assertTrue(23==arrayListObject.remove(3));
    }
    @Test
    public void addAnotherListTest() {
        arrayListObject = new ArrayListImplementation<Integer>();
        arrayListObject.add(new Integer(2));
        arrayListObject.add(new Integer(5));
        arrayListObject.add(new Integer(1));
        arrayListObject.add(new Integer(23));
        arrayListObject.add(new Integer(14));
        arrayListObject.add(new Integer(1));
        ArrayListImplementation<Integer> arrayListObject2 = new ArrayListImplementation<Integer>();
        arrayListObject2.add(new Integer(3));
        arrayListObject2.add(new Integer(8));
        arrayListObject2.add(new Integer(19));
        arrayListObject2.add(new Integer(2));
        arrayListObject2.add(new Integer(14));
        arrayListObject.addList(arrayListObject2);
        int actualSize=arrayListObject.getActualSize();
        assertEquals(11,actualSize);
    }
    @Test
    public void reverseListTest() {
        arrayListObject = new ArrayListImplementation<Integer>();
        arrayListObject.add(new Integer(2));
        arrayListObject.add(new Integer(5));
        arrayListObject.add(new Integer(1));
        arrayListObject.add(new Integer(23));
        arrayListObject.add(new Integer(14));
        arrayListObject.add(new Integer(1));
        ArrayListImplementation<Integer> arrayListObject2 = new ArrayListImplementation<Integer>();
        arrayListObject2.add(new Integer(1));
        arrayListObject2.add(new Integer(14));
        arrayListObject2.add(new Integer(23));
        arrayListObject2.add(new Integer(1));
        arrayListObject2.add(new Integer(5));
        arrayListObject2.add(new Integer(2));
        arrayListObject.reverse();
        for(int i=0;i<arrayListObject.getActualSize();i++) {
            assertEquals(arrayListObject.get(i),arrayListObject2.get(i));
        }
    }
    @Test
    public void sortListTest() {
        arrayListObject = new ArrayListImplementation<Integer>();
        arrayListObject.add(new Integer(2));
        arrayListObject.add(new Integer(5));
        arrayListObject.add(new Integer(1));
        arrayListObject.add(new Integer(23));
        arrayListObject.add(new Integer(14));
        ArrayListImplementation<Integer> arrayListObjectSorted = new ArrayListImplementation<Integer>();
        arrayListObjectSorted.add(new Integer(1));
        arrayListObjectSorted.add(new Integer(2));
        arrayListObjectSorted.add(new Integer(5));
        arrayListObjectSorted.add(new Integer(14));
        arrayListObjectSorted.add(new Integer(23));
        arrayListObject.sort();
        for(int i=0;i<arrayListObject.getActualSize();i++) {
            assertEquals(arrayListObjectSorted.get(i),arrayListObject.get(i));
        }
    }
}
