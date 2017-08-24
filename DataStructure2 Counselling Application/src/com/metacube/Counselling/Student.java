package com.metacube.Counselling;

import java.util.Map;
import java.util.TreeMap;

public class Student {
    private String name;
    private int rank;       // using rank as an unique identifier
    private int collegeChoice[];//contains college id of the preferred college in order of their preference
    
    public Student(String name, int rank, int[] collegeChoice) {
        this.name = name;
        this.rank = rank;
        this.collegeChoice = collegeChoice;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public int[] getCollegeChoice() {
        return collegeChoice;
    }
    public void setCollegeChoice(int[] collegeChoice) {
        this.collegeChoice = collegeChoice;
    }
    public static Map<Integer, Student> getStudentMap() {
        return studentMap;
    }
    public static void setStudentMap(Map<Integer, Student> studentMap) {
        Student.studentMap = studentMap;
    }
    
    /*Methods generates object Map that act as our database*/
    
    // using treeMap since we want the values in sorted ascending order of key i.e., rank of student
    public static Map<Integer,Student> studentMap = new TreeMap<Integer,Student>();    
    public static void populateStudentMap() {
        studentMap.put(2,new Student("Shivam Lalwani",2,new int[] {1,4,5}));
        studentMap.put(1,new Student("Udit Saxena",1,new int[] {1,4,2}));
        studentMap.put(3,new Student("Neel Kumar",3,new int[] {1,2,5,3}));
        studentMap.put(4,new Student("Gaurav Tak",4,new int[] {1,5,4}));
        studentMap.put(6,new Student("Prateek Jain",6,new int[] {2,1,4,5}));
        studentMap.put(5,new Student("Mahesh Mathur",5,new int[] {}));     // when a student does not choose any college
        studentMap.put(8,new Student("Shubham Sharma",8,new int[] {1,4,5}));
        studentMap.put(7,new Student("Pawan Mangalani",7,new int[] {1,4,5}));
        studentMap.put(10,new Student("Nilesh Chordia",10,new int[] {5}));
        studentMap.put(9,new Student("Rahul Singh",9,new int[] {1,5,4}));
        studentMap.put(11,new Student("Ronak Rathore",11,new int[] {1,5,3}));
        studentMap.put(12,new Student("Chetan Sharma",12,new int[] {3,1,2,4,5}));
        studentMap.put(13,new Student("Dhawal Jain",13,new int[] {1,2,5}));
        studentMap.put(14,new Student("Hemant Saini",14,new int[] {2,4,1,5,3}));
        studentMap.put(15,new Student("Kunal Gour",15,new int[] {3,2,5,4}));
        studentMap.put(16,new Student("Ramesh Raj",16,new int[] {1,4,5}));
        studentMap.put(17,new Student("Suresh Joshi",17,new int[] {1,4,5}));
        studentMap.put(18,new Student("Jignesh Soni",18,new int[] {1,5}));
        studentMap.put(19,new Student("Rakesh Rajput",19,new int[] {5,4}));
        studentMap.put(20,new Student("Mukesh Ambani",20,new int[] {1,5,3}));
        studentMap.put(21,new Student("Ratan Tata",21,new int[] {3,1,2,4,5}));
        studentMap.put(22,new Student("Shikha Singh",22,new int[] {1,2,5}));
        studentMap.put(23,new Student("Vishakha Tak",23,new int[] {2,4,1,5,3}));
        studentMap.put(24,new Student("Anisha Mathur",24,new int[] {3,2,5,4}));
    }
}

