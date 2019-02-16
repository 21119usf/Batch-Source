package com.bankapp.account;

import java.util.ArrayList;
import java.util.UUID;

import com.bankapp.person.Customer;

// Account class
public class Account {
	private UUID id;
	private String status;
	private double balance;
	private ArrayList<Customer> owners;
	
	// Constructor
	Account() {
		setId(UUID.randomUUID());
		setStatus("Pending");
		setBalance(0.00);
		setOwners(new ArrayList<Customer>());
	}

	// Get/set methods
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public ArrayList<Customer> getOwners() {
		return owners;
	}
	public void setOwners(ArrayList<Customer> owners) {
		this.owners = owners;
	}
}
