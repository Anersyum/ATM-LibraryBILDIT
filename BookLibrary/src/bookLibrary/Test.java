package bookLibrary;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int choice = -1;
		
		while (choice != 0) {
			showChoices();
			choice = input.nextInt();
			
			switch (choice) {
				case 0:
					break;
				case 1:
					input.nextLine();
					createNewAccount(input);
					break;
				case 2:
					input.nextLine();
					createNewBook(input);
					break;
				case 3:
					borrowBook(input);
					break;
				case 4:
					returnBook(input);
					break;
				case 5:
					showAccountInfo(input);
					break;
				default:
					System.out.println("Enter a valid choice!");
					break;
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
				+ "\n4. Return book"
				+ "\n5. Show account info"
				+ "\n0. Exit");
	}
	
	public static void createNewAccount(Scanner input) {
		String firstName, lastName;
		
		System.out.print("Please, enter your first name: ");
		firstName = input.next();
		System.out.print("Please enter your last name: ");
		lastName = input.next();
		
		AccountManager.createAccount(firstName, lastName);
	}
	
	public static void createNewBook(Scanner input) {
		String bookName;
		
		System.out.print("Please enter the name of the book: ");
		bookName = input.nextLine();
		
		BookManager.addBookToLibrary(bookName);
	}
	
	public static void borrowBook(Scanner input) {
		int bookId, accountId;
		Book book;
		Account account;
		
		if (BookManager.getNumberOfBooks() == 0 || AccountManager.getNumberOfAccounts() == 0)
			System.out.println("There are no accounts or books in the database!");
		else {
			System.out.print("Enter the id of the book you want to borrow: ");
			bookId = input.nextInt();
			book = BookManager.getBookById(bookId);
			if (book == null)
				System.out.println("That book doesn't exist!");
			else {
				System.out.print("Enter the id of the account that wants to borrow the book: ");
				accountId = input.nextInt();
				account = AccountManager.getAccountById(accountId);
				if (account == null)
					System.out.println("That account doesn't exist!");
				else {
					BookManager.borrow(account, book);
				}
			}
		}
	}
	
	public static void showAccountInfo(Scanner input) {
		int accountId;
		Account account;
		
		System.out.print("Enter the account id: ");
		accountId = input.nextInt();
		account = AccountManager.getAccountById(accountId);
		
		if (account == null)
			System.out.println("That account doesn't exist!");
		else
			AccountManager.showAccountInfo(account);
	}
	
	public static void returnBook(Scanner input) {
		int accountId, bookId;
		Account account;
		Book bookToRemove;
		
		System.out.print("Enter the account id: ");
		accountId = input.nextInt();
		System.out.print("Enter the id of the book: ");
		bookId = input.nextInt();
		
		account = AccountManager.getAccountById(accountId);
		bookToRemove = BookManager.getBookById(bookId);
		
		if (account == null || bookToRemove == null)
			System.out.println("The book or the account doesn't exist!");
		else
			BookManager.returnBook(account, bookToRemove);
	}
}
