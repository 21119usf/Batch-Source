package com.revature.beans;

import java.io.Serializable;

public class User implements Serializable{
	
	/*User is used as a parent class to employee,admin and customer to provide
	 * the ability to only have a single login for all users.
	 * 
	 */
	private static final long serialVersionUID = -5065237759207839046L;
	private String username;
	private String password;
	private String name;
	
	
	
	public User(String name, String username, String password) {
		this.username = username;
		this.password = password;
		this.name = name;
	}
	
	public User() {
		super();
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
