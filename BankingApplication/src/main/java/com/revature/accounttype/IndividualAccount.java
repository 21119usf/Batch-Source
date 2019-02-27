package com.revature.accounttype;

import com.revature.beans.*;

public class IndividualAccount extends Account {

	float balance;
	int accountNum;
	int userID;
	
	public IndividualAccount(float balance, int accountNum, int userID) {
		super();
		this.balance = balance;
		this.accountNum = accountNum;
		this.userID = userID;
	}
	public IndividualAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "IndividualAccount [balance=" + balance + ", accountNum=" + accountNum + ", userID=" + userID + "]";
	}
	
	
}
