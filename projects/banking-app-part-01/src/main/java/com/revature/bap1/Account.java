package com.revature.bap1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {
	
	private static final long serialVersionUID = -8449950767722490575L;
	
	private double balance;

	public Account(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public boolean withdraw(double withdraw) {
		if (balance > withdraw) {
			balance -= withdraw;
			return true;
		}
		return false;
	}
	
	public void deposit(double deposit) {
		this.balance += deposit;
	}

	@Override
	public String toString() {
		return "balance=" + balance;
	}
}
