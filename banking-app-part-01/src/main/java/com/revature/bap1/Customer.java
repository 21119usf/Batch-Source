package com.revature.bap1;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
	
	private List<Account> accountList;

	public Customer(int id, String username, String password, String firstName, String lastName) {
		super(id, username, password, firstName, lastName);
		accountList = new ArrayList<Account>();
	}
	
	
	
}
