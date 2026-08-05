package com.coforge.ars.exception;

public class WalletNotFoundException extends RuntimeException {

	public WalletNotFoundException(String message) {
		super(message);
	}

}