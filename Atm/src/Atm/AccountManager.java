package Atm;

public class AccountManager{
	
	public static void showAccountInfo(Account account) {
		System.out.println("Account number: " + account.getAccountNumber()
				+ "\nAccount name: " + account.getAccountName()
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
	
	public static void createAccount(String accountName, double balance) {
		Account account = new Account(accountName, balance);
		
		System.out.println("The account with the account number " 
				+ account.getAccountNumber() + " has been created!");
	}
	
}
