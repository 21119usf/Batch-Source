package com.revature.project0.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7845424472086182268L;

	private String username;
	
	private String password;
	
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
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
}
