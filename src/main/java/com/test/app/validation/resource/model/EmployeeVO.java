package com.test.app.validation.resource.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.Identifiable;
import org.springframework.hateoas.ResourceSupport;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.NONE)
public class EmployeeVO extends ResourceSupport implements Serializable //link with resourcesupport
{
    private static final long serialVersionUID = 1L;
     
    public EmployeeVO(Integer id, String firstName, String lastName, String email) {
        super();
        this.employeeId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
 
    public EmployeeVO() {
 
    }
 
    @XmlAttribute
    private Integer employeeId;
 
    @XmlElement
    private String firstName;
 
    @XmlElement
    private String lastName;
 
    @XmlElement
    private String email;
 
    //removed getters and setters for readability
 
    @Override
    public String toString() {
        return "EmployeeVO [id=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
                + "]";
    }

	public Identifiable<?> getEmployeeId() {
		// TODO Auto-generated method stub
		return null;
	}
}