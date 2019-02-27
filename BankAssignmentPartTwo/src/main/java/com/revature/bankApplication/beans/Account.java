package com.revature.bankApplication.beans;

public class Account {

	private int customerid;
	private int accountNumber;
	private double balance;
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public double getBalance() {
		return balance;
	}

	// Balance Setters Deposit and Withdraw
	public void deposit(double amount) {

		if (amount > 0) {
			balance += amount;
		} else {
			System.out.print("can't deposit IOUs ");
		}
	}

	public void withdraw(double withdraw) {
		if (balance > withdraw) {
			balance -= withdraw; // balance = balance - withdraw
			System.out.println("you took out " + withdraw);
			// return withdraw;
		} else {
			System.out.println("you broke fool, but I can give you 0 dollars");
			// return 0;
		}

	}

	

}
