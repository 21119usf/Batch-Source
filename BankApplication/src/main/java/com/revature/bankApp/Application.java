package com.revature.bankApp;

public class Application {
	
	private final User customer;
	private boolean status;
	
	public User getCustomer() {
		return customer;
	}
	
	public Application(User customer) {
		super();
		this.customer = customer;
		this.status = false;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	
}
