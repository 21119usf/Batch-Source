package com.revature.bankapp;

public class Employee {
	private String username, password;
	
	public Employee(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	void viewAccounts() {
		
	}
	void viewPersonal() {
		
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Employee [username=" + username + ", password=" + password + "]";
	}
	
}
