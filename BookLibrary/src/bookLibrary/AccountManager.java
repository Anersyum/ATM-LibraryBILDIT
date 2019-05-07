package bookLibrary;

import java.util.ArrayList;

public class AccountManager{
	
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	
	public static void showAccountInfo(Account acc) {
		System.out.println("Account ID: " + acc.getAccountId()
				+ "\nAccount name: " + acc.getFullName()
				+ "\nNumber of borrowed books (max 3): " + acc.getNumberOfBorrowedBooks());
		if (acc.getNumberOfBorrowedBooks() > 0) {
			for (int i = 0; i < acc.getNumberOfBorrowedBooks(); i++) {
				Book book = acc.getBorrowedBooks().get(i);
				BookManager.showBookInfo(book);
			}
		}
	}
	
	public static Account getAccountById(int id) {
		for (Account acc : accounts) {
			if (acc.getAccountId() == id)
				return acc;
		}
		return null;
	}
	
	public static int getNumberOfAccounts() {
		return accounts.size();
	}
	
	public static ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	public static void createAccount(String firstName, String lastName) {
		Account acc = new Account(firstName, lastName);
		
		accounts.add(acc);
		System.out.println("The account with the name of " + acc.getFullName() + " has been created"
				+ " with the id of " + acc.getAccountId());
	}
}
