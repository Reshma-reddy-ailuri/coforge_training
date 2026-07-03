package com.coforge.day3;

import java.util.Scanner;

public class FactorialTableApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the limit : ");
		int n = sc.nextInt();
		
		for (int i =1; i<=n; i++) {
		  int fact = 1;
		  for ( int j = 1; j <= i; j++) {
			  fact=fact * j;
		  }
		
		 System.out.println(i + "Factorial is : " + fact);
		 sc.close();
		}
	}
}
