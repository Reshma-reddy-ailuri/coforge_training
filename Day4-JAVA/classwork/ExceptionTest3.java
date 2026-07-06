package com.coforge.day4.exception;

public class ExceptionTest3 {

	public static void main(String[] args) {
		System.out.println("Before Exception");
		try {
		// int a=10/0; //java.lang.ArithmeticException
		// int b=Integer.parseInt("abc");
		   int[] arr=new int [-5];
		}catch(ArithmeticException e) {
			System.out.println("Error: " +e.getMessage());
		}catch(NumberFormatException e) {
			System.out.println("Error: " +e.getMessage());	
		}finally { // can have only 1 finally block.
			System.out.println("Finally Block");
		}
		
		System.out.println("After Exception");

	}

}
