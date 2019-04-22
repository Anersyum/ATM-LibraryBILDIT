package Atm;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int choice = -1;
		
		while (choice != 0) {
			showChoices();
			choice = input.nextInt();
			
			if (choice == 1) {
				input.nextLine();
				createAccount(input);
			}
			else if (choice == 2) {
				transferMoney(input);
			}
			else if (choice == 3) {
				showAccountInfo(input);
			}
		}
		input.close();
		System.out.println("Thank you for using Deez Atm!");

	}
	
	public static void showChoices() {
		System.out.println("Welcome to Deez Atm. Please choose your option:"
				+ "\n1. Create account"
				+ "\n2. Transfer money to another account"
				+ "\n3. Show account info"
				+ "\n0. Exit");
	}
	
	public static void createAccount(Scanner input) {
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
		
		Account account = new Account(accountName, balance);
		System.out.println("The account with the account number " 
				+ account.getAccountNumber() + " has been created!");
	}
	
	public static void transferMoney(Scanner input) {
		long accountNumberSource, accountNumberDestination;
		double amount;
		
		if (AccountManager.numberOfAccounts() == 0 || AccountManager.numberOfAccounts() == 1) {
			System.out.println("There are no active accounts or there is only one account!");
		}
		else {
			System.out.print("Enter the account number for the source account: ");
			accountNumberSource = input.nextLong();
			if (AccountManager.getAccountByAccountNumber(accountNumberSource) == null)
				System.out.println("That account doesn't exist!");
			else {
				System.out.print("Enter the account number for the destination account: ");
				accountNumberDestination = input.nextLong();
				if (AccountManager.getAccountByAccountNumber(accountNumberDestination) == null)
					System.out.println("That account doesn't exist!");
				else {
					System.out.print("Enter the amount: ");
					amount = input.nextDouble();
					
					Transaction.transferMoney(AccountManager.getAccountByAccountNumber(accountNumberSource),
							AccountManager.getAccountByAccountNumber(accountNumberDestination), amount);
					System.out.println();
				}
			}
		}
	}
	
	public static void showAccountInfo(Scanner input) {
		long accountNumber;
		
		if (AccountManager.numberOfAccounts() == 0)
			System.out.println("There are no active accounts!");
		else {
			System.out.print("Enter account number: ");
			accountNumber = input.nextLong();
			
			if (AccountManager.getAccountByAccountNumber(accountNumber) != null) 
				AccountManager.showAccountInfo(AccountManager.getAccountByAccountNumber(accountNumber));
			else
				System.out.println("That account doesn't exist!");
		}
	}
}
