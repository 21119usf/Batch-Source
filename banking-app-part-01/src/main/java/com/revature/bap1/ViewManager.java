package com.revature.bap1;

public class ViewManager {
	
	private Bank bank;
	private UserInput ui;
	
	public ViewManager() {
		bank = new Bank();
		ui = new UserInput();
	}
	
	public void run() {
		bank.readFile();	
		ui.openScanner();
		
		frontPageView();		
		
		ui.closeScanner();
		bank.writeFile();
	}
	
	public void frontPageView() {
		do {
			System.out.println("Bank app");
			System.out.println("--------");
			System.out.println("1. Log in");
			System.out.println("2. Register an account");
			System.out.println("3. Exit program");
			selectMessage(1, 3);
			if (!ui.isInt() || ui.getIntNum() < 1 || ui.getIntNum() > 3) {
				errorMessage(1, 3);
			} else if (ui.getIntNum() == 1) {
				loginView();
			} else if (ui.getIntNum() == 2) {
				registerAccountView();
			}
		} while (ui.getIntNum() != 3);
	}
	
	public void loginView() {
		String username;
		String password;
		
		System.out.print("Enter username: ");
		username = ui.scan();
		System.out.print("Enter password: ");
		password = ui.scan();
		
		int loginFlag = bank.login(username, password);
		
		if (loginFlag == 1) {
			customerView();
		} else if (loginFlag == 2) {
			employeeView();
		} else if (loginFlag == 3) {
			adminView();
		}
	}
	
	public void logout() {
		bank.logout();
		frontPageView();
	}
	
	public void customerView() {
		do {
			displayHeader();
			System.out.println("1. Apply to open a new account");
			System.out.println("2. Apply to join an existing account");
			System.out.println("3. Look at accounts");
			System.out.println("4. Log out");
			selectMessage(1, 4);
			if (!ui.isInt() || ui.getIntNum() < 1 || ui.getIntNum() > 4) {
				errorMessage(1, 4);
			} else if (ui.getIntNum() == 1) {
				bank.applyForAccount();
				System.out.println("Your application has been sent!");
			} else if (ui.getIntNum() == 2) {
				
			} else if (ui.getIntNum() == 3) {
				accountView();
			}
		} while (ui.getIntNum() != 4);
		
		logout();
	}
	
	public void registerAccountView() {
		String username;
		String password;
		String firstName;
		String lastName;
		
		System.out.print("Enter first name: ");
		username = ui.scan();
		System.out.print("Enter last name: ");
		password = ui.scan();
		System.out.print("Enter username: ");
		firstName = ui.scan();
		System.out.print("Enter password: ");
		lastName = ui.scan();
		
		bank.registerCustomer(username, password, firstName, lastName);
	}
	
	public void employeeView() {
		do {
			header();
			System.out.println("1. Approve/Deny open applications");
			System.out.println("2. View customers information");
			System.out.println("3. Log out");
			selectMessage(1, 3);
			if (!ui.isInt() || ui.getIntNum() < 1 || ui.getIntNum() > 3) {
				errorMessage(1, 3);
			} else if (ui.getIntNum() == 1) {
				employeeApplicationsView();
			} else if (ui.getIntNum() == 2) {
				bank.displayAccount();
			}
		} while (ui.getIntNum() != 3);
		
		logout();
	}
	
	public void accountView() {
		do {
			header();
			System.out.println("Balance is " + bank.getBalance());
			System.out.println("1. Withdraw");
			System.out.println("2. Deposit");
			System.out.println("3. Exit");
			selectMessage(1, 3);
			if (!ui.isInt() || ui.getIntNum() < 1 || ui.getIntNum() > 3) {
				errorMessage(1, 3);
			} else if (ui.getIntNum() == 1) {
				System.out.print("Enter how much you want to withdraw: ");
				if (!ui.isDouble() || ui.getDoubleNum() < 0) {
					System.out.println("Please enter a positive number");
				} else {
					if (bank.withdraw(ui.getDoubleNum())) {
						System.out.println("You withdrawed" + ui.getDoubleNum());
					}
					System.out.println("You can't withdraw more than you have on your balance");
				}
			} else if (ui.getIntNum() == 2) {
				System.out.print("Enter how much you want to deposit: ");
				if (!ui.isDouble() || ui.getDoubleNum() < 0) {
					System.out.println("Please enter a positive number");
				} else {
					bank.deposit(ui.getDoubleNum());
				}
			}
		} while (ui.getIntNum() != 3);
		
		customerView();
	}
	
	public void adminView() {		
		do {
			header();
			System.out.println("1. Approve/Deny open applications");
			System.out.println("2. Withdraw, deposit, or transfer from account to account");
			System.out.println("3. Cancel accounts");
			System.out.println("4. View Customers");
			System.out.println("5. Add Admin");
			System.out.println("6. Log off");
			selectMessage(1, 6);
			if (!ui.isInt() || ui.getIntNum() < 1 || ui.getIntNum() > 6) {
				errorMessage(1, 6);
			} else if (ui.getIntNum() == 1) {
				employeeApplicationsView();
			} else if (ui.getIntNum() == 2) {
				
			} else if (ui.getIntNum() == 3) {
				
			} else if (ui.getIntNum() == 4) {
				bank.displayCustomerInfo();
			} else if (ui.getIntNum() == 5) {
				
			}
		} while (ui.getIntNum() != 6);
		
		logout();
	}
	
	public void employeeApplicationsView() {
		String scan;
		do {
			bank.displayApplication();
			System.out.print("Enter the application name you wish the accept/deny or enter -1 to exit: ");
			scan = ui.scan();
			if (!bank.isApplication(scan) && !scan.equals("-1")) {
				System.out.println("Please enter a valid application name.");
			} else if (!scan.equals("-1")) {
				acceptOrDeny(scan);
			}
		} while (!scan.equals("-1"));
		
		if (bank.getUserRigts() == 2) {
			employeeView();
		} else if (bank.getUserRigts() == 3) {
			adminView();
		}
	}
	
	public void acceptOrDeny(String username) {
		do {
			System.out.println("Approve or Deny application " + username);
			System.out.println("1. Approve");
			System.out.println("2. Deny");
			System.out.println("3. Back");
			selectMessage(1, 3);
			if (!ui.isInt() || ui.getIntNum() < 1 || ui.getIntNum() > 3) {
				errorMessage(1, 3);
			} else if (ui.getIntNum() == 1) {
				bank.accept(username);
				bank.deny(username);
				System.out.println("Application has been accepted");
			} else if (ui.getIntNum() == 2) {
				bank.deny(username);
				System.out.println("Application has been denied");
			}
		} while (ui.getIntNum() < 1 || ui.getIntNum() > 3);
	}
	
	public void displayHeader() {
		System.out.println(header());
		System.out.println(dashes(header()));
	}
	
	public String header() {
		String str = "";
		
		if (bank.getUserRigts() == 1) {
			str += "Customer: " + bank.getCurrentFirstNameAndLastName();
		} else if (bank.getUserRigts() == 2) {
			str += "Employee: " + bank.getCurrentFirstNameAndLastName();
		} else if (bank.getUserRigts() == 3) {
			str += "Admin: " + bank.getCurrentFirstNameAndLastName();
		}
		return str;
	}
	
	public String dashes(String str) {
		String dashes = "";
		for (int i = 0; i < str.length(); i++) {
			dashes += "-";
		}
		return dashes;
	}
	
	public void errorMessage(int num1, int num2) {
		System.out.println("***Enter a number between " + num1 + " and " + num2 + "***");
	}
	
	public void selectMessage(int num1, int num2) {
		System.out.print("Select from one of the following options (" + num1 + " - " + num2 + "): ");
	}
}
