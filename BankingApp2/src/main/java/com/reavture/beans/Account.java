package com.reavture.beans;

public class Account {
	private double balance;
	private int accountId;
	private int primaryOwner;
	private int secondaryOwner;
	private AccountStatus status;
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getPrimaryOwner() {
		return primaryOwner;
	}
	public void setPrimaryOwner(int primaryOwner) {
		this.primaryOwner = primaryOwner;
	}
	public int getSecondaryOwner() {
		return secondaryOwner;
	}
	public void setSecondaryOwner(int secondaryOwner) {
		this.secondaryOwner = secondaryOwner;
	}
	public AccountStatus getStatus() {
		return status;
	}
	public void setStatus(AccountStatus status) {
		this.status = status;
	}
	public String isJoint() {
		if (secondaryOwner == 0) {
			return "No";
		} else {
			return "Yes";
		}
	}
	
	
}
