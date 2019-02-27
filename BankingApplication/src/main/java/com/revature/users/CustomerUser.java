package com.revature.users;

import  com.revature.beans.*;

public class CustomerUser extends User{

	String firstName;
	String lastName;	
	String userName;
	String passWord;
	int userID;
	
	public CustomerUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerUser(int userID, String firstName, String lastName, String userName, String passWord) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.passWord = passWord;
		this.userID = userID;
	}
	public CustomerUser(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}
	public CustomerUser(int userID) {
		super();
		this.userID = userID;
	}
	public void viewBalance() {}
	public void deposit() {}
	public void withdraw() {}
	public void delete() {}
	public void logout() {}
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nUsername: " + userName
				+ "\t\t Password: " + passWord + "\t\t userID: " + userID;
	}
	
	
	
}
