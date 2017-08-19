package com.metacube.employee;

/**
 * a class generated to test an use employee functionality locally by developer
 * @author Gaurav Tak
 *
 */
public class Main {
    public static void main(String args[]){
        Employee employee=new Employee();
        employee.setId(1);
        employee.setName("gaurav");
        employee.setAge(12);
        Employee employee2=new Employee();
        employee2.setId(2);
        employee2.setName("raj");
        employee2.setAge(12);
        Employee employee3=new Employee();
        employee3.setId(3);
        employee3.setName("ramesh");
        employee3.setAge(12);
        EmployeeDao employeedaoObject=EmployeeDao.getEmployeeDaoInstance();
        employeedaoObject.saveEmployeeToFile(employee);
        employeedaoObject.saveEmployeeToFile(employee2);
        employeedaoObject.saveEmployeeToFile(employee3);
        employeedaoObject.getEmployeeFromFile(1);
        //Employeedao.deleteEmployeeFromFile(2);
        for(Employee Employee0:employeedaoObject.getAllEmployeeWithName("gaurav")){
            System.out.println(Employee0.getId());
        }
    }

}
