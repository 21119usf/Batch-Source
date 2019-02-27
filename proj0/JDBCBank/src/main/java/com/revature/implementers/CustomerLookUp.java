package com.revature.implementers;

public class CustomerLookUp {
	String firstname;
	String lastname;
	String DOB;
	String street;
	String city;
	String state;
	String cell;
	String email;
	String username;
	int accountID;
	int userID;
	
	public CustomerLookUp() {
	}
	
	public CustomerLookUp(String firstname, String lastname, int accountID, int userID) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.accountID = accountID;
		this.userID = userID;
	}
	
	public CustomerLookUp(String firstname, String lastname,String DOB,String street,String city,String state,String cell, String email, int userID) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.DOB = DOB;
		this.street = street;
		this.city = city;
		this.state = state;
		this.cell = cell;
		this.email = email;
		this.userID = userID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public String toString1() {
		return  "USER ID: " +userID+"| FIRSTNAME: "+firstname+" |LASTNAME: "+lastname+" |DOB: "+DOB+" |ADDRESS: "+street+", "+city+", "+state+
				" |PHONE#: "+cell+" |EMAIL: "+email;
	}
	public String toString2() {
		return "USER ID: "+userID + "| ACCOUNT ID: "+accountID +" |FIRSTNAME: "+firstname+" |LASTNAME: "+lastname;
	}
	
	
}
