package com.coforge.day4.abstraction;

public class AreaCalculatorApp {

	public static void main(String[] args) {
		/*
		Rectangle rectangle = new Rectangle();
		Square square = new Square();
		Triangle triangle=new Triangle();
		rectangle.area();
		square.area();
		triangle.area();
		*/
		
		// this is run time polymorphism -- dynamic method dispatch
		AreaPlan figure; //giving reference to interface
		figure = new Rectangle();
		figure.area();
	
		figure = new Square();
		figure.area();
		
		figure = new Triangle();
		figure.area();
		
		//Dynamic method dispatch is not possible at any cost because you can say all rectangles are figures but not all figures are rectangles.
		//Rectangle rectangle = (Rectangle) new Figure(5);
	}

}
