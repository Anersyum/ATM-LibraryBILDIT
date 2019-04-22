package Atm;

public class AccountManager{
	
	public static void showAccountInfo(Account account) {
		System.out.println("Account number: " + account.getAccountNumber()
				+ "\nAccount name: " + account.getAccountName()
				+ "\nBalance: " + account.getBalance() + "$");
	}
	
	public static Account getAccountByAccountNumber(long accountNumber) {
		for (Account acc : Account.accounts) {
				if (acc.getAccountNumber() == accountNumber)
					return acc;
		}
		return null;
	}
	
	public static int numberOfAccounts() {
		return Account.accounts.size();
	}
}
