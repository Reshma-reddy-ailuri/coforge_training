package com.coforge.day3;

public class Product {

    int productId;
    String productName;
    double price;
    int quantity;

    public double calculateTotalAmount() {
        return price * quantity;
    }

    public void displayBill() {

        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Price        : " + price);
        System.out.println("Quantity     : " + quantity);
        System.out.println("----------------------------");
        System.out.println("Total Amount : " + calculateTotalAmount());

    }

    public static void main(String[] args) {

        Product p = new Product();

        p.productId = 1001;
        p.productName = "Laptop";
        p.price = 55000;
        p.quantity = 2;

        p.displayBill();
    }
}
