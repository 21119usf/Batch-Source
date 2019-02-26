package com.bankapp.user;

import java.util.Random;

import com.bankapp.account.Account;

// Employee class
public class Employee extends User {
	private static final long serialVersionUID = 6683281331440066118L;
	private int id;
	private String username;
	private String password;
	
	// Constructor
	public Employee(String un, String pw) {
		Random r = new Random();
		id = 100000000 + r.nextInt(900000000);
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}
}
