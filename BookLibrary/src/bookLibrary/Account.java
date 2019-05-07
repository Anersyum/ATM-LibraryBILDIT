package bookLibrary;

import java.util.ArrayList;

public class Account {

	private static int accountId;
	private  String firstName, lastName;
	private int id;
	private ArrayList<Book> borrowedBooks = new ArrayList<Book>();
	
	Account(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		accountId++;
		this.id = accountId;
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	public void setFullName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getNumberOfBorrowedBooks() {
		return borrowedBooks.size();
	}

	public int getAccountId() {
		return id;
	}
	
	public void addBorrowedBookToAccount(Book book) {
		if (borrowedBooks.size() >= 3)
			System.out.println("You have borrowed more than three books. Please return at least one book "
					+ "to borrow another");
		else
			borrowedBooks.add(book);
	}
	
	public ArrayList<Book> getBorrowedBooks() {
		if (this.borrowedBooks.size() != 0)
			return borrowedBooks;
		return null;
	}
}
