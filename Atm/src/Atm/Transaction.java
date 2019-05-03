package Atm;

public class Transaction {

	public static void transferMoney(Account sourceAccount, Account destinationAccount, double amount) {
		if (hasEnoughFunds(sourceAccount, amount)) {
			System.out.println("Not enough funds");
		}
		else {
			sourceAccount.setBalance(sourceAccount.getBalance() - amount);
			destinationAccount.setBalance(destinationAccount.getBalance() + amount);
			System.out.println("Transaction complete!");
		}
	}
	
	private static boolean hasEnoughFunds(Account sourceAccount, double amount) {
		if ((sourceAccount.getBalance() - amount) < 0)
			return true;
		return false;
	}
	
	public static boolean checkIfAccountsExist(Account sourceAccount, Account destinationAccount) {
		if (sourceAccount == null || destinationAccount == null) {
			return false;
		}
		return true;
	}
}
