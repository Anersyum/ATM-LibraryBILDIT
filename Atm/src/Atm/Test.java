package Atm;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		File file = new File("accounts.txt");
		int choice = -1;
		
		readFile(file);
		while (choice != 0) {
			ATM.showMenu();
			
			try {
				System.out.print("Option: ");
				choice = input.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("You must enter a number!");
				input.nextLine();
				continue;
			}
			
			switch (choice) {
				case 0:
					break;
				case 1:
					input.nextLine();
					ATM.accountCreationMenu(input);
					break;
				case 2:
					ATM.transactionMenu(input);
					break;
				case 3:
					ATM.accountInfoMenu(input);
					break;
				default:
					System.out.println("Enter a valid option.");
					break;
			}
			input.nextLine();
			System.out.println();
		}
		input.close();
		writeToFile(file);
		System.out.println("Thank you for using Deez Atm!");
	}
	
	private static void writeToFile(File file) {
		try (PrintWriter output = new PrintWriter(file)) {
			for (Account acc : Account.getAccounts()) {
				output.print(acc.getAccountNumber() + " ");
				output.print(acc.getAccountName() + " ");
				output.println(acc.getBalance());
			}
		} catch (IOException e) {
				System.out.println("File exists!");
		}
	}
	
	private static void readFile(File file) {
		if (file.exists()) {
			long accountNumber;
			String accountName;
			double balance;
			
			try (Scanner readFromFile = new Scanner(file)) {
				while (readFromFile.hasNext()) {
					accountNumber = readFromFile.nextLong();
					accountName = readFromFile.next();
					balance = readFromFile.nextDouble();
					new Account(accountNumber, accountName, balance);
				}
			} catch (IOException e) {
				System.out.println("File doesn't exist!");
			}
		}
	}
}

