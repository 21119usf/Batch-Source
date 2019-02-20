package com.revature.banking.user;

public class Customer extends User{
	private static int ID;
	private double accountBalance;
	private static boolean joint;
	private static String fullName;
	
	
	public static String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String toString() {
		return getUsername() + ": [ID=" + ID + ", Full Name=" + getFullName() + ", joint=" + joint + ", username="
				+ getUsername() + "]";
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
