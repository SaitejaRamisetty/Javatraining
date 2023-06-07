package com.rgt.library;

	import java.util.Scanner;

	public class LibraryManagementsSystem {
	    private static final int MAX_BOOKS = 50;
	    private static final int MAX_PATRONS =50;

	    private String[] bookTitle = new String[MAX_BOOKS];
	    private boolean[] booksAvailability = new boolean[MAX_BOOKS];
	    private String[] patrons = new String[MAX_PATRONS];
	    private String[] borrowedBooks = new String[MAX_PATRONS];

	    private int bookCount = 0;
	    private int patronCount = 0;
	    private int numBorrowedBooks = 0;

	    public void addBook(String title) {
	        if (bookCount >= MAX_BOOKS) {
	            System.out.println("Maximum number of books reached.");
	            return;
	        }

	        bookTitle[bookCount] = title;
	        booksAvailability[bookCount] = true;
	        bookCount++;

	        System.out.println("Book added successfully.");
	    }

	    public void addPatron(String name) {
	        if (patronCount >= MAX_PATRONS) {
	            System.out.println("Maximum number of patrons reached.");
	            return;
	        }

	        patrons[patronCount] = name;
	        patronCount++;

	        System.out.println("Patron added successfully.");
	    }

	    public void borrowBook(String title, String patronName) {
	        int bookIndex = findBookIndexByTitle(title);
	        int patronIndex = findPatronIndexByName(patronName);

	        if (bookIndex == -1) {
	            System.out.println("Book not found.");
	        } else if (patronIndex == -1) {
	            System.out.println("Patron not found.");
	        } else if (!booksAvailability[bookIndex]) {
	            System.out.println("Book is already borrowed.");
	        } else {
	            borrowedBooks[patronIndex] = title;
	            booksAvailability[bookIndex] = false;
	            System.out.println("Book borrowed successfully.");
	        }
	    }

	    public void returnBook(String title, String patronName) {
	        int bookIndex = findBookIndexByTitle(title);
	        int patronIndex = findPatronIndexByName(patronName);

	        if (bookIndex == -1) {
	            System.out.println("Book not found.");
	        } else if (patronIndex == -1) {
	            System.out.println("Patron not found.");
	        } else if (booksAvailability[bookIndex]) {
	            System.out.println("Book is already returned.");
	        } else if (!title.equals(borrowedBooks[patronIndex])) {
	            System.out.println("Book was not borrowed by the specified patron.");
	        } else {
	            borrowedBooks[patronIndex] = null;
	            booksAvailability[bookIndex] = true;
	            System.out.println("Book returned successfully.");
	        }
	    }

	    private int findBookIndexByTitle(String title) {
	        for (int i = 0; i < bookCount; i++) {
	            if (title.equals(bookTitle[i])) {
	                return i;
	            }
	        }
	        return -1;
	    }

	    private int findPatronIndexByName(String name) {
	        for (int i = 0; i < patronCount; i++) {
	            if (name.equals(patrons[i])) {
	                return i;
	            }
	        }
	        return -1;
	    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        LibraryManagementsSystem library = new LibraryManagementsSystem();

	        while (true) {
	            System.out.println("\n===== Library Management System =====");
	            System.out.println("1. Add Book");
	            System.out.println("2. Add Patron");
	            System.out.println("3. Borrow Book");
	            System.out.println("4. Return Book");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character after reading the choice

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter book title: ");
	                    String bookTitle = scanner.nextLine();
	                    library.addBook(bookTitle);
	                    break;
	                case 2:
	                    System.out.print("Enter patron name: ");
	                    String patronName = scanner.nextLine();
	                    library.addPatron(patronName);
	                    break;
	                case 3:
	                    System.out.print("Enter book title: ");
	                    String borrowBookTitle = scanner.nextLine();
	                    System.out.print("Enter patron name: ");
	                    String borrowPatronName = scanner.nextLine();
	                    library.borrowBook(borrowBookTitle, borrowPatronName);
	                    break;
	                case 4:
	                    System.out.print("Enter book title: ");
	                    String returnBookTitle = scanner.nextLine();
	                    System.out.print("Enter patron name: ");
	                    String returnPatronName = scanner.nextLine();
	                    library.returnBook(returnBookTitle, returnPatronName);
	                    break;
	                case 5:
	                    System.out.println("Exiting the application.");
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
	}

