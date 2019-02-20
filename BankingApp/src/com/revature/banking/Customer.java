package com.revature.banking;

import java.util.ArrayList;

public class Customer {
	private String userID;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private ArrayList<Integer> accountID;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public ArrayList<Integer> getAccountID() {
		return accountID;
	}
	public void setAccountID(ArrayList<Integer> accountID) {
		this.accountID = accountID;
	}
	public Customer(String userID, String userName, String password, String firstName, String lastName,
			ArrayList<Integer> accountID) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountID = accountID;
		
		
	}
	public Customer(String userID, String userName, String password, String firstName, String lastName) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		accountID = new ArrayList<Integer>();
	}
	
	

}
