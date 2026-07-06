package com.coforge.day4.assignment;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Student name :"); 
		String name =sc.nextLine();
		System.out.println("Enter Student marks :");
		double marks = sc.nextDouble();
		
		Student s1=new Student(id,name,marks);
		
		s1.displayDetails();
		s1.CalculateGrade();
		sc.close();
		
	}

}
