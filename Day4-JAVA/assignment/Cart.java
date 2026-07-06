package com.coforge.day4.assignment;

import java.util.ArrayList;

public class Cart {

    ArrayList<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        products.add(product);
        System.out.println("Product Added Successfully.");
    }


    void removeProduct(int productId) {

        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).productId == productId) {
                products.remove(i);
                System.out.println("Product Removed Successfully.");
                return;
            }
        }

        System.out.println("Product Not Found.");
    }

    void calculateBill() {

        double total = 0;

        for (Product p : products) {
            total += p.price;
        }

        System.out.println("Total Bill = ₹" + total);
    }


    void displayCart() {

        if (products.isEmpty()) {
            System.out.println("Cart is Empty.");
            return;
        }

        System.out.println("\nProducts in Cart");

        for (Product p : products) {
            p.displayProduct();
        }
    }
}
