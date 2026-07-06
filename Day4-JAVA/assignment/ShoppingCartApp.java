package com.coforge.day4.assignment;

import java.util.Scanner;

public class ShoppingCartApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cart cart = new Cart();

        System.out.print("Enter Customer ID: ");
        int customerId = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();

        Customer customer = new Customer(customerId, customerName, cart);

        int choice;

        do {

            System.out.println("\n===== Shopping Cart =====");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Display Cart");
            System.out.println("4. Calculate Bill");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Product ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Product Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Product Price: ");
                double price = sc.nextDouble();

                Product product = new Product(id, name, price);

                customer.cart.addProduct(product);

                break;

            case 2:

                System.out.print("Enter Product ID: ");
                id = sc.nextInt();

                customer.cart.removeProduct(id);

                break;

            case 3:

                customer.displayCustomer();
                customer.cart.displayCart();

                break;

            case 4:

                customer.cart.calculateBill();

                break;

            case 5:

                System.out.println("Thank You!");

                break;

            default:

                System.out.println("Invalid Choice");
            }

        } while (choice != 5);

        sc.close();
    }
}
