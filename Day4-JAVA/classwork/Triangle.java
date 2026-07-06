package com.coforge.day4.abstraction;

public class Triangle extends Figure {
	Triangle() {
		super(10L,12L);
	}
	@Override
	public void area() {
		System.out.println("The area of triangle is :" +(getBase() * getHeight())/2);
		
	}
	

}
