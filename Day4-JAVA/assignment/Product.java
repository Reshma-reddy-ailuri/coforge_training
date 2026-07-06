package com.coforge.day4.assignment;

public class Product {
	int productId;
	String productName;
	double price;
	
	Product(int productId, String productName, double price){
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}	
	void displayProduct() {
		System.out.println(productId + " " + productName + "Rs." + price);
	}


}
