package Atm;

public class AccountManager{
	
	public static void showAccountInfo(Account account) {
		System.out.println("Account number: " + account.getAccountNumber()
				+ "\nAccount name: " + account.getFullName()
				+ "\nBalance: " + account.getBalance() + "$");
	}
	
	public static Account getAccountByAccountNumber(long accountNumber) {
		for (Account acc : Account.getAccounts()) {
				if (acc.getAccountNumber() == accountNumber)
					return acc;
		}
		return null;
	}
	
	public static int numberOfAccounts() {
		return Account.getAccounts().size();
	}
	
	public static void createAccount(String firstName, String lastName, double balance) {
		Account account = new Account(firstName, lastName, balance);
		
		System.out.println("The account with the account number " 
				+ account.getAccountNumber() + " has been created!");
	}
	
}
