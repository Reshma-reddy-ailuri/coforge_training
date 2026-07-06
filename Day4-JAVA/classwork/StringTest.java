package com.coforge.day4.exception;

public class StringTest {

	public static void main(String[] args) {
		String s1 = "Java";
		String s2 = new String("java");
		
		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s2));
		
		System.out.println(s1.length());
		
		System.out.println(s1.toLowerCase());
		
		System.out.println(s1.toUpperCase());
		
		System.out.println(s1.charAt(1));
		
		System.out.println(s1.indexOf('a'));
		System.out.println(s1.lastIndexOf('a'));
		System.out.println(s1.indexOf('b'));
		
		String s3 = s1.concat("World");
		System.out.println(s3.substring(3,7));
		System.out.println(s3.substring(3));
	}

}
