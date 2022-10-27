package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionHandle extends RuntimeException {

	private String resourcename;
	private String fieldname;
	private Object filedvalue;

	public ExceptionHandle(String resourcename, String fieldname, Object filedvalue) {
		super(String.format("%s not found with %s : %s ", resourcename, fieldname, filedvalue));
		this.resourcename = resourcename;
		this.fieldname = fieldname;
		this.filedvalue = filedvalue;
	}

	public String getResourcename() {
		return resourcename;
	}

	public String getFieldname() {
		return fieldname;
	}

	public Object getFiledvalue() {
		return filedvalue;
	}

}
