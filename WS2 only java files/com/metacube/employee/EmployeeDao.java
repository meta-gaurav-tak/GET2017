package com.metacube.employee;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    /* making EmployeeDao Singleton */
    public static EmployeeDao employeeDao;

    private EmployeeDao() {
        this.file = new File(
                "C:/Users/GRV/workspace/RESTWebServiceDemo/Employees.ser"); // use your serialized file address here
    }

    public static EmployeeDao getEmployeeDaoInstance() {                    // return a singleton instance of DAO
        if (employeeDao == null) {
            synchronized (EmployeeDao.class) {
                if (employeeDao == null) {
                    employeeDao = new EmployeeDao();
                }
            }
        }
        return employeeDao;
    }

    // Stream Handlers
    private File file;
    private FileOutputStream fos;
    private ObjectOutputStream oos;
    private FileInputStream fis;
    private ObjectInputStream ois;

    /**
     * to get an employee with the same employee id as provided
     * 
     * @param id employee id for employee to retrieve
     * @return the fetched employee object
     */
    public Employee getEmployeeFromFile(int id) {
        Employee Employee1 = new Employee(0, "Default", 0); // a default object to be returned of no object is found
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            ArrayList<Employee> employeeList = new ArrayList<>();
            while (true) {
                try {
                    employeeList.add((Employee) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }

            for (Employee Employee : employeeList) {
                if (Employee.getId() == id) {
                    Employee1 = Employee;
                }
            }
        } catch (Exception e) {
            System.out.println("file stream Not Found");
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Employee1;
    }

    /**
     * a method to get all employee data
     * 
     * @return list of employees
     */
    public List<Employee> getAllEmployeeFromFile() {
        List<Employee> employeeList = new ArrayList<Employee>();
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    employeeList.add((Employee) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Stream read error");
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return employeeList;
    }

    /**
     * method to get all employees that have a string name in their name
     * 
     * @param name the string to be checked to exist in an employee name
     * @return list of employees
     */
    public List<Employee> getAllEmployeeWithName(String name) {
        List<Employee> employeeList = new ArrayList<Employee>();
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            while (true) {
                try {
                    Employee Employee = (Employee) ois.readObject();
                    if (Employee.getName().contains(name)) {
                        employeeList.add(Employee);
                    }
                } catch (EOFException e) {
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("file not found");
        } finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return employeeList;
    }

    /**
     * method to add an employee to employee data file
     * 
     * @param Employeeb the employee to be added
     */
    public void saveEmployeeToFile(Employee Employee) {
        try {
            if (oos == null || fos == null) {
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(Employee);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * method to delete an employee from file provide his id
     * 
     * @param id
     * @return String of status
     */
    public String deleteEmployeeFromFile(int id) {
        oos = null; // this helps in rewriting the file
        String deleteStatus = "Employee with this id does not work with us";
        List<Employee> listOfEmployee = getAllEmployeeFromFile();
        int indexToRemove = 0;
        for (Employee Employee : listOfEmployee) {
            if (Employee.getId() == id) {
                break;
            }
            indexToRemove++;
        }
        if (indexToRemove < listOfEmployee.size()) { // removing the employee
            listOfEmployee.remove(indexToRemove);
            deleteStatus = "Found and removed Employee";
            for (Employee Employee : listOfEmployee) { // rewriting all employees to file
                saveEmployeeToFile(Employee);
            }
        }
        return deleteStatus;
    }
}