package com.revature.bankapp;

import java.util.ArrayList;

public class Customer {
	private String username;
	private String password;
	private String name;
	private String last;
	private int id;
	private ArrayList<Account> accounts;
	private ArrayList<Application> applications;
    static int counter = 0;
	
	public Customer(String username, String password, String name, String last) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.last = last;
		accounts = new ArrayList<Account>();
		applications = new ArrayList<Application>();
		this.id = Customer.counter++;
	}
	public Customer(String username, String password, String name, String last, int id) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.last = last;
		accounts = new ArrayList<Account>();
		applications = new ArrayList<Application>();
		this.id = id;
		Customer.counter = id+1;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Account> getAccounts() {
		System.out.println(accounts);
		return accounts;
	}

	public void addAccounts(Account account) {
		accounts.add(account);
	}

	public ArrayList<Application> getApplications() {
		System.out.println(applications);
		return applications;
	}

	public void addApplications(Application application) {
		applications.add(application);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}
	public void apply(Application app) {
		this.addApplications(app);
	}


	@Override
	public String toString() {
		return "Customer [username=" + username + ", password=" + password + ", name=" + name + ", last=" + last
				+ ", id=" + id + ", accounts=" + accounts + ", applications=" + applications + "]";
	}
	
}
