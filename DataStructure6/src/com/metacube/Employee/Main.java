package com.metacube.Employee;

public class Main {
    public static void main(String args[]) {
        EmployeeCollection employeeCollection = new EmployeeCollection();
        employeeCollection.add(new Employee(1,"Raj","Manager"));
        employeeCollection.add(new Employee(2,"Abhay","Manager"));
        employeeCollection.add(new Employee(4,"Karan","Manager"));
        employeeCollection.add(new Employee(3,"Abhay","Manager"));
        employeeCollection.add(new Employee(7,"Karan","Manager"));
        employeeCollection.remove(new Employee(1,"Raj","Manager"));
        //employeeCollection.sortByName();
        for(Employee e : employeeCollection.getEmployeeList()) {
            System.out.println(e.getId());
        }
        
        
       EmployeeCollectionWithoutDuplicate employeeCollectionSet = new EmployeeCollectionWithoutDuplicate();
        employeeCollectionSet.addToSet(new Employee(4,"Raj","Manager"));
        employeeCollectionSet.addToSet(new Employee(4,"Rohit","Manager"));
        employeeCollectionSet.addToSet(new Employee(5,"Rohit","Manager"));
        employeeCollectionSet.addToSet(new Employee(2,"Ramesh","Manager"));
        employeeCollectionSet.addToSet(new Employee(4,"Raj","Manager"));
        employeeCollectionSet.addToSet(new Employee(4,"Rohit","Manager"));
        employeeCollectionSet.addToSet(new Employee(5,"Rohit","Manager"));
        employeeCollectionSet.addToSet(new Employee(2,"Ramesh","Manager"));
        
        for(Employee e : employeeCollectionSet.getEmployeeSet()) {
            System.out.println(e.getName());
        }
    }
}
