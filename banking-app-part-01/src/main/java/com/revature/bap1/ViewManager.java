package com.revature.bap1;

public class ViewManager {
	
	private Bank bank;
	private UserInput ui;
	
	public ViewManager() {
		bank = new Bank();
		ui = new UserInput();
	}
	
	public void run() {
		bank.readFiles();	
		ui.openScanner();
		
		initial();		
		
		ui.closeScanner();
		bank.writeFiles();
	}
	
	public void initial() {
		InitialView iv = new InitialView();
		
		do {
			iv.message();
			if (!ui.isInt() || ui.getIntNum() < 1 || ui.getIntNum() > 3) {
				iv.error();
			} else if (ui.getIntNum() == 1) {
				login();
			} else if (ui.getIntNum() == 2) {
				registerAccount();
			}
		} while (ui.getIntNum() != 3);
	}
	
	public void login() {
		LoginView lv = new LoginView();
		
		String username;
		String password;
		
		lv.username();
		username = ui.scan();
		lv.password();
		password = ui.scan();
		
		int loginFlag = bank.login(username, password);
		
		if (loginFlag == 1) {
			initialCustomer();
		} else if (loginFlag == 2) {
			initialEmployee();
		} else if (loginFlag == 3) {
			initialAdmin();
		}
	}
	
	public void logout() {
		bank.logout();
		initial();
	}
	
	public void registerAccount() {
		RegisterCustomer rc = new RegisterCustomer();
		
		String firstName;
		String lastName;
		String username;
		String password;
		
		rc.username();
		username = ui.scan();
		rc.password();
		password = ui.scan();
		rc.firstName();
		firstName = ui.scan();
		rc.lastName();
		lastName = ui.scan();
		
		bank.registerCustomer(username, password, firstName, lastName);
	}
	
	public void initialCustomer() {
		CustomerView cv = new CustomerView();
		
		do {
			cv.initialView(bank.getFirstNameFromCurrentUser(), bank.getLastNameFromCurrentUser());
			if (!ui.isInt() || ui.getIntNum() < 1 || ui.getIntNum() > 4) {
				cv.error();
			} else if (ui.getIntNum() == 1) {
				
			} else if (ui.getIntNum() == 2) {
				
			} else if (ui.getIntNum() == 3) {
				
			}
		} while (ui.getIntNum() != 4);
		
		logout();
	}
	
	public void initialEmployee() {
		EmployeeView ev = new EmployeeView();
		
		do {
			ev.initialView(bank.getFirstNameFromCurrentUser(), bank.getLastNameFromCurrentUser());
			if (!ui.isInt() || ui.getIntNum() < 1 || ui.getIntNum() > 3) {
				ev.error();
			} else if (ui.getIntNum() == 1) {
				
			} else if (ui.getIntNum() == 2) {
				
			}
		} while (ui.getIntNum() != 3);
		
		logout();
	}
	
	public void initialAdmin() {
		AdminView av = new AdminView();
		
		do {
			av.initialView(bank.getFirstNameFromCurrentUser(), bank.getLastNameFromCurrentUser());
			if (!ui.isInt() || ui.getIntNum() < 1 || ui.getIntNum() > 6) {
				av.error();
			} else if (ui.getIntNum() == 1) {
				
			} else if (ui.getIntNum() == 2) {
				
			} else if (ui.getIntNum() == 3) {
				
			} else if (ui.getIntNum() == 4) {
				
			} else if (ui.getIntNum() == 5) {
				
			}
		} while (ui.getIntNum() != 6);
		
		logout();
	}
}
