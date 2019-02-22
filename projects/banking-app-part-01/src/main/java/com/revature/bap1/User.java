package com.revature.bap1;

import java.io.Serializable;

public abstract class User implements Serializable {

	private static final long serialVersionUID = -3646506973576726665L;
	
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	public User(String username, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
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

	@Override
	public String toString() {
		return "username = " + username + ", firstName = " + firstName + ", lastName = "
				+ lastName;
	}
}
