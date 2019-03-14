package com.revature.beans;

public class User {
	
	private String username;
	private String password;
	private int userID;
	
	public User(String id) {
		this.userID=(Integer.parseInt(id));
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + password + "]";
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
}
