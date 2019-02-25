package com.revature.beans;

public class Application {

	private int applicationID;
	private int customerID;
	
	public Application() {
		super();
	}

	public Application(int applicationID, int customerID) {
		super();
		this.applicationID = applicationID;
		this.customerID = customerID;
	}

	public int getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	@Override
	public String toString() {
		return "Application [applicationID=" + applicationID + ", customerID=" + customerID + "]";
	}
}
