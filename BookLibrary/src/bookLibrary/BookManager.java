package bookLibrary;

import java.util.ArrayList;
import java.util.Date;

public class BookManager{

	private static ArrayList<Book> books = new ArrayList<Book>();
	
	public static void showBookInfo(Book book) {
		System.out.println("Book id: " + book.getBookId()
				+ "\nBook name: " + book.getBookName());
		if (book.isBorrowed())
			System.out.println("Borrowed on:" + book.getBorrowedDate());
	}
	
	public static Book getBookById(int id) {
		for (Book book : books) {
			if (book.getBookId() == id)
				return book;
		}
		return null;
	}
	
	public static int getNumberOfBooks() {
		return books.size();
	}
	
	public static void borrow(Account userAccount, Book bookToBorrow) {
		if (hasBorrowedMoreThanThreeBooks(userAccount))
			System.out.println("This user can't borrow any books until he returns at least one!");
		else if (bookToBorrow.isBorrowed())
			System.out.println("This book is already borrowed!");
		else {
			bookToBorrow.setBorrowed(true);
			System.out.println("The book has been borrowed succesfuly on " + new Date());
			bookToBorrow.setBorrowedDate(new Date());
			userAccount.addBorrowedBookToAccount(bookToBorrow);
		}
	}
	
	private static boolean hasBorrowedMoreThanThreeBooks(Account account) {
		return account.getNumberOfBorrowedBooks() > 3;
	}
	
	public static void addBookToLibrary(String bookName) {
		Book book = new Book(bookName);
		
		books.add(book);
		System.out.println("The book with the name of " + bookName + " has been added to the library with "
				+ "the id of " + book.getBookId());
	}
	
	public static void returnBook(Account account, Book bookToRemove) {
		if (account.getNumberOfBorrowedBooks() <= 0) 
			System.out.println("This account has no borrowed books!");
		else {
			account.getBorrowedBooks().removeIf((Book book) -> book.getBookId() == bookToRemove.getBookId());
			bookToRemove.setBorrowed(false);
			System.out.println("The book has been returned!");
		}
	}
}
