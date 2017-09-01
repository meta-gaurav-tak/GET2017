package com.metacube.StudentSorter;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.metacube.Exceptions.ArrayUndefinedException;

public class TestStudentSorter {

    @Test
    public void testStudentSortingPositive() {
        Map<Integer,Student> mapOfStudents = new HashMap<Integer,Student>();
        mapOfStudents.put(6,new Student("dheeraj",6));
        mapOfStudents.put(8,new Student("neeraj",8));
        mapOfStudents.put(1,new Student("veeraj",1));
        mapOfStudents.put(3,new Student("eeraj",3));
        mapOfStudents.put(7,new Student("raj",7));
        List<Integer> sortedKeySet;
        try {
            sortedKeySet = TreeSorter.treeSort( mapOfStudents.keySet().toArray(new Integer[mapOfStudents.size()]));
            int arr[] = new int[]{1,3,6,7,8};
            int i=0;
            for (Integer key : sortedKeySet) {
                assertEquals(arr[i++],(int)mapOfStudents.get(key).getRollNumber()); 
            }
        } catch (ArrayUndefinedException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testTreeSorterPositive() {
        Integer array[] = new Integer[]{45,45,89,7,90};
        Object expected[] = new Integer[]{7,45,45,89,90};
        Object actual[];
        try {
            actual = TreeSorter.treeSort(array).toArray();
            assertArrayEquals(expected, actual);
        } catch (ArrayUndefinedException e) {
            e.getMessage();
        } 
    }
    
    @Test
    public void testStudentSortingNegative() {
        Map<Integer,Student> mapOfStudents = new HashMap<Integer,Student>();
        mapOfStudents.put(6,new Student("dheeraj",6));
        mapOfStudents.put(8,new Student("heeraj",8));
        mapOfStudents.put(1,new Student("eraj",1));
        mapOfStudents.put(3,new Student("raj",3));
        mapOfStudents.put(7,new Student("dheer",7));
        List<Integer> sortedKeySet;
        try {
            sortedKeySet = TreeSorter.treeSort( mapOfStudents.keySet().toArray(new Integer[mapOfStudents.size()]));
            int arr[] = new int[]{6,8,1,3,7};
            int i=0;
            for (Integer key : sortedKeySet) {
                assertNotEquals(arr[i++],(int)mapOfStudents.get(key).getRollNumber()); 
            }
        } catch (ArrayUndefinedException e) {
           e.getMessage();
        }
        
    }
    
    @Test
    public void testTreeSorterNegative() {
        Integer array[] = new Integer[]{45,45,89,7,90};
        Object expected[] = new Integer[]{45,45,89,7,90};
        Object actual[];
        try {
            actual = TreeSorter.treeSort(array).toArray();
            assertFalse(expected==actual);
        } catch (ArrayUndefinedException e) {
            e.printStackTrace();
        }
    }
    
    @Test(expected = ArrayUndefinedException.class)
    public void testTreeSorterNullException() throws ArrayUndefinedException {
        Integer array[] = null;
        TreeSorter.treeSort(array).toArray();
    }
    
    @Test(expected = ArrayUndefinedException.class)
    public void testTreeSorterEmptyException() throws ArrayUndefinedException {
        Integer array[] = {};
        TreeSorter.treeSort(array).toArray();
    }
}
