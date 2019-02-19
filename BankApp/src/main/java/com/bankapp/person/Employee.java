package com.bankapp.person;

import java.util.Random;

import com.bankapp.account.Account;

// Employee class
public class Employee extends Person {
	private static final long serialVersionUID = 6683281331440066118L;
	private int id;
	private String username;
	private String password;
	
	// Constructor
	public Employee(String un, String pw, String fn, String ln) {
		Random rnd = new Random();
		id = 100000 + rnd.nextInt(900000);
		setUsername(un);
		setPassword(pw);
		setFirstName(fn);
		setLastName(ln);
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
