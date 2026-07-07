package com.coforge.ems.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.coforge.ems.controller.EmployeeController;
import com.coforge.ems.model.Employee;

public class EmployeeApp {
	public static EmployeeController controller = new EmployeeController();
	//System.out.println should only be present in frontend (main class) it should not be present at any other files.
	//it creates a java bean object for 

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		String confirmation="",result="";
		do { 
			System.out.println("1.Create 2.update 3.Delete 4.Find 5.Find All 6.Quit");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
		switch(choice) {
		case 1: 
			System.out.println("Enter employee id, name, salary and dno");
			Employee employee = new Employee(scanner.nextInt(),scanner.next(), scanner.nextInt(),scanner.nextInt());
			result = controller.createEmployee(employee);
			System.out.println(result);
			break;
		case 2:
			System.out.println("Enter employee id, name, salary and dno to update");
			Employee employee1 = new Employee(scanner.nextInt(),scanner.next(), scanner.nextInt(),scanner.nextInt());
			result = controller.updateEmployee(employee1);
			System.out.println(result);
			break;
		case 3:
			System.out.println("Enter employee id of the Employee to delete");
			int empId = scanner.nextInt();
			result = controller.deleteEmployee(empId);
			System.out.println(result);
			break;
		case 4: //Find by Employee Id
			System.out.println("Enter employee id of the Employee to find");
			int empId1 = scanner.nextInt();
			result = controller.findEmployee(empId1);
			System.out.println(result);
			break;
		case 5:
			result = controller.findAllEmployee();
			controller.findAllEmployee();
			System.out.println(result);
			break;
		case 6:
			System.out.println("Invalid Choice");
		    scanner.close();
		    System.exit(0);
			break;
		default:
		    System.out.println("Invalid Choice");	
		}
		System.out.println("Do you want to continue [Yes|No]");
		confirmation = scanner.next();
		}while(confirmation.equalsIgnoreCase("yes"));

	}

}
