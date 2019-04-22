package Atm;

public class Transaction {

	public static void transferMoney(Account sourceAccount, Account destinationAccount, double amount) {
		if (isBalanceNegative(sourceAccount, amount)) {
			System.out.println("The transfer is not possible, the balance will be below zero for account " 
					+ sourceAccount.getAccountNumber());
		}
		else {
			sourceAccount.setBalance(sourceAccount.getBalance() - amount);
			destinationAccount.setBalance(destinationAccount.getBalance() + amount);
			System.out.println("Transaction complete!");
		}
	}
	
	private static boolean isBalanceNegative(Account sourceAccount, double amount) {
		if ((sourceAccount.getBalance() - amount) < 0)
			return true;
		return false;
	}
}
