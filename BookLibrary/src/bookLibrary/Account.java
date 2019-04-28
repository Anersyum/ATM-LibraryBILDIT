package bookLibrary;

import java.util.ArrayList;

public class Account {

	private static int accountId;
	private  String accountName;
	private int id;
	private int numberOfBorrowedBooks;
	public static ArrayList<Account> accounts = new ArrayList<Account>();
	private ArrayList<Book> borrowedBooks = new ArrayList<Book>();
	
	Account(String accountName) {
		this.setAccountName(accountName);
		accountId++;
		this.id = accountId;
		accounts.add(this);
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getNumberOfBorrowedBooks() {
		return numberOfBorrowedBooks;
	}

	public void setNumberOfBorrowedBooks(int numberOfBorrowedBooks) {
		this.numberOfBorrowedBooks = numberOfBorrowedBooks;
	}

	public int getAccountId() {
		return id;
	}
	
	public void addBorrowedBookToAccount(Book book) {
		borrowedBooks.add(book);
	}
	
	public ArrayList<Book> getBorrowedBooks() {
		if (this.numberOfBorrowedBooks != 0)
			return borrowedBooks;
		return null;
	}
}
