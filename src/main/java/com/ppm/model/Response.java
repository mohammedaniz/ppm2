package com.ppm.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {

	private String code;
	
	private String message;
	
	private String status;
	
	private Object customObject;
}
