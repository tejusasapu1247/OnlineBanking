package model;

public class Transactions {
	static int balance=0;

	public static int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		System.out.println("i am setter method..i got 500");
		this.balance = balance;
	}
}
