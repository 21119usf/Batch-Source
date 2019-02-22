package com.revature.bap1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer extends User implements Serializable {

	private static final long serialVersionUID = -9166840538895516129L;

	public Customer(String username, String password, String firstName, String lastName) {
		super(username, password, firstName, lastName);
	}
}
