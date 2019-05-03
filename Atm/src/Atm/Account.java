package Atm;

import java.util.ArrayList;

public class Account {

	private long accountNumber;
	private String accountName;
	private double balance;
	private ArrayList<Long> accountNumbersList = new ArrayList<Long>();
	private static ArrayList<Account> accounts = new ArrayList<Account>();
	
	public Account(String accountName, double balance) {
		this.accountName = accountName;
		this.setBalance(balance);
		this.createUniqueAccountNumber();
		accounts.add(this);
	}

	public String getAccountName() {
		return accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if (balance > 0)
			this.balance = balance;			
	}
	
	public long getAccountNumber() {
		return this.accountNumber;
	}
	
	public static ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	private void createUniqueAccountNumber() {
		long accNumber = (long)(Math.random() * 8999999999L) + 1000000000L;
		
		while (!isUniqueAccountNumber(accNumber)) {
			accNumber = (long)(Math.random() * 8999999999L) + 1000000000L;
		}
		this.accountNumber = accNumber;
	}
	
	private boolean isUniqueAccountNumber(long accountNumber) {
		for (int i = 0; i < accountNumbersList.size(); i++) {
			if (accountNumbersList.get(i) == accountNumber)
				return false;
		}
		return true;
	}
}
