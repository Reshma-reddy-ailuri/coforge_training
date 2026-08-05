package com.coforge.ars.exception;

public class AirportNotFoundException extends RuntimeException {
	public AirportNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
