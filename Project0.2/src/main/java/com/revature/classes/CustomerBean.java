package com.revature.classes;

public class CustomerBean {
	private int customer_ID;
	private String customerUsername;
	private String customerPassword;
	private String customerFirstName;
	private String customerLastName;
	 int customerPermissions = 0;
		
	public CustomerBean(int customer_ID, String customerUsername, String customerPassword, String customerFirstName,
			String customerLastName, int customerPermissions) {
		super();
		this.customer_ID = customer_ID;
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
		this.customerFirstName = customerFirstName;
		this.customerLastName = customerLastName;
		this.customerPermissions = customerPermissions;
	}
	public int getCustomer_ID() {
		return customer_ID;
	}
	public void setCustomer_ID(int customer_ID) {
		this.customer_ID = customer_ID;
	}
	public String getCustomerUsername() {
		return customerUsername;
	}
	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public int getCustomerPermissions() {
		return customerPermissions;
	}
	public void setCustomerPermissions(int customerPermissions) {
		this.customerPermissions = customerPermissions;
	}
	
	@Override
	public String toString() {
		return "CustomerBean [customer_ID=" + customer_ID + ", customerUsername=" + customerUsername
				+ ", customerPassword=" + customerPassword + ", customerFirstName=" + customerFirstName
				+ ", customerLastName=" + customerLastName + ", customerPermissions=" + customerPermissions + "]";
	}
		
	
}
