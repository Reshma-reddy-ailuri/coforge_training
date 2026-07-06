package com.coforge.day4.exception;

public class ExceptionTest2 {

	public static void main(String[] args) {
		System.out.println("Before Exception");
		try {
		// int a=10/0; //java.lang.ArithmeticException
		// int b=Integer.parseInt("abc");
		   int[] ar=new int [-5];
		}catch(ArithmeticException e) {
			System.out.println("Error: " +e.getMessage());
		}catch(NumberFormatException e) {
			System.out.println("Error: " +e.getMessage());
		}catch(Exception e) { //this is the global catch block to handle all exceptions
			System.out.println("Error: " +e.getMessage());	
		}
		
		System.out.println("After Exception");

	}

}
