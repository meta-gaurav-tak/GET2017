package com.metacube.employee;
import java.io.Serializable;
/**
 * Employee POJO class that can be serialized
 * @author Gaurav Tak
 *
 */
public class Employee implements Serializable { 
    private static final long serialVersionUID = 1L; // serialization id need to be provided for serialization
    
    private int id;
    private String name;
    private int age;
    
    public Employee(){}
    public Employee(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }
    
    //getters setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    } 
} 