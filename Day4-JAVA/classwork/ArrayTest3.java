package com.coforge.day4.exception;

import java.util.Scanner;

public class ArrayTest3 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		int[] arr = new int[] {10,20,30,40,50};
		
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println("Arr[" + i + "] : " + arr[i]);
			sum = sum + arr[i];
		}
		System.out.println("Sum of Array: " + sum);
	}

}
