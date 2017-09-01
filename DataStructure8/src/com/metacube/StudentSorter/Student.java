package com.metacube.StudentSorter;
/**
 * Student POJO
 * @author Gaurav Tak
 *
 */
public class Student {
    private String name;
    private int rollNumber;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }
    public Student(String name, int rollNumber) {
        super();
        this.name = name;
        this.rollNumber = rollNumber;
    }
    public Student() {
        super();
    }
    
}
