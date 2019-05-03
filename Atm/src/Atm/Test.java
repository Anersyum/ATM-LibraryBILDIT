package Atm;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int choice = -1;
		
		while (choice != 0) {
			ATM.showMenu();
			
			try {
				System.out.print("Option: ");
				choice = input.nextInt();
			} catch (Exception e) {
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
		System.out.println("Thank you for using Deez Atm!");

	}
}
