package com.metacube.Employee;

import java.util.HashSet;
import java.util.Set;

public class EmployeeCollectionWithoutDuplicate {
    Set<Employee> employeeSet = new HashSet<Employee>();

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
    
    /**
     *Method to add an employee to collection 
     * @param employeeToAdd employee object to add
     */
    public void addToSet(Employee employeeToAdd) {
        employeeSet.add(employeeToAdd);
    }
    
    /*
     * Other collection methods
     */
    public void remove(Employee employeeToRemove) {
        employeeSet.remove(employeeToRemove);
    }
    public boolean isEmpty() {
        return employeeSet.isEmpty();
    }
    public boolean contains(Employee employeeToCheck) {
        return employeeSet.contains(employeeToCheck);
    }
    public int getTotalNumberOfEmployees() {
        return employeeSet.size();
    }
}
