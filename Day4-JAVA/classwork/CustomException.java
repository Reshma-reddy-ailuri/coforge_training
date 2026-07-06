package com.coforge.day4.exception;

import java.util.Scanner;

public class CustomException {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your age:");
        int age = sc.nextInt();

        if (age >= 18) {
            System.out.println("Welcome to Vote");
        } else {
            try {
                throw new InvalidAgeException();
            } catch (InvalidAgeException e) {
                System.out.println(e);
            }
        }

        sc.close();
    }
}