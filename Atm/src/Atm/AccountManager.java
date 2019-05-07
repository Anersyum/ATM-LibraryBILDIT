package Atm;

import java.util.ArrayList;

public class AccountManager{
	
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	
	public static void showAccountInfo(Account account) {
		System.out.println("Account number: " + account.getAccountNumber()
				+ "\nAccount name: " + account.getFullName()
				+ "\nBalance: " + account.getBalance() + "$");
	}
	
	public static Account getAccountByAccountNumber(long accountNumber) {
		for (Account acc : getAccounts()) {
				if (acc.getAccountNumber() == accountNumber)
					return acc;
		}
		return null;
	}
	
	public static int numberOfAccounts() {
		return getAccounts().size();
	}
	
	public static void createAccount(String firstName, String lastName, double balance) {
		Account account = new Account(firstName, lastName, balance);
		accounts.add(account);
		System.out.println("The account with the account number " 
				+ account.getAccountNumber() + " has been created!");
	}
	
	public static void createAccount(long accountNumber, String firstName, String lastName, double balance) {
		Account account = new Account(accountNumber, firstName, lastName, balance);
		accounts.add(account);
	}
	
	public static ArrayList<Account> getAccounts() {
		return accounts;
	}
}
