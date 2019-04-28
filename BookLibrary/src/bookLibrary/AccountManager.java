package bookLibrary;

public class AccountManager{
	
	public static void showAccountInfo(int accountId) {
		Account acc = AccountManager.getAccountById(accountId);
		
		System.out.println("Account ID: " + acc.getAccountId()
				+ "\nAccount name: " + acc.getAccountName()
				+ "\nNumber of borrowed books (max 3): " + acc.getNumberOfBorrowedBooks());
		if (acc.getNumberOfBorrowedBooks() > 0) {
			for (int i = 0; i < acc.getNumberOfBorrowedBooks(); i++) {
				Book book = acc.getBorrowedBooks().get(i);
				BookManager.showBookInfo(book);
			}
		}
	}
	
	public static Account getAccountById(int id) {
		for (Account acc : Account.accounts) {
			if (acc.getAccountId() == id)
				return acc;
		}
		return null;
	}
	
	public static int getNumberOfAccounts() {
		return Account.accounts.size();
	}
}
