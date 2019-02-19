package com.revature.bap1;

import java.io.Serializable;

public class Application implements Serializable {

	private static final long serialVersionUID = -4175868525454553227L;
	
	private int accountID;
	private int customerID;
	private int applicationID;
	
	public Application(int accountID, int customerID, int applicationID) {
		super();
		this.accountID = accountID;
		this.customerID = customerID;
		this.applicationID = applicationID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}
}
