package com.revature.beans;

public class Account {
	
	private int accountID;
	private int customerID;
	private double balance;
	
	public Account() {
		super();
	}

	public Account(int accountID, int customerID, double balance) {
		super();
		this.accountID = accountID;
		this.customerID = customerID;
		this.balance = balance;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", customerID=" + customerID + ", balance=" + balance + "]";
	}
}
