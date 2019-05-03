package Atm;

import java.util.InputMismatchException;
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
		
		do {
			try {
				balance = input.nextDouble();
				if (balance < 0)
					System.out.print("The balance must be positive!\nEnter your balance: ");
			} catch (InputMismatchException e) {
				System.out.print("Wrong input! Please enter a number for the balance: ");
				balance = -1;
			}
			input.nextLine();
		} while (balance < 0);
		AccountManager.createAccount(accountName, balance);
	}
	
	public static void transactionMenu(Scanner input) {
		long sourceAccountNumber, destinationAccountNumber;
		double amount = 0;
		
		if (AccountManager.numberOfAccounts() < 2) {
			System.out.println("There are no active accounts or there is only one account!");
		}
		else {
			while (true) {
				try {
					System.out.print("Enter the account number for the source account: ");
					sourceAccountNumber = input.nextLong();
					Account sourceAccount = AccountManager.getAccountByAccountNumber(sourceAccountNumber);

					System.out.print("Enter the account number for the destination account: ");
					destinationAccountNumber = input.nextLong();
					Account destinationAccount = AccountManager.getAccountByAccountNumber(destinationAccountNumber);
					
					if (Transaction.checkIfAccountsExist(sourceAccount, destinationAccount)) {
						System.out.print("Enter the amount: ");
						amount = input.nextDouble();
							
						while (amount < 0) {
							System.out.print("The amount can't be negative: ");
							amount = input.nextDouble();
						}
							Transaction.transferMoney(sourceAccount, destinationAccount, amount);
							break;
					}
			} catch (Exception e) {
				if (e.toString().equals("java.lang.Exception: Not enough funds")) {
					System.out.println("There is not enough funds on that account!");
					break;
				} else
					System.out.println("You must enter numbers for each field.");
			}
			input.nextLine();
		}
		System.out.println();
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
