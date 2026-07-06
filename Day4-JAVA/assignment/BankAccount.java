package com.coforge.day4.assignment;

public class BankAccount {
	private int accountNumber;
	private double balance;
	
	BankAccount(int accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public void deposit(double amount) {
		balance = balance+amount;
		System.out.println("Amount Deposited : " +amount);
	}
	public void withdraw(double amount) {
		if(amount<=balance) {
			balance=balance-amount;
			System.out.println("Amount Withdrawn :" +amount);
		} else {
			System.out.println("Insufficient balance");
		}
	}
	
	public void checkBalance() {
		System.out.println("Account Number :" +accountNumber);
		System.out.println("Balance : " +balance);
	}

}
