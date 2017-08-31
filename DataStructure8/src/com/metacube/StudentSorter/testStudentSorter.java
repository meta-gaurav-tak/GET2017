package com.metacube.StudentSorter;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class testStudentSorter {

    @Test
    public void testStudentSortingPositive() {
        Map<Integer,Student> mapOfStudents = new HashMap<Integer,Student>();
        mapOfStudents.put(6,new Student("dheeraj",6));
        mapOfStudents.put(8,new Student("dheeraj",8));
        mapOfStudents.put(1,new Student("dheeraj",1));
        mapOfStudents.put(3,new Student("dheeraj",3));
        mapOfStudents.put(7,new Student("dheeraj",7));
        List<Integer> sortedKeySet = TreeSorter.treeSort( mapOfStudents.keySet().toArray(new Integer[mapOfStudents.size()]));
        int arr[] = new int[]{1,3,6,7,8};
        int i=0;
        for (Integer key : sortedKeySet) {
            assertEquals(arr[i++],(int)mapOfStudents.get(key).getRollNumber()); 
        }
    }
    @Test
    public void testTreeSorterPositive() {
        Integer array[] = new Integer[]{45,45,89,7,90};
        Object expected[] = new Integer[]{7,45,45,89,90};
        Object actual[] = TreeSorter.treeSort(array).toArray();
        assertArrayEquals(expected, actual);
    }
    
    @Test
    public void testStudentSortingNegative() {
        Map<Integer,Student> mapOfStudents = new HashMap<Integer,Student>();
        mapOfStudents.put(6,new Student("dheeraj",6));
        mapOfStudents.put(8,new Student("dheeraj",8));
        mapOfStudents.put(1,new Student("dheeraj",1));
        mapOfStudents.put(3,new Student("dheeraj",3));
        mapOfStudents.put(7,new Student("dheeraj",7));
        List<Integer> sortedKeySet = TreeSorter.treeSort( mapOfStudents.keySet().toArray(new Integer[mapOfStudents.size()]));
        int arr[] = new int[]{6,8,1,3,7};
        int i=0;
        for (Integer key : sortedKeySet) {
            assertNotEquals(arr[i++],(int)mapOfStudents.get(key).getRollNumber()); 
        }
    }
    @Test
    public void testTreeSorterNegative() {
        Integer array[] = new Integer[]{45,45,89,7,90};
        Object expected[] = new Integer[]{45,45,89,7,90};
        Object actual[] = TreeSorter.treeSort(array).toArray();
        assertFalse(expected==actual);
    }
}
