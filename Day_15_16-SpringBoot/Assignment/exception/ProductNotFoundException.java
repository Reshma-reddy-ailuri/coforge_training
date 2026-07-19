package com.coforge.pms.exception;

public class ProductNotFoundException extends Exception{
	@Override
	public String toString() {
		return "FAILED : Product Not Found";
	}

}
