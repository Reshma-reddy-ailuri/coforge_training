package com.coforge.day4.assignment;

import java.util.Scanner;

public class LibraryApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        Library library = new Library();

        while (true) {

            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Enter Book Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Author Name: ");
                String author = sc.nextLine();

                Book book = new Book(id, name, author);
                library.addBook(book);
                break;

            case 2:

                System.out.print("Enter Book ID: ");
                id = sc.nextInt();

                library.issueBook(id);
                break;

            case 3:

                System.out.print("Enter Book ID: ");
                id = sc.nextInt();

                library.returnBook(id);
                break;

            case 4:

                System.out.print("Enter Book ID: ");
                id = sc.nextInt();

                library.searchBook(id);
                break;

            case 5:

                System.out.println("Thank You!");
                sc.close();
                System.exit(0);

            default:

                System.out.println("Invalid Choice.");
            }
        }

	}

}
