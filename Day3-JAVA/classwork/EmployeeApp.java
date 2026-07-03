package com.coforge.day3;

public class EmployeeApp {

	public static void main(String[] args) {
		Employee reshma = new Employee(101, "reshma", 2000.0);
		reshma.display();
		
		reshma.setSalary(5000);
		reshma.display();
		
		Employee srima = new Employee(102, "srima", 3000.0);
		srima.display();
		
		System.out.println(srima.getSalary());
	}

}
