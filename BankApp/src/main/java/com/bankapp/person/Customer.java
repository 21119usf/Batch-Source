package com.bankapp.person;

import java.util.ArrayList;

import com.bankapp.account.Account;

// Customer class
public class Customer extends Person {
	private static final long serialVersionUID = 4473186511868357784L;
	private static int count = 0;
	private int id;
	private String username;
	private String password;
	private String email;
	private long phoneNumber;
	private ArrayList<Account> accounts;
	
	// Constructor
	public Customer(String un, String pw, String fn, String ln, 
	String em, String ad, long pn, long ss) {
		setId(count++);
		setUsername(un);
		setPassword(pw);
		setFirstName(fn);
		setLastName(ln);
		setEmail(em);
		setAddress(ad);
		setPhoneNumber(pn);
		setSsNumber(ss);
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
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password="
				+ password + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", accounts=" + accounts + "]";
	}
}
