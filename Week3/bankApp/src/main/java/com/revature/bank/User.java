package com.revature.bank;

public class User {
	public String username;
	public String password = "";
	public float balance = 0;
	public boolean admin = false;
	public boolean approval = false;
	public int accountNumber; 
	
	public User(String username) {
		this.username = username;
		this.accountNumber = 0; 
	}
	
	public User(String username, String password,float balance, boolean entity, boolean approved) {
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.admin = entity;
		this.approval = approved;
		this.accountNumber = 0; 
	}
	
	public void deposit(float deposit) {
		balance = balance + deposit;
	}
	
	public void withdraw(float withdrawal) {
		balance = balance - withdrawal;
	}

	@Override
	public String toString() {
		return "User [name=" + username + ", password=" + password + ", balance=" + balance + ", admin=" + admin
				+ ", approved=" + approval + "]";
	}
	
	
}