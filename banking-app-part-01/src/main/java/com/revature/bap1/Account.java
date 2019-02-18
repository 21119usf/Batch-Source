package com.revature.bap1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Account implements Serializable {
	
	private static final long serialVersionUID = -8449950767722490575L;
	
	private List<Customer> accountList;
	
	public Account() {
		accountList = new ArrayList<Customer>();
	}
}
