package com.coforge.day4.abstraction;

public class Rectangle extends Figure {

	Rectangle() {
		super(10,20);
	}
	@Override
	public void area() {
		System.out.println("The area of Rectangle is : "+(getLength() * getBreadth()));
	}
	

}
