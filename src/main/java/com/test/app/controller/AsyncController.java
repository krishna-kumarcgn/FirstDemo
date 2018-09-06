package com.test.app.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.app.model.EmployeeAddresses;
import com.test.app.model.EmployeeNames;
import com.test.app.model.EmployeePhone;
import com.test.app.service.AsyncService;
 
//asynch methods calling and aggregation

@RestController
public class AsyncController {
 
    private static Logger log = LoggerFactory.getLogger(AsyncController.class);
 
    @Autowired
    private AsyncService service;
 
    @RequestMapping(value = "/testAsynch", method = RequestMethod.GET)
    public void testAsynch() throws InterruptedException, ExecutionException
    {
        log.info("testAsynch Start");
 
        CompletableFuture<EmployeeAddresses> employeeAddress = service.getEmployeeAddress();
        CompletableFuture<EmployeeNames> employeeName = service.getEmployeeName();
        CompletableFuture<EmployeePhone> employeePhone = service.getEmployeePhone();
 
        // Wait until they are all done
        CompletableFuture.allOf(employeeAddress, employeeName, employeePhone).join();
         
        log.info("EmployeeAddress--> " + employeeAddress.get());
        log.info("EmployeeName--> " + employeeName.get());
        log.info("EmployeePhone--> " + employeePhone.get());
    }
}