package com.bankapp.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Random;

import com.bankapp.person.Customer;

// Account class
public class Account implements Serializable {
	private static final long serialVersionUID = 8320272473826438040L;
	private int id;
	private String name;
	private String status;
	private boolean open;
	private double balance;
	private ArrayList<Customer> owners;
	
	// Constructor
	public Account(Customer c) {
		Random rnd = new Random();
		id = 100000 + rnd.nextInt(900000);
		setName("Account " + id);
		setOpen(false);
		setBalance(0.00);
		owners = new ArrayList<Customer>();
		setOwners(c);
	}

	// Round decimals
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();
	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	
	// Deposit into account
	public boolean deposit(double d) {
		if (isOpen() && d > 0.0) {
			balance += round(d, 2);
			return true;
		}
		System.out.println("DENIED");
		return false;
	}
	// Withdraw from account
	public boolean withdraw(double d) {
		if (isOpen() && !willOverdraw(d)) {
			balance -= round(d, 2);
			return true;
		}
		return false;
	}
	// Transfer funds from this account into another
	public boolean transfer(Account b, double d) {
		if (isOpen() && b.isOpen()) {
			if (withdraw(d) && b.deposit(d)) {
				return true;
			}
		}
		return false;
	}
	// Check for overdraw
	public boolean willOverdraw(double d) {
		if (d > balance) {
			System.out.println("DENIED");
			return true;
		}
		return false;
	}
	// Add owner to account
	public void addOwner(Customer c) {
		owners.add(c);
	}
	// Close account
	public void close() {
		setOpen(false);
	}

	// Get/set methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getBalance() {
		return round(balance, 2);
	}
	public void setBalance(double balance) {
		this.balance = round(balance, 2);
	}
	public ArrayList<Customer> getOwners() {
		return owners;
	}
	public void setOwners(Customer c) {
		this.owners.add(c);
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		if (open) {
			this.open = true;
			this.status = "Open";
		} else {
			this.open = false;
			this.status = "Closed";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", status=" + status
				+ ", open=" + open + ", balance=" + balance + ", owners="
				+ owners + "]";
	}
}
