package com.revature.bankingapp;

import java.io.Serializable;

public class Customer extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1296778541752199228L;
	
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", userID=" + userID + ", passWord="
				+ passWord + "]";
	}

	String firstName;
	String lastName;	
	String userID;
	String passWord;
	
		
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void viewBalance() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void viewTransactions() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void viewAccountInfo() {
		// TODO Auto-generated method stub
		
	}
	
	void deposit() {
		// TODO Auto-generated method stub
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	void withdraw() {
		// TODO Auto-generated method stub
		
	}

	void transfer() {
		// TODO Auto-generated method stub
		
	}

}
