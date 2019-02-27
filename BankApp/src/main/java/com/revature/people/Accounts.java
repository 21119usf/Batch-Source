package com.revature.people;

public class Accounts {
    private int accountid;
    private double balance;
    private boolean active;
    private int primaryUser;
    private int secondaryUser;
    private ActiveInactive status;
    
	
	public Accounts() {}


	public int getAccountid() {
		return accountid;
	}


	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public int getPrimaryUser() {
		return primaryUser;
	}


	public void setPrimaryUser(int primaryUser) {
		this.primaryUser = primaryUser;
	}


	public int getSecondaryUser() {
		return secondaryUser;
	}


	public void setSecondaryUser(int secondaryUser) {
		this.secondaryUser = secondaryUser;
	}


	public ActiveInactive getStatus() {
		return status;
	}


	public void setStatus(ActiveInactive status) {
		this.status = status;
	}


	public Accounts(int accountid, double balance, boolean active, int primaryUser, int secondaryUser,
			ActiveInactive status) {
		super();
		this.accountid = accountid;
		this.balance = balance;
		this.active = active;
		this.primaryUser = primaryUser;
		this.secondaryUser = secondaryUser;
		this.status = status;
	}
	
	public String isJoint() {
		if (secondaryUser == 0) {
			return "No";
		} else {
			return "Yes";
		}
	}


}
