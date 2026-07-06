package com.coforge.day4.assignment;

public class Student {
	int id;
	String name;
	double marks;
	
	Student(int id,String name,double marks){
		this.id=id;
		this.name=name;
		this.marks=marks;
	}
	
	void displayDetails() {
		System.out.println("\n Student Details :");
		System.out.println("ID: " +id);
		System.out.println("Name: " +name);
		System.out.println("Marks: " +marks);
	}
	
	void CalculateGrade() {
		if (marks >=90) {
			System.out.println("Grade: A");
		}
		else if (marks>=80 && marks <90) {
			System.out.println("Grade : B");
		}
		else if (marks>=70 && marks <80) {
			System.out.println("Grade : C");
		}
		else if (marks>=60 && marks <70) {
			System.out.println("Grade : D");
		}
		else {
			System.out.println("Grade : F");
		}
	}

}
