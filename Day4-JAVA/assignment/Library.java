package com.coforge.day4.assignment;
import java.util.ArrayList;

public class Library {
	ArrayList<Book> books = new ArrayList<>();
	void addBook(Book book) {
		books.add(book);
		System.out.println("Book Added Successfully");
	}	
	void searchBook(int id) {
		for (Book b : books) {
			if(b.bookId == id) {
				b.displayBook();
				return;
			}
		}
	    System.out.println("Book Not Found");	
	}
	void issueBook(int id) {

        for (Book b : books) {

            if (b.bookId == id) {

                if (!b.isIssued) {
                    b.isIssued = true;
                    System.out.println("Book Issued Successfully.");
                } else {
                    System.out.println("Book Already Issued.");
                }
                return;
            }
        }

        System.out.println("Book Not Found.");
    }
	void returnBook(int id) {

        for (Book b : books) {

            if (b.bookId == id) {

                if (b.isIssued) {
                    b.isIssued = false;
                    System.out.println("Book Returned Successfully.");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }

        System.out.println("Book Not Found.");
    }

}
