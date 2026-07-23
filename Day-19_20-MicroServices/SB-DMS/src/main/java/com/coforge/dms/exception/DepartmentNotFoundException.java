package com.coforge.dms.exception;

public class DepartmentNotFoundException extends RuntimeException{
	public DepartmentNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
