package bookLibrary;

import java.util.ArrayList;
import java.util.Date;

public class Book {

	private static int id;
	private int bookId;
	private String bookName;
	private boolean borrowed;
	private Date borrowedDate;
	public static ArrayList<Book> books = new ArrayList<Book>();
	
	protected Book(String bookName) {
		this.bookName = bookName;
		id++;
		this.bookId = id;
		books.add(this);
	}

	public boolean isBorrowed() {
		return borrowed;
	}

	public void setBorrowed(boolean borrowed) {
		this.borrowed = borrowed;
	}

	public int getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public Date getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}
}
