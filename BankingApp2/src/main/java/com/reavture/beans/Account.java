package com.reavture.beans;

/*
 * Class that defines the logic of what an Account is
 */
public class Account implements Comparable<Account> {
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
	@Override
	public int compareTo(Account acc1) {
		if (acc1.getAccountId() > accountId) {
			return -1;
		} else {
			return 1;
		}
	}
	
	
}
