package com.pita_b2.employee.rest.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

public class EmployeeModel {
	
	@Getter
	@Setter
	private int employeeId;
	
	@Getter
	@Setter
	@NotBlank(message = "Please enter employee name")
	private String employeeName;
	
	@Getter
	@Setter
	@NotBlank(message = "Please enter employee phone")
	private String employeePhone;
	
	@Getter
	@Setter
	@NotBlank(message = "Please enter employee address")
	private String employeeAddress;
	
	@Getter
	@Setter
	@Email(message = "Please enter valid email")
	@NotBlank(message = "Please enter employee email")
	private String employeeEmail;
	
	@Getter
	@Setter
	@NotNull(message = "Please enter employee age")
	private int employeeAge;
	
	@Getter
	@Setter
	private int positionId;
	
	@Getter
	@Setter
	private String positionName;
	
	@Getter
	@Setter
	private int salaryRangeStart;
	
	@Getter
	@Setter
	private int salaryRangeEnd;
	
	@Getter
	@Setter
	private String description;
}
