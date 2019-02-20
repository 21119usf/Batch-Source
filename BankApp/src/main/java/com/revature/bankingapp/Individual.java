package com.revature.bankingapp;

import java.io.Serializable;

public class Individual extends Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6771173798079325370L;
	
	int accountNum;
	float balance;
	String custFirst;
	String custLast;
	String userName;
	boolean approval = false;

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	void deposit(float depAmount) {
		this.balance = balance+depAmount;
		// TODO Auto-generated method stub
		
	}

	@Override
	void withdraw(float wdAmount) {
		this.balance = balance+wdAmount;
	}

	@Override
	void transfer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void view() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "\nIndividual Account Details: \nAccount Number: " + accountNum +
				"\nName: " + custFirst+ " " + custLast+
				"\nBalance: $" + balance+"\n";
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getCustFirst() {
		return custFirst;
	}

	public void setCustFirst(String custFirst) {
		this.custFirst = custFirst;
	}

	public String getCustLast() {
		return custLast;
	}

	public void setCustLast(String custLast) {
		this.custLast = custLast;
	}

	public Individual() {
		// TODO Auto-generated constructor stub
	}

}
