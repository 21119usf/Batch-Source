package com.revature.bankapp;

import com.revature.util.LoggerUtil;

public class Account {
	
	private double balance;
	private int id;
	private boolean active;
    static int counter = 0;

	public Account() {
		super();
		this.id = ++Account.counter;
		this.active = false;
		this.balance = 0.00;
	}
    public Account(int id, double balance) {
		super();
		this.balance = balance;
		this.id = id;
		this.active = false;
		if(Account.counter < id) {
			Account.counter = id + 1;
		}
	}

	public Account(int id, boolean active, double balance) {
		super();
		this.balance = balance;
		this.id = id;
		this.active = active;
		if(Account.counter < id) {
			Account.counter = id + 1;
		}
	}

	public Account(double balance) {
		super();
		this.balance = balance;
		this.active = false;
		this.id = ++Account.counter;
	}
	public void Activate() {
		this.active = true;
	}
	public boolean getActive() {
		return active;
	}
	
	public double getBalance() {
		return balance;
	}

	public int getId() {
		return id;
	}

	void withdraw(double ammount) {
		if(this.balance >= ammount) {
			balance -= ammount;
			System.out.println("Withdraw successful new balance is: " + balance);
			LoggerUtil.LOGGER.info("Withdraw successful new balance is: " + balance);

		}
		else {
			System.out.println("Balance too low to withdraw " + ammount);
		}
	}
	
	void deposit(double ammount) {
		balance += ammount;
		System.out.println("Deposit successful new balance is: " + balance);
		LoggerUtil.LOGGER.info("Deposit successful new balance is: " + balance);

	}
	void transfer(double ammount, Account a) {
		if (this.balance >= ammount) {
			withdraw(ammount);
			a.deposit(ammount);
			System.out.println("Transfer successful new balance is: " + balance);
			LoggerUtil.LOGGER.info("Transfer successful new balance is: " + balance);

		}
		else {
			System.out.println("Not enough balance");
		}
	}

	@Override
	public String toString() {
		return "Account " + id +" balance: " + balance + " Activated: " + active + " ";
	}
	
	
}
