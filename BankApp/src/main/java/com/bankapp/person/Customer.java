package com.bankapp.person;

import java.util.ArrayList;

import com.bankapp.account.Account;

// Customer class
public class Customer extends Person {
	private static int count = 0;
	private int id;
	private String username;
	private String password;
	private String email;
	private String phoneNumber;
	private ArrayList<Account> accounts;
	
	// Constructor
	Customer(String un, String pw, String em, String pn) {
		setId(count++);
		setUsername(un);
		setPassword(pw);
		setEmail(em);
		setPhoneNumber(pn);
	}

	// Get/set methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
}
