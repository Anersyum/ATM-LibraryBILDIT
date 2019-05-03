package Atm;

public class Transaction {

	public static void transferMoney(Account sourceAccount, Account destinationAccount, double amount) throws Exception {
		if (isBalanceNegative(sourceAccount, amount)) {
			throw new Exception("Not enough funds");
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
	
	public static boolean checkIfAccountsExist(Account sourceAccount, Account destinationAccount) {
		if (sourceAccount == null || destinationAccount == null) {
			return false;
		}
		return true;
	}
}
