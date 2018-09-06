package com.test.app.validation;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

//model classes

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeVO extends ResourceSupport implements Serializable
{
     
    /**
	 * 
	 */
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
     
    
    //Annotate model class with required validation specific annotations
    private Integer employeeId;
    
    @NotEmpty(message = "first name must not be empty")
    private String firstName;
 
    @NotEmpty(message = "last name must not be empty")
    private String lastName;
 
    @NotEmpty(message = "email must not be empty")
    @Email(message = "email should be a valid email")
    private String email;
    
    
    
    //Removed setter/getter for readability
    
    
  /*  @AssertFalse	The annotated element must be false.
    @AssertTrue	The annotated element must be true.
    @DecimalMax	The annotated element must be a number whose value must be lower or equal to the specified maximum.
    @DecimalMin	The annotated element must be a number whose value must be higher or equal to the specified minimum.
    @Future	The annotated element must be an instant, date or time in the future.
    @Max	The annotated element must be a number whose value must be lower or equal to the specified maximum.
    @Min	The annotated element must be a number whose value must be higher or equal to the specified minimum.
    @Negative	The annotated element must be a strictly negative number.
    @NotBlank	The annotated element must not be null and must contain at least one non-whitespace character.
    @NotEmpty	The annotated element must not be null nor empty.
    @NotNull	The annotated element must not be null.
    @Null	The annotated element must be null.
    @Pattern	The annotated CharSequence must match the specified regular expression.
    @Positive	The annotated element must be a strictly positive number.
    @Size	The annotated element size must be between the specified boundaries (included).*/
}