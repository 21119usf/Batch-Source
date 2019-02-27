package com.revature.beans;

import java.io.FileNotFoundException;

public class Customer extends User{
	private String firstname;
	private String lastname;
	private String DOB;
	private String street;
	private String city;
	private String state;
	private String cell;
	private String emailAddress;
	private int accountID;

	public Customer() {
	}
	
	public Customer(String firstname, String lastname, String DOB, String street, String city, String state, String cell, String emailAddress) {
		super();
		this.firstname = (firstname);
		this.lastname = (lastname);
		this.setDOB(DOB);
		this.street = street;
		this.city = city;
		this.state = state;
		this.setCell(cell);
		this.setEmailAddress(emailAddress);
	}


	public int getAccountID() {
		return accountID;
	}
	public void setAccoutID(int acctID) {
		this.accountID = acctID;
	}
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}
	
	public String toString() {
		return "First name: " +  firstname + "\nLastname: " + lastname + "\nDOB: " + DOB + "\nAddress: " + street + ", " + city + ", " + state +
				"\nCell Phone: " + cell + "\nEmail Address: " + emailAddress;
		
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}
}
