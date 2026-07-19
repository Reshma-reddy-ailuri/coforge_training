package com.coforge.ems.exception;

public class EmployeeNotFoundException extends Exception{
	@Override
	public String toString() {
		return "FAILED : Employee Not Found";
	}

}
