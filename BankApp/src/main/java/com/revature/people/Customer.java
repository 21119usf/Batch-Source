package com.revature.people;

public class Customer {
	String customerID;
	String firstName;
	String lastName;
	String userName;
	String password;
	String password2;
	String socialSecurity;
	String Email;
	int accountID;
	
	
	public Customer() {}
	
	public Customer(String customerID, String firstName, String lastName, String userName, String password,
			String password2, String socialSecurity, String email) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.password2 = password2;
		this.socialSecurity = socialSecurity;
		Email = email;
	}


	
	


	public Customer(int accountID) {
		super();
		this.accountID = accountID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getCustomerID() {
		return customerID;
	}


	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}


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


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPassword2() {
		return password2;
	}


	public void setPassword2(String password2) {
		this.password2 = password2;
	}


	public String getSocialSecurity() {
		return socialSecurity;
	}


	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}
	


}
