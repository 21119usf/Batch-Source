package com.revature.beans;

public class BankAdmin extends Employee{

	private String username;
	private String password;
	private String name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BankAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BankAdmin(String username, String password, String name) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
	}
}
