package com.coforge.day4.assignment;

public class Book {
	int bookId;
	String bookName;
	String author;
	boolean isIssued;
	
	Book(int bookId, String bookName, String author) {
		this.bookId=bookId;
		this.bookName=bookName;
		this.author=author;
		this.isIssued=false;
	}
	
	void displayBook() {
		System.out.println("BookId: " +bookId);
		System.out.println("BookName :" +bookName);
		System.out.println("author: " +author);
		System.out.println("isIssued: " +isIssued);
	}
}
