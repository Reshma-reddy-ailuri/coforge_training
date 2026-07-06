package com.coforge.day4.abstraction;

public class VehicleApp {

	public static void main(String[] args) {
		// object creation for last sub class and call methods
		/*
		honda.noOfEngine();
		honda.noOfWheels();
		honda.brandName();	
		
		Scooty activa = new Scooty();
		activa.noOfEngine();
	    activa.noOfWheels();
		activa.brandName();	
		*/
		VehiclePlan vehicle;
		vehicle = new Bike();
		vehicle.noOfWheel();
		vehicle.brandName();
		vehicle.noOfEngine();
		
		vehicle = new Scooty();
		vehicle.noOfWheel();
		vehicle.brandName();
		vehicle.noOfEngine();
		
		
	}
}
