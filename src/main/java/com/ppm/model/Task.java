package com.ppm.model;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Task {
	
	@NotEmpty(message = "Task Name is Required")
	private String name;
	
	@NotEmpty(message = "Start Date is Required")
	private String startDate;
	
	@NotEmpty(message = "End Date is Required")
	private String endDate;
	
	@NotEmpty(message = "Description is Required")
	@Size(max = 100, min = 10, message = " Description Should atleast contains 10 characters")
	private String description;
	
	@NotEmpty(message = "Status is Required")
	private String status;
	
	

}
