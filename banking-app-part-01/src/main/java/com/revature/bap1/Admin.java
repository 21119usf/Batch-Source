package com.revature.bap1;

import java.io.Serializable;

public class Admin extends Employee implements Serializable {
	
	private static final long serialVersionUID = -3945665822999045035L;

	public Admin(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
	}	
}
