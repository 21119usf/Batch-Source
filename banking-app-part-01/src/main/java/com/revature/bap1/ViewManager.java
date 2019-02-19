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
		
		iv.initialMessage();
		
		while (ui.getIntNum() != 3) {
			iv.message();
			if (!ui.isInt() || ui.getIntNum() < 1 || ui.getIntNum() > 3) {
				iv.error();
			} else if (ui.getIntNum() == 1) {
				login();
			} else if (ui.getIntNum() == 2) {
				registerCustomer();
			}
		}
	}
	
	public void login() {
		LoginView lv = new LoginView();
		
		String username;
		String password;
		
		lv.username();
		username = ui.scan();
		lv.password();
		password = ui.scan();
		
		if (bank.login(username, password) == 1) {
			initialCustomer();
		} else if (bank.login(username, password) == 2) {
			
		} else if (bank.login(username, password) == 3) {
			
		}
	}
	
	public void logout() {
		bank.logout();
		initial();
	}
	
	public void registerCustomer() {
		RegisterCustomer rc = new RegisterCustomer();
		
		String firstName;
		String lastName;
		String username;
		String password;
		
		rc.firstName();
		firstName = ui.scan();
		rc.lastName();
		lastName = ui.scan();
		rc.username();
		username = ui.scan();
		rc.password();
		password = ui.scan();
		
		bank.registerCustomer(firstName, lastName, username, password);
	}
	
	public void initialCustomer() {
		CustomerView cv = new CustomerView();
		
		while (ui.getIntNum() != 4) {
			cv.initialView(bank.getUsernameFromSessionID());
			if (!ui.isInt() || ui.getIntNum() < 1 || ui.getIntNum() > 4) {
				cv.error();
			} else if (ui.getIntNum() == 1) {
				
			} else if (ui.getIntNum() == 2) {
				
			} else if (ui.getIntNum() == 3) {
				
			}
		}
		
		logout();
	}
}
