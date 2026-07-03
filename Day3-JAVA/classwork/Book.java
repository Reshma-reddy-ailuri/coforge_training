package com.coforge.day3;

public class Book {

    int bookId;
    String title;
    String author;
    double price;

    public void displayDetails() {
        System.out.println("Book ID : " + bookId);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("Price   : " + price);
    }

    public static void main(String[] args) {

        Book b1 = new Book();

        b1.bookId = 101;
        b1.title = "Java Programming";
        b1.author = "James Gosling";
        b1.price = 650.50;

        b1.displayDetails();
    }
}
