package com.revature.classes;

public class AccountBean {
	private int account_id;
	private int balance;
	
	public AccountBean(int account_id, int balance) {
		super();
		this.account_id = account_id;
		this.balance = balance;
	}
	
	public int getAccount_id() {
		return account_id;
	}
	
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountBean [account_id=" + account_id + ", balance=" + balance + "]";
	} 
}
