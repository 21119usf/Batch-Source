package com.revature.beans;

import java.io.Serializable;

public abstract class User implements Serializable {

	private static final long serialVersionUID = 2861750910943475088L;


	public User(String firstName, String lastName, String sSN, String email, String address, String username,
			String hash, int userId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		SSN = sSN;
		this.email = email;
		this.address = address;
		this.username = username;
		this.hash = hash;
		this.userId = userId;
	}
	private String firstName;
	private String lastName;
	private String SSN;
	private String email;
	private String address;
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	private String hash;
	private int userId;

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
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
