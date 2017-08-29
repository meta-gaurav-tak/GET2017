package com.metacube.Employee;

public class Employee implements Comparable<Employee> {
    
    private static int idGenerator = 1;        // a static counter that assigns a unique id to employee 
    private int id = idGenerator++;            //holds the unique id
    private String name;
    private String designation;
    
    //getters and setters
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
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    //Constructors
    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }
    public Employee(int id,String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }
    
    /*these two methods need to be overridden 
     * so that collection set can check for duplicacy among object
    *on user defined basis
    **/
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (id != other.id)
            return false;
        return true;
    }
    
    //this method is over-riden to define a basis for natural sorting
    @Override
    public int compareTo(Employee o) {
        return ((Integer)this.id).compareTo((Integer)o.getId());
    }
    
}
