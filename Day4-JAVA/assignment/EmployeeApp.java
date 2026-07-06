package com.coforge.day4.assignment;

import java.util.Scanner;

public class EmployeeApp {

	public static void main(String[] args) {
		Scanner sc =new Scanner (System.in);
		
		System.out.println("Enter Employee ID: ");
		int id=sc.nextInt();
		sc.nextLine();
		

		System.out.println("Enter Employee Name: ");
		String name=sc.nextLine();
		

		System.out.println("Enter monthly Salary : ");
		double salary=sc.nextDouble();
	

		Employee emp = new Employee(id,name,salary);
		emp.displayDetails();
		sc.close();
	}

}
