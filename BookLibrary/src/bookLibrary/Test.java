package bookLibrary;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int choice = -1;
		
		while (choice != 0) {
			showChoices();
			choice = input.nextInt();
			
			if (choice == 1) {
				input.nextLine();
				createNewAccount(input);
			} else if (choice == 2) {
				input.nextLine();
				createNewBook(input);
			} else if (choice == 3) {	
				borrowBook(input);

			}
			else if (choice == 4) {
				showAccountInfo(input);
			}
		}
		input.close();
		System.out.println("Thank you for using our library!");

	}
	
	public static void showChoices() {
		System.out.println("Welcome to the library. Please choose your option:"
				+ "\n1. Create account"
				+ "\n2. Create book"
				+ "\n3. Borrow book for a fixed period of time"
				+ "\n4. Show account info"
				+ "\n0. Exit");
	}
	
	public static void createNewAccount(Scanner input) {
		String accountName;
		
		System.out.print("Please, enter your name: ");
		accountName = input.nextLine();
		
		Account account = new Account(accountName);
		System.out.println("The account with the name of " + accountName + " has been created"
				+ " with the id of " + account.getAccountId());
	}
	
	public static void createNewBook(Scanner input) {
		String bookName;
		
		System.out.print("Please enter the name of the book: ");
		bookName = input.nextLine();
		
		Book book = new Book(bookName);
		System.out.println("The book with the name of " + bookName + " has been created with "
				+ "the id of " + book.getBookId());
	}
	
	public static void borrowBook(Scanner input) {
		int bookId, accountId;
		
		if (BookManager.getNumberOfBooks() == 0 || AccountManager.getNumberOfAccounts() == 0)
			System.out.println("There are no accounts or books in the database!");
		else {
			System.out.print("Enter the id of the book you want to borrow: ");
			bookId = input.nextInt();
			if (BookManager.getNumberOfBooks() < bookId || bookId < 1)
				System.out.println("That book doesn't exist!");
			else {
				System.out.print("Enter the id of the account that wants to borrow the book: ");
				accountId = input.nextInt();
				if (AccountManager.getNumberOfAccounts() < accountId || accountId < 1)
					System.out.println("That account doesn't exist!");
				else {
					BookManager.borrow(accountId, bookId);
				}
			}
		}
	}
	
	public static void showAccountInfo(Scanner input) {
		int accountId;
		
		System.out.print("Enter the account id: ");
		accountId = input.nextInt();
		
		AccountManager.showAccountInfo(accountId);
	}
}
