package com.test.app.validation.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

import com.test.app.validation.resource.model.EmployeeVO;


@XmlRootElement (name="employees")
public class EmployeeListVO extends ResourceSupport  implements Serializable
{
    private static final long serialVersionUID = 1L;
      
    private java.util.List<EmployeeVO> employees = new ArrayList<EmployeeVO>();
  
    public List<EmployeeVO> getEmployees() {
        return employees;
    }
  
    public void setEmployees(List<EmployeeVO> employees) {
        this.employees = employees;
    }
}