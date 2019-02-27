package banking;

import java.io.Serializable;

public class Account implements Serializable {
	
	// Fields
	private static final long serialVersionUID = 262112665433916580L;
	private Integer ID;
	private double balance;
	private String customers;
	
	// Getters, and setters
	public Integer getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getCustomers() {
		return customers;
	}
	public void setCustomers(String customers) {
		this.customers = customers;
	}

	// Account Methods: Constructor, Withdraw, Deposit, Transfer, Close
	// Line format: ID:balance:active:customers
	public Account(int ID, double balance, String users) {
		this.ID = ID;
		this.balance = balance;
		this.customers = users;
		}
	
	public void display() {
		System.out.println("Account ID: " + this.getID().toString());
		System.out.println(String.format("Account Balance: %.2f", this.getBalance()));
		String customLine ="Customers: ";
		for(String name: this.getCustomers().split(";")) {
			customLine = customLine + name + "\n";
		}
		System.out.println(customLine);
	}
}
