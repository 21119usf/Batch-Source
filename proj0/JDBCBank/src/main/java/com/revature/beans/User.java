package com.revature.beans;


public abstract class User{
	
	private String username;
	private String password;
	private int userID;
	private int accountID;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(Object userID) {
		this.userID = Integer.parseInt(userID.toString());
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(Object accountID) {
		this.accountID = Integer.parseInt(accountID.toString());
	}
	
	
	
	
}
