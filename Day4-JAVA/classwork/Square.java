package com.coforge.day4.abstraction;

public class Square extends Figure {
	Square(){
		super(5);
	}
	@Override
	public void area() {
		System.out.println("The area of square is :" +(getSide() * getSide()));
		
	}

}
