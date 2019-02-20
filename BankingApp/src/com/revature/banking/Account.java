package com.revature.banking;

public class Account {
	private int accountID;
	private int balance;
	static int uniqueID = 0;
	int previousTransaction;
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Account(int accountID, int balance) {
		super();
		this.accountID = accountID;
		this.balance = balance;
	}
	public Account() {
		super();
		this.balance = 0;
		this.accountID = uniqueID;
		uniqueID++;
	}
	void deposit(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	//This will allow a negative amount affect your balance
	void withdraw(int amount) {
		if(amount != 0) {
			balance = balance - amount;
			previousTransaction = amount;
		}
	}
	//Displays the previous transactions on the account
	void getPreviousTransaction() {
		if(previousTransaction < 0) {
			System.out.println("Deposited: "+ previousTransaction);
		}
		else if(previousTransaction > 0) {
			System.out.println("Withdrawn: "+ previousTransaction);
			// Math.abs changes the negative amount to a positive
		}
		else{
			System.out.println("No Transaction Occured");
		}
	}
	
	

}
