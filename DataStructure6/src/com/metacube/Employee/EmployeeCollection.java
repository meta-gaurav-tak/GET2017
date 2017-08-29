package com.metacube.Employee;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmployeeCollection {
    
    List<Employee> employeeList = new LinkedList<Employee>();
    
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    
    /**
     * method to sort the employee list based on natural order
     */
    public void sortNaturalOrder() {
        Collections.sort(employeeList);
    }
    
    /**
     * method to sort the employee list based on a comparator object
     * here we use name comparator that sorts on basis of name of employee
     */
    public void sortByName() {
        Collections.sort(employeeList, new NameComparator<Employee>());
    }
    
    /**
     *Method to add an employee to collection 
     * @param employeeToAdd employee object to add
     */
    public void add(Employee employeeToAdd) {
        employeeList.add(employeeToAdd);
    }
    
    /*
     * Other collection methods
     */
    public void remove(Employee employeeToRemove) {
        employeeList.remove(employeeToRemove);
    }
    public boolean isEmpty() {
        return employeeList.isEmpty();
    }
    public boolean contains(Employee employeeToCheck) {
        return employeeList.contains(employeeToCheck);
    }
    public int getTotalNumberOfEmployees() {
        return employeeList.size();
    }
}
