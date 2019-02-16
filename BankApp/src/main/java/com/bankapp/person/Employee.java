package com.bankapp.person;

import com.bankapp.account.Account;

// Employee class
public class Employee extends Person {
	private static final long serialVersionUID = 6683281331440066118L;
	private static int count = 0;
	private int id;
	private String username;
	private String password;
	
	// Constructor
	public Employee(String un, String pw) {
		setId(count++);
		setUsername(un);
		setPassword(pw);
	}
	
	// Approve an account
	public void approveAccount(Account a) {
		a.setOpen(true);
	}
	// Deny an account
	public void denyAccount(Account a) {
		a.setOpen(false);
	}
	// Retrieve customer information
	//public Customer getCustomerInfo(int id) {
		// Find customer by id
	//}
	// Retrieve account information
	//public Account getAccountInfo(int id) {
		// find account by id
	//}

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
}
