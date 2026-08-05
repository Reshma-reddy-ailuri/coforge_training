package com.coforge.ars.exception;

public class FlightNotFoundException extends RuntimeException {
	public FlightNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
