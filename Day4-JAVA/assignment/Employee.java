package com.coforge.day4.assignment;

public class Employee {
	int empId;
	String empName;
	double monthlySalary;
	
	Employee(int empId,String empName, double monthlySalary){
		this.empId=empId;
		this.empName=empName;
		this.monthlySalary=monthlySalary;
	}
	double calculateAnnualSalary() {
		return monthlySalary * 12;
	}
	void displayDetails() {
		System.out.println("Enter employee details :");
		System.out.println("Enter Employe Id :" +empId);
		System.out.println("Enter Employe Name :" +empName);
		System.out.println("Enter Employe Monthly Salary :" +monthlySalary);
		System.out.println("Enter Employe Annual Salary :" +calculateAnnualSalary());
		
	}

}
