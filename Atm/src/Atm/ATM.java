package Atm;

import java.util.Scanner;

public class ATM {
	
	public static void showMenu() {
		System.out.println("Welcome to Deez Atm. Please choose your option:"
				+ "\n1. Create account"
				+ "\n2. Transfer money to another account"
				+ "\n3. Show account info"
				+ "\n0. Exit");
	}
	
	public static void accountCreationMenu(Scanner input) {
		double balance = -1;
		String accountName;
		
		System.out.print("Enter account name: ");
		accountName = input.nextLine();
		System.out.print("Enter your balance: ");
		balance = input.nextDouble();
		
		while (balance < 0) {
			System.out.print("The balance must be positive!\nEnter your balance: ");
			balance = input.nextDouble();
		}
		
		AccountManager.createAccount(accountName, balance);

	}
	
	public static void transactionMenu(Scanner input) {
		long sourceAccountNumber, destinationAccountNumber;
		double amount = 0;
		
		if (AccountManager.numberOfAccounts() < 2) {
			System.out.println("There are no active accounts or there is only one account!");
		}
		else {
			System.out.print("Enter the account number for the source account: ");
			sourceAccountNumber = input.nextLong();
			if (AccountManager.getAccountByAccountNumber(sourceAccountNumber) == null)
				System.out.println("That account doesn't exist!");
			else {
				System.out.print("Enter the account number for the destination account: ");
				destinationAccountNumber = input.nextLong();
				if (AccountManager.getAccountByAccountNumber(destinationAccountNumber) == null)
					System.out.println("That account doesn't exist!");
				else {
					System.out.print("Enter the amount: ");
					amount = input.nextDouble();
					
					AccountManager.transferMoney(sourceAccountNumber, destinationAccountNumber, amount);
				}
			}
		}
	}
	
	public static void accountInfoMenu(Scanner input) {
		long accountNumber;
		
		if (AccountManager.numberOfAccounts() == 0)
			System.out.println("There are no active accounts!");
		else {
			System.out.print("Enter account number: ");
			accountNumber = input.nextLong();
			Account account = AccountManager.getAccountByAccountNumber(accountNumber);
			
			if (account != null) 
				AccountManager.showAccountInfo(account);
			else
				System.out.println("That account doesn't exist!");
		}
	}
	
}
