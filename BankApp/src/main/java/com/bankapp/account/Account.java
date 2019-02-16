package com.bankapp.account;

import java.util.ArrayList;
import java.util.UUID;

import com.bankapp.person.Customer;

// Account class
public class Account {
	private UUID id;
	private String status;
	private boolean open;
	private double balance;
	private ArrayList<Customer> owners;
	
	// Constructor
	Account() {
		setId(UUID.randomUUID());
		setStatus("Pending");
		setOpen(false);
		setBalance(0.00);
		setOwners(new ArrayList<Customer>());
	}
	
	// Deposit into account
	public void deposit(double d) {
		if (isOpen()) {
			balance += d;
		} else {
			System.out.println("DENIED. Account status: " + status);
		}
	}
	// Withdraw from account
	public void withdraw(double d) {
		if (isOpen()) {
			if (!willOverdraw(d)) {
				balance -= d;
			}
		} else {
			System.out.println("DENIED. Account status: " + status);
		}
	}
	// Transfer funds from this account into another
	public void transfer(Account a, double d) {
		if (isOpen()) {
			if (!willOverdraw(d)) {
				a.deposit(d);
				balance -= d;
			}
		} else {
			System.out.println("DENIED. Account status: " + status);
		}
	}
	// Check for overdraw
	public boolean willOverdraw(double d) {
		if (d > balance) {
			System.out.println("DENIED:  Not enough funds");
			return true;
		}
		return false;
	}
	// Add owner to account
	public void addOwner(Customer c) {
		owners.add(c);
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
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
}
