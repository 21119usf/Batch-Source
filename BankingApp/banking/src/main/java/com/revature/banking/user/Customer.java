package com.revature.banking.user;

public class Customer extends User{
	private int ID;
	private double accountBalance;
	private boolean joint;
	
	
	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", accountBalance=" + accountBalance + ", joint=" + joint + ", getUsername()="
				+ getUsername() + ", getUserStatus()=" + getUserStatus() + "]";
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public boolean isJoint() {
		return joint;
	}
	public void setJoint(boolean joint) {
		this.joint = joint;
	}
}
