package com.metacube.employee;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/EmployeeService")
public class EmployeeService {
    
    EmployeeDao employeeDaoObject=EmployeeDao.getEmployeeDaoInstance(); //getting singleton instance
    
    //a map to store employee in memory temporarily
    Map<Integer,Employee> employeeMap;
    public void genereateMap(){
        employeeMap=new HashMap<Integer,Employee>();
        for(Employee mapEntry:employeeDaoObject.getAllEmployeeFromFile()){
            employeeMap.put(mapEntry.getId(),mapEntry);
        }
    }
    
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(){
        return "Hello";
    }
    
    //create operation
    @POST
    @Path("/AddEmployee")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addEmployee(Employee ... employee) {
        this.genereateMap();
        String responseString="";
        int saveCount=0;
        for(Employee newEmployee:employee){
            if(newEmployee.getId()!=0 && employeeMap.get(newEmployee.getId())==null && newEmployee.getName().length()!=0 && newEmployee.getName()!=null){
                employeeDaoObject.saveEmployeeToFile(newEmployee);
                saveCount++;
            }/*else if(newEmployee.getId()==0){
                responseString="please supply an employeeId";
            }else if(newEmployee.getName()==null && newEmployee.getName()==""){
                responseString="supply legitimate name";
            }else{
                responseString="add unsuccessful due to unknown reason";
            }*/
        }
        responseString=saveCount+" Employees added successfully";
      return responseString;
    }
    
    //retrieve operations
    @GET
    @Path("/GetEmployee/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployeeById(@PathParam("id") int id) {
        return (Employee)employeeDaoObject.getEmployeeFromFile(id);
    }
    
    @GET
    @Path("/GetEmployee/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getEmployeeByName(@PathParam("name") String name){
        return (List<Employee>)employeeDaoObject.getAllEmployeeWithName(name);
    }
    
    @GET
    @Path("/GetEmployee/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> getAllEmployee(){
        return (List<Employee>)employeeDaoObject.getAllEmployeeFromFile();
    }
    
    //retrieve operation
    @DELETE
    @Path("/DeleteEmployee/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String deleteEmployeeById(@PathParam("id") int id){
        return employeeDaoObject.deleteEmployeeFromFile(id);
    }
}
