package com.test.app.controller;

import javax.validation.Valid;

import org.springframework.hateoas.Identifiable;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.dao.EmployeeDB;
import com.test.app.exception.RecordNotFoundException;
import com.test.app.validation.EmployeeVO;
import com.test.app.validation.model.EmployeeListVO;
import com.test.app.validation.resource.EmployeeReport;

@RestController
public class EmployeeRESTController {
//restocontroller , using for validation and exception handler
	
	@PostMapping(value = "/employees-no-valid")
	public ResponseEntity<EmployeeVO> addEmployeeWithoutValidation (@RequestBody EmployeeVO employee)
	{
	    EmployeeDB.addEmployee(employee);
	    return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
	}
	 
	@GetMapping(value = "/employees/{id}")
	public ResponseEntity<EmployeeVO> getEmployeeById (@PathVariable("id") int id)
	{
	    EmployeeVO employee = EmployeeDB.getEmployeeById(id);
	     
	    if(employee == null) {
	         throw new RecordNotFoundException("Invalid employee id : " + id);
	    }
	    return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
	}
	
	@PostMapping(value = "/employees")
	public ResponseEntity<EmployeeVO> addEmployee (@Valid @RequestBody EmployeeVO employee)
	{
	    EmployeeDB.addEmployee(employee);
	    return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/employees")
    public EmployeeListVO getAllEmployees()
    {
        EmployeeListVO employeesList  = new EmployeeListVO();
 
        /*for (com.test.app.validation.resource.model.EmployeeVO employee : EmployeeDB.getEmployeeList())
        {
            employeesList.getEmployees().add(employee);
        }*/
        
        //bind with resource hateaos link
        
        for (com.test.app.validation.resource.model.EmployeeVO employee : EmployeeDB.getEmployeeList())
        {
            //Adding self link employee 'singular' resource
            Link link = ControllerLinkBuilder
                    .linkTo(EmployeeRESTController.class)
                    .slash(employee.getEmployeeId())
                    .withSelfRel();
     
            //Add link to singular resource
            employee.add(link);
             
          //Adding method link employee 'singular' resource
            ResponseEntity<EmployeeReport> methodLinkBuilder = ControllerLinkBuilder
                    .methodOn(EmployeeRESTController.class).getReportByEmployeeById(employee.getEmployeeId());
            Link reportLink = ControllerLinkBuilder
                    .linkTo(methodLinkBuilder)
                    .withRel("employee-report");
     
            //Add link to singular resource
            employee.add(reportLink);
       
            employeesList.getEmployees().add(employee);
        }
         
        //Adding self link employee collection resource
        Link selfLink = ControllerLinkBuilder
                .linkTo(ControllerLinkBuilder
                .methodOn(EmployeeRESTController.class).getAllEmployees())
                .withSelfRel();
     
        //Add link to collection resource
        employeesList.add(selfLink);
 
        return employeesList;
    }
      
    @RequestMapping(value = "/employees/{id}")
    public ResponseEntity<com.test.app.validation.resource.model.EmployeeVO> getEmployeeByIdResource (@PathVariable("id") int id)
    {
        if (id <= 3) {
            com.test.app.validation.resource.model.EmployeeVO employee = EmployeeDB.getEmployeeList().get(id-1);
        //add with hateoas for singular resource
            //Self link
            Link selfLink = ControllerLinkBuilder
                    .linkTo(EmployeeRESTController.class)
                    .slash(employee.getEmployeeId())
                    .withSelfRel();
             
            //Method link
            Link reportLink = ControllerLinkBuilder
                    .linkTo(ControllerLinkBuilder.methodOn(EmployeeRESTController.class)
                    .getReportByEmployeeById(employee.getEmployeeId()))
                    .withRel("report");
             
            employee.add(selfLink);
            employee.add(reportLink);
            return new ResponseEntity<com.test.app.validation.resource.model.EmployeeVO>(employee, HttpStatus.OK);
        }
        return new ResponseEntity<com.test.app.validation.resource.model.EmployeeVO>(HttpStatus.NOT_FOUND);
    }
     
    @RequestMapping(value = "/employees/{id}/report")
    public ResponseEntity<EmployeeReport> getReportByEmployeeById (@PathVariable("id") Identifiable<?> identifiable)
    {
        //Do some operation and return report
        return null;
    }
}
