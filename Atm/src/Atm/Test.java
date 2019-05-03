package Atm;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int choice = -1;
		
		while (choice != 0) {
			ATM.showMenu();
			choice = input.nextInt();
			
			if (choice == 1) {
				input.nextLine();
				ATM.accountCreationMenu(input);
			} else if (choice == 2) {
				ATM.transactionMenu(input);
			} else if (choice == 3) {
				ATM.accountInfoMenu(input);
			}
			input.nextLine();
		}
		input.close();
		System.out.println("Thank you for using Deez Atm!");

	}
}
