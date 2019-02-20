package com.revature.bap1;

import java.io.Serializable;

public class Employee extends User implements Serializable {
	
	private static final long serialVersionUID = 5133159266614430771L;

	public Employee(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
	}	
}
