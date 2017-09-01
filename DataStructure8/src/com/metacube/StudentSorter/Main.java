package com.metacube.StudentSorter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.metacube.Exceptions.ArrayUndefinedException;
import com.metacube.Utility.Utility;

public class Main {
    public static void main(String args[]) {
        
        System.out.println("####Sorter for students####");
        System.out.println("Enter total number for student");
        int noOfStudent = Utility.getPositiveIntegerInput();
        Map<Integer,Student> mapOfStudents = new HashMap<Integer,Student>();
        for (int i = 0; i < noOfStudent; i++) {
            System.out.print("Enter Student Name : ");
            String name = Utility.getStringInput();
            int rollNumber;
            do {
                System.out.print("Enter a Unique roll No. : ");
                rollNumber = Utility.getPositiveIntegerInput();
            } while(mapOfStudents.containsKey(rollNumber));
            mapOfStudents.put(rollNumber,new Student(name,rollNumber));
        }
        
        List<Integer> sortedKeySet;
        try {
            sortedKeySet = TreeSorter.treeSort( mapOfStudents.keySet().toArray(new Integer[mapOfStudents.size()]));
            System.out.println(" Sorted order of students :- ");
            for (Integer key : sortedKeySet) {
                System.out.println(mapOfStudents.get(key).getName() + "\t" + mapOfStudents.get(key).getRollNumber()); 
            }
        } catch (ArrayUndefinedException e) {
            System.out.println(e.getMessage());
        }
        
    }
}
