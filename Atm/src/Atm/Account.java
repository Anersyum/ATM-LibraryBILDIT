package Atm;

import java.util.ArrayList;

public class Account {

	private long accountNumber;
	private String firstName;
	private String lastName;
	private double balance;
	private ArrayList<Long> accountNumbersList = new ArrayList<Long>();
	
	
	public Account(String firstName, String lastName, double balance) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.setBalance(balance);
		this.createUniqueAccountNumber();
	}
	
	public Account(long accountNumber, String firstName, String lastName, double balance) {
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}

	public String getFullName() {
		return this.firstName + " " + this.lastName;
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
