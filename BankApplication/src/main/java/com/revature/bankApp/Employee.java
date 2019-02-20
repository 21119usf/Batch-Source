package com.revature.bankApp;

public class Employee extends User {

	public Employee(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
	
	public void approveApplication(Application application) {
		
	}
	
	//display Account and display Balance Username
	
	public void displayAccountNumber(CustomerFunctions functions, User user) {
		functions.getFullMap().get(user).getAccountNumber();
	}
	
	public void displayAccountBalance(CustomerFunctions functions, User user) {
		functions.getFullMap().get(user).getBalance();
	}
	
	public void displayUsername(User user) {
		System.out.println(user.getUsername());
	}
	

}
