package com.revature.bap1;

public class Bank {
	
	private UserManager um;
	private AccountManager am;
	
	private User currentUser;
	
	public Bank() {
		um = new UserManager();
		am = new AccountManager();
	}
	
	public void readFiles() {
		um.readFile();
		am.readFile();
		
//		um.createAdmin("admin", "password", "Master", "Admin");
//		um.createEmployee("employee", "password", "Master", "Employee");
		
//		um.displayUserList();
	}
	
	public void writeFiles() {
		um.writeFile();
		am.writeFile();
	}
	
	public int instanceOf(User u) {
		if (u instanceof Customer) {
			return 1;
		} else if (u instanceof Admin) {
			return 3;
		} else if (u instanceof Employee) {
			return 2;
		}
		return -1;
	}
	
	public void registerCustomer(String firstName, String lastName, String username, String password) {
		um.registerCustomer(firstName, lastName, username, password);
	}
	
	public void createAdmin(String firstName, String lastName, String username, String password) {
		um.createAdmin(firstName, lastName, username, password);
	}
	
	public int login(String username, String password) {
		currentUser = um.login(username, password);
		if (currentUser == null) {
			return -1;
		}
		return instanceOf(currentUser);		
	}
	
	public void logout() {
		currentUser = null;
	}
	
	public String getUsernameFromCurrentUser() {
		return currentUser.getUsername();
	}
	
	public String getFirstNameFromCurrentUser() {
		return currentUser.getFirstName();
	}
	
	public String getLastNameFromCurrentUser() {
		return currentUser.getLastName();
	}
}
