package com.coforge.day4.assignment;

public class Customer {

    int customerId;
    String customerName;

    Cart cart;

    Customer(int customerId, String customerName, Cart cart) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.cart = cart;
    }

    void displayCustomer() {
        System.out.println("Customer ID : " + customerId);
        System.out.println("Customer Name : " + customerName);
    }
}
