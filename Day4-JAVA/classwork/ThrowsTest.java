package com.coforge.day4.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ThrowsTest {
	public static void myMethod() throws FileNotFoundException{
		FileReader fr = new FileReader("Demo.txt");
	}
	
	public static void main(String[] args) {
		//int a = 10 / 0; //Un-checked Exception
		//FileReader fr = new FileReader("Demo.txt"); //Checked Exception)
		
		try { 
			ThrowsTest.myMethod();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//ThrowsTest.myMethod();
	}

}
