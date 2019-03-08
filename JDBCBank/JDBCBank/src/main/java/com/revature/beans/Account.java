package com.revature.beans;

public class Account {
	private int accountNumber;
	private int accountBalance;
	private int CustomerID;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int accountNumber, int accountBalance, int customerID) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		CustomerID = customerID;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + ", CustomerID="
				+ CustomerID + "]";
	}
	
	
}
