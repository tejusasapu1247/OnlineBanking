package model;

public class Transactions {
	private static int balance=0;

	public static int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		Transactions.balance = balance;
	}
}
