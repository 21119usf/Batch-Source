package com.revature.bap1;

public class Bank {
	
	private UserManager um;
	private AccountManager am;
	
	private int currentSessionID;
	
	public Bank() {
		um = new UserManager();
		am = new AccountManager();
	}
	
	public void readFiles() {
		um.readFile();
		am.readFile();
	}
	
	public void writeFiles() {
		um.writeFile();
		am.writeFile();
	}
	
	public int instanceOf(User u) {
		if (u instanceof Customer) {
			return 1;
		} else if (u instanceof Employee) {
			return 2;
		} else if (u instanceof Admin) {
			return 3;
		}
		return -1;
	}
	
	public void registerCustomer(String firstName, String lastName, String username, String password) {
		um.registerCustomer(firstName, lastName, username, password);
	}
	
	public int login(String username, String password) {
		User u = um.login(username, password);
		if (u == null) {
			return -1;
		}
		currentSessionID = u.getId();
		return instanceOf(u);		
	}
	
	public void logout() {
		currentSessionID = -1;
	}
	
	public String getUsernameFromSessionID() {
		return um.getUsername(currentSessionID);
	}
}
