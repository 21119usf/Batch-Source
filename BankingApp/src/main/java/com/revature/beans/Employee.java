package com.revature.beans;

import java.util.ArrayList;

public class Employee extends User {

	private static final long serialVersionUID = 9025417559997170291L;
	
	private ArrayList<Integer> clients;

	public Employee(String firstName, String lastName, String sSN, String email, String address, String username,
			String hash, int userId) {
		super(firstName, lastName, sSN, email, address, username, hash, userId);
		setClients(new ArrayList<Integer>());
	}

	public ArrayList<Integer> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Integer> clients) {
		this.clients = clients;
	}

}
