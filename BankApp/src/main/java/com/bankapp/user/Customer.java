package com.bankapp.user;

import java.util.ArrayList;
import java.util.Random;

// Customer class
public class Customer extends User {
	private static final long serialVersionUID = 4473186511868357784L;
	private int id;
	private String username;
	private String password;
	private String email;
	private long phoneNumber;
	private ArrayList<Integer> accountIds;
	
	// Constructor
	public Customer(String un, String pw, String fn, String ln, 
	String em, long pn, long ss) {
		Random r = new Random();
		id = 100000000 + r.nextInt(900000000);
		setUsername(un);
		setPassword(pw);
		setFirstName(fn);
		setLastName(ln);
		setEmail(em);
		setPhoneNumber(pn);
		setSsNumber(ss);
		accountIds = new ArrayList<Integer>();
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
	public ArrayList<Integer> getAccounts() {
		return accountIds;
	}
	public void setAccounts(ArrayList<Integer> accounts) {
		this.accountIds = accounts;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password="
				+ password + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", accounts=" + accountIds + "]";
	}
}
