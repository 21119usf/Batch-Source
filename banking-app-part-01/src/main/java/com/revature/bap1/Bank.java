package com.revature.bap1;

public class Bank {
	
	private UserManager um;
	private AccountManager am;
	private ApplicationManager appMan;
	private CounterManager cm;
	
	private User currentUser;
	
	public Bank() {
		um = new UserManager();
		am = new AccountManager();
		appMan = new ApplicationManager();
		cm = new CounterManager();
	}
	
	public void readFiles() {
		um.readFile();
		am.readFile();
		appMan.readFile();
		cm.readFile();
		
//		comment out the lines below
		
//		um.createAdmin(cm.getNewUserCount(), "admin", "password", "Master", "Admin");
//		um.createEmployee(cm.getNewUserCount(), "employee", "password", "Master", "Employee");
		
//		um.displayUserList();
		appMan.printAppList();
	}
	
	public void writeFiles() {
		um.writeFile();
		am.writeFile();
		appMan.writeFile();
		cm.writeFile();
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
	
	public void registerCustomer(String username, String password, String firstName, String lastName) {
		um.registerCustomer(cm.getNewUserCount(), username, password, firstName, lastName);
	}
	
	public void create(String username, String password, String firstName, String lastName) {
		um.createEmployee(cm.getNewUserCount(), username, password, firstName, lastName);
	}
	
	public void createAdmin(String username, String password, String firstName, String lastName) {
		um.createAdmin(cm.getNewUserCount(), username, password, firstName, lastName);
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
	
	public void applySingleAccount() {
		appMan.applySingleAccount(cm.getNewAccountCount(), currentUser.getId(), cm.getNewAppCount());
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
