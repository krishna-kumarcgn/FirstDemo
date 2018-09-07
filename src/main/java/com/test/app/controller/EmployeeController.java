package com.test.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.model.Employee;
 
 
@RestController
public class EmployeeController
{
    @RequestMapping("/rest")
    public List<Employee> getEmployees()
    {
        List<Employee> employeesList = new ArrayList<Employee>();
        employeesList.add(new Employee(1,"l","g","hmail.com"));
        return employeesList;
    }
}