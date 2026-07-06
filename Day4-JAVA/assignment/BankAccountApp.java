package com.coforge.day4.assignment;

import java.util.Scanner;

public class BankAccountApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Account Number :");
		int accountNumber = sc.nextInt();
		
		System.out.println("Enter Balance:");
		double balance = sc.nextDouble();
		
		BankAccount account =new BankAccount(accountNumber,balance);
		
		System.out.println("Enter deposit Amount :");
		double depositAmount = sc.nextDouble();
		account.deposit(depositAmount);
		
		System.out.println("Enter Withdraw Amount :");
		double withdrawAmount = sc.nextDouble();
		account.withdraw(withdrawAmount);
		
		account.checkBalance();
		
		sc.close();


	}

}
