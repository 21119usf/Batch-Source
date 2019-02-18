package com.revature.bap1;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
	
	private List<Account> accountList;
	
	public Customer() {
		accountList = new ArrayList<Account>();
	}
	
}
