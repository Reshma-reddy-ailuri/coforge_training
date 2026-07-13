package com.coforge.ems.exception;

import com.coforge.ems.util.ApplicationProperties;

public class InvalidEmployeeObjectException extends Exception{

	@Override
	public String toString() {
		return ApplicationProperties.validationFailed;
	}
	
}
