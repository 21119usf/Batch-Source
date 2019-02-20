package com.revature.bankApp;

public class Administrator extends Employee {

	public Administrator(String username, String password) {
		super(username, password);
	}
	
	public void deposit(CustomerFunctions functions, User user, double amount) {
		functions.deposit(user, amount);
	}
	
	public void withdraw(CustomerFunctions functions, User user, double amount) {
		functions.withdraw(user, amount);
	}

}
