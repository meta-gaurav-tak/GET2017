package com.metacube.Employee;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestEmployeeCollection {
    EmployeeCollection employeeCollection;
    EmployeeCollectionWithoutDuplicate employeeWithoutDuplicate;
    
    @Before
    public void initialize() {
        employeeCollection = new EmployeeCollection();
        employeeWithoutDuplicate = new EmployeeCollectionWithoutDuplicate();
    }
    
    @Test
    public void testEmployeeCollectionNaturalSort() {
        employeeCollection.add(new Employee(1,"Raj","Manager"));
        employeeCollection.add(new Employee(5,"Abhay","Manager"));
        employeeCollection.add(new Employee(4,"Karan","Manager"));
        employeeCollection.add(new Employee(3,"Abhay","Manager"));
        employeeCollection.add(new Employee(2,"Karan","Manager"));
        employeeCollection.sortNaturalOrder();
        int idCount = 1;
        for(Employee employee : employeeCollection.getEmployeeList()) {    
            assertEquals(idCount++, employee.getId());
        }
    }
    
    @Test
    public void testEmployeeCollectionSortByName() {
        employeeCollection.add(new Employee(1,"Raj","Manager"));
        employeeCollection.add(new Employee(3,"Abhay","Manager"));
        employeeCollection.add(new Employee(2,"Karan","Manager"));
        employeeCollection.add(new Employee(5,"Abhay","Manager"));
        employeeCollection.add(new Employee(4,"Karan","Manager"));
        employeeCollection.add(new Employee(6,"Zorawar","Manager"));
        employeeCollection.sortByName();
        int idInOrder[] = {3,5,2,4,1,6};
        int idCount = 0;
        for(Employee employee : employeeCollection.getEmployeeList()) {    
            assertEquals(idInOrder[idCount++], employee.getId());
        }
    }
    
    @Test
    public void testEmployeeCollectionWithoutDuplicatePositive() {
        employeeWithoutDuplicate.addToSet(new Employee(1,"Raj","Manager"));
        employeeWithoutDuplicate.addToSet(new Employee(1,"Rohit","Developer"));
        employeeWithoutDuplicate.addToSet(new Employee(2,"Ghatak","Manager"));
        employeeWithoutDuplicate.addToSet(new Employee(3,"Raju","Manager"));
        employeeWithoutDuplicate.addToSet(new Employee(3,"Suresh","Tester"));
        assertEquals(3,employeeWithoutDuplicate.getTotalNumberOfEmployees());
    }
    
    @Test
    public void testEmployeeCollectionWithoutDuplicateNegative() {
        employeeWithoutDuplicate.addToSet(new Employee(1,"Raj","Manager"));
        employeeWithoutDuplicate.addToSet(new Employee(1,"Rohit","Developer"));
        employeeWithoutDuplicate.addToSet(new Employee(2,"Ghatak","Manager"));
        employeeWithoutDuplicate.addToSet(new Employee(3,"Raju","Manager"));
        employeeWithoutDuplicate.addToSet(new Employee(3,"Suresh","Tester"));
        assertNotEquals(5,employeeWithoutDuplicate.getTotalNumberOfEmployees());
    }
}
