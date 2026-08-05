package com.coforge.ars.exception;

public class AirplaneNotFoundException extends RuntimeException {
	public AirplaneNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
