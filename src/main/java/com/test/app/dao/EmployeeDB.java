package com.test.app.dao;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.test.app.validation.EmployeeVO;

public class EmployeeDB {

	public static List<com.test.app.validation.resource.model.EmployeeVO> getEmployeeList()
    {
        List<com.test.app.validation.resource.model.EmployeeVO> list = new ArrayList<>();
 
        com.test.app.validation.resource.model.EmployeeVO empOne = new com.test.app.validation.resource.model.EmployeeVO(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
        com.test.app.validation.resource.model.EmployeeVO empTwo = new com.test.app.validation.resource.model.EmployeeVO(2, "Amit", "Singhal", "asinghal@yahoo.com");
        com.test.app.validation.resource.model.EmployeeVO empThree = new com.test.app.validation.resource.model.EmployeeVO(3, "Kirti", "Mishra", "kmishra@gmail.com");
 
        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);
 
        return list;
    }

	public static EmployeeVO getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void addEmployee(@Valid EmployeeVO employee) {
		// TODO Auto-generated method stub
		
	}
}
