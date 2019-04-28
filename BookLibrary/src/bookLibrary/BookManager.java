package bookLibrary;

import java.util.Date;

public class BookManager{
	
	public static void showBookInfo(Book book) {
		System.out.println("Book id: " + book.getBookId()
				+ "\nBook name: " + book.getBookName()
				+ "\nIs borrowed? " + book.isBorrowed()
				+ "\nBorrowed on:" + book.getBorrowedDate());
	}
	
	public static Book getBookById(int id) {
		for (Book book : Book.books) {
			if (book.getBookId() == id)
				return book;
		}
		return null;
	}
	
	public static int getNumberOfBooks() {
		return Book.books.size();
	}
	
	public static void borrow(int accountId, int bookId) {
		Account userAccount = AccountManager.getAccountById(accountId);
		Book bookToBorrow = getBookById(bookId);
		
		if (userAccount == null)
			System.out.println("The account doesn't exist!");
		else if (bookToBorrow == null)
			System.out.println("The book doesn't exist!");
		else if (hasBorrowedMoreThanThreeBooks(userAccount))
			System.out.println("This user can't borrow any books until he returns at least one!");
		else if (bookToBorrow.isBorrowed())
			System.out.println("This book is already borrowed!");
		else {
			userAccount.setNumberOfBorrowedBooks(userAccount.getNumberOfBorrowedBooks() + 1);
			bookToBorrow.setBorrowed(true);
			System.out.println("The book has been borrowed succesfuly on " + new Date());
			bookToBorrow.setBorrowedDate(new Date());
			userAccount.addBorrowedBookToAccount(bookToBorrow);
		}
	}
	
	private static boolean hasBorrowedMoreThanThreeBooks(Account account) {
		return account.getNumberOfBorrowedBooks() > 3;
	}
}
