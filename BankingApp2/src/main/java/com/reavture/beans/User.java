package com.reavture.beans;

public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String SSN;
	private String email;
	private String username;
	private String hash;
	private UserRole role;
	
	
	public User() {}
	public User(String firstName, String lastName, String sSN, String email,
			String username, String hash, UserRole role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		SSN = sSN;
		this.email = email;
		this.username = username;
		this.hash = hash;
		this.role = role;
	}
	public User(int id, String firstName, String lastName, String sSN, String email,
			String username, String hash, UserRole role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		SSN = sSN;
		this.email = email;
		this.username = username;
		this.hash = hash;
		this.role = role;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public String getSSN() {
		return SSN;
	}



	public void setSSN(String sSN) {
		SSN = sSN;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getHash() {
		return hash;
	}



	public void setHash(String hash) {
		this.hash = hash;
	}

	

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", SSN=" + SSN + ", email="
				+ email + ", username=" + username + ", hash=" + hash + "]";
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}

}
