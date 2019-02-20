package com.revature.bankApp;

import java.util.Random;

public class Account {
	
	private double balance;
	private int accountNumber;
	
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	//Balance Setters Deposit and Withdraw
	public void deposit(double amount) {
		
		if(amount > 0) {
			balance+=amount;
		}else {
			System.out.print("can't deposit IOUs ");
		}
	}
	
	public void withdraw(double withdraw) {
		if(balance > withdraw) {
			balance -= withdraw; //balance = balance - withdraw
			System.out.println("you took out " + withdraw);
			//return withdraw;
		}else {
			System.out.println("you broke fool, but I can give you 0 dollars" );
			//return 0;
		}
		
	}
	
	public double getBalance() {
		return balance;
	}
	
	
	public int randomAccountNumber() {
		Random random = new Random();
		int newAccountNumber = random.nextInt((19999 - 10000) + 1) + 10000;
		return newAccountNumber;
		
	}
	
	public Account(double balance) {
		super();
		this.balance = balance;
		this.accountNumber = randomAccountNumber();

	}
	
}
