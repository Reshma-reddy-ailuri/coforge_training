package com.coforge.day3;

import java.util.Scanner;

public class GradeCalculatorApp {

	public static void main(String[] args) {
		int marks;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your marks : ");
		marks=sc.nextInt();
		if (marks >= 90 && marks <=100 ) {
			System.out.println("Your Grade is A");
		}
		else if (marks >=80 && marks <= 89) {
			System.out.println("Your Grade is B");
		}
		else if (marks >= 70 && marks <= 79) {
			System.out.println("Your Grade is C");
		}
		else if (marks >= 60 && marks <= 69) {
			System.out.println("Your Grade is D");
		}
		else {
			System.out.println("Your Grade is F");
		}
		sc.close();

	}

}
