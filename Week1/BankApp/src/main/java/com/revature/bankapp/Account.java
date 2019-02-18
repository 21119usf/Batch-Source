package com.revature.bankapp;

public class Account {
	
	private double balance;
	private int id;
    static int counter = 0;

	
    public Account(int id, double balance) {
		super();
		this.balance = balance;
		this.id = id;
		Account.counter = id + 1;
	}

	public Account(double balance) {
		super();
		this.balance = balance;
		this.id = Account.counter++;
	}
	
	public double getBalance() {
		return balance;
	}

	public int getId() {
		return id;
	}

	void withdraw(double ammount) {
		if(ammount <= balance) {
			balance -= ammount;
			System.out.println("Withdraw successful new balance is: " + balance);
		}
		else {
			System.out.println("Balance too low to withdraw " + ammount);
		}
	}
	
	void deposit(double ammount) {
		balance += ammount;
	}
	void transfer(double ammount, Account a) {
		withdraw(ammount);
		a.deposit(ammount);
	}
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", id=" + id + "]";
	}
}
