package com.revature.bankapp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.revature.imp.LoadIMP;
import com.revature.imp.ReadIMP;
import com.revature.util.LoggerUtil;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Employee> employees = new ArrayList<Employee>();
	static ArrayList<Customer> customers = new ArrayList<Customer>();
	static ArrayList<Admin> admins = new ArrayList<Admin>();
	static ArrayList<Account> accounts = new ArrayList<Account>();
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Banking App");
		Menu menu = new Menu();
		menu.LoadFromDB();
		menu.MainMenu();
	}
	void MainMenu() {
		//System.out.println(customers);
		//System.out.println(employees);
		//System.out.println(admins);
		//System.out.println(accounts);
		String userName,passWord;
		System.out.println("Menu Options: (Enter Number)");
		System.out.println("1: Register");
		System.out.println("2: Customer Login");
		System.out.println("3: Employee Login");
		System.out.println("4: Admin Login");
		System.out.println("0: to end program");
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
			case 1:
				String name,last;
				System.out.println("Registering");
				System.out.println("Enter Username");
				userName = sc.nextLine();
				System.out.println("Enter Password");
				passWord = sc.nextLine();
				System.out.println("Enter Name");
				name = sc.nextLine();
				System.out.println("Enter Last Name");
				last = sc.nextLine();
				Customer customer = new Customer(userName, passWord, name, last);
				customers.add(customer);
				LoggerUtil.LOGGER.info("Customer " + name + " " + last + " registered");
				CustomerMenu(customer);
				break;
			case 2:
				System.out.println("Customer Login");
				System.out.println("Enter Username");
				userName = sc.nextLine();
				System.out.println("Enter Password");
				passWord = sc.nextLine();
				//Check Login
				for (int i=0; i<customers.size();i++) {
					if(userName.equals(customers.get(i).getUsername()) && passWord.equals(customers.get(i).getPassword())) {
						LoggerUtil.LOGGER.info("Customer " + userName + " logged in");
						CustomerMenu(customers.get(i));
						break;
					}	
				}
				System.out.println("Incorrect Username or password");
				MainMenu();
				break;
			case 3:
				System.out.println("Employee Login");
				System.out.println("Enter Username");
				userName = sc.nextLine();
				System.out.println("Enter Password");
				passWord = sc.nextLine();
				//Check Login
				for (int i=0; i<employees.size();i++) {
					if(userName.equals(employees.get(i).getUsername()) && passWord.equals(employees.get(i).getPassword())) {
						LoggerUtil.LOGGER.info("Employee " + userName + " logged in");
						EmployeeMenu(employees.get(i));
						break;
					}
				}
				System.out.println("Incorrect Username or password");
				MainMenu();
				break;
			case 4:
				System.out.println("Admin Login");
				System.out.println("Enter Username");
				userName = sc.nextLine();
				System.out.println("Enter Password");
				passWord = sc.nextLine();
				//Check Login
				for (int i=0; i<admins.size();i++) {
					if(userName.equals(admins.get(i).getUsername()) && passWord.equals(admins.get(i).getPassword())) {
						LoggerUtil.LOGGER.info("Admin " + userName + " logged in");
						AdminMenu();
						break;
					}
				}
				System.out.println("Incorrect Username or password");
				MainMenu();
				break;
			case 0: 
				LoadToDB();
				System.out.println("Loaded to Database exiting program");
				System.exit(0);
				break;
		}
	}
	void CustomerMenu(Customer c) {
		System.out.println("Menu Options: (Enter Number)");
		System.out.println("1: Apply for account");
		System.out.println("2: Check Applications");
		System.out.println("3: Manage Accounts");
		System.out.println("0: Logout");
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
			case 1:
				System.out.println("Joint Account? yes/no");
				String joint = sc.nextLine();
				if (joint.equals("yes")){
					System.out.println("Enter joint customer Id: ");
					int jAcc = Integer.parseInt(sc.nextLine());
					for(int i = 0; i < customers.size(); i++) {
						if(customers.get(i).getId() == jAcc) {
							Account newAcc = new Account();
							c.addAccounts(newAcc);
							customers.get(i).addAccounts(newAcc);
							System.out.println("Applied for an account");
							LoggerUtil.LOGGER.info("Customer: " + c.getUsername()+ " applied for account with: "+ customers.get(i).getUsername());
							CustomerMenu(c);
							break;
						}
					}
					System.out.println("Account : "+ jAcc +" Not found");
					CustomerMenu(c);
					break;
				}
				else {
					Account newAcc = new Account();
					c.addAccounts(newAcc);
						//c.addAccounts(newAcc);
					accounts.add(newAcc);
					System.out.println("Applied for an account");
					LoggerUtil.LOGGER.info("Customer: " + c.getUsername()+ " applied for an account");
					CustomerMenu(c);
					break;
				}
			case 2:
				c.getApps();
				CustomerMenu(c);
				break;
			case 3:
				System.out.println(c.getAccounts());
				System.out.println("Enter account Id to manage: ");
				int cusChoice = Integer.parseInt(sc.nextLine());
				for (int i = 0; i<c.getAccounts().size(); i++) {
					if (c.getAccounts().get(i).getId() == cusChoice && c.getAccounts().get(i).getActive() ==true ) {
						AccountChoice(c.getAccounts().get(i));
						break;
					}
					System.out.println("Account Id not found or not Activated");
				}
				CustomerMenu(c);
				break;
			case 0: 
				MainMenu();
				break;
		}
	}
	void EmployeeMenu(Employee e) {
		System.out.println("Menu Options: (Enter Number)");
		System.out.println("1: View Account Info");
		System.out.println("2: View Personal Info");
		System.out.println("0: Logout");
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
			case 1:
				System.out.println(accounts);
				EmployeeMenu(e);
				//e.viewAccounts();
				break;
			case 2:
				System.out.println(customers);
				EmployeeMenu(e);
				//e.viewPersonal();
				break;
			case 0: 
				MainMenu();
				break;
		}
	}
	void AdminMenu() {
		System.out.println("Menu Options: (Enter Number)");
		System.out.println("1: Manage Applications");
		System.out.println("2: Manage Accounts");
		System.out.println("3: Cancel Accounts");
		System.out.println("0: Logout");
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
			case 1:
				System.out.println(accounts);
				System.out.println("Enter Account Id to accept/deny");
				int appId = Integer.parseInt(sc.nextLine());
				for (int i = 0;i<accounts.size(); i++) {
					if(accounts.get(i).getId() == appId && accounts.get(i).getActive() == false) {
						//Account acc = accounts.get(i);
						System.out.println("Type accept to accept / deny to deny");
						String accMan = sc.nextLine();
						if (accMan.equals("accept")) {
							for (int j = 0; j<customers.size(); j++) {
								for(int k = 0; k<customers.get(j).getAccounts().size(); k++) {
									if(customers.get(j).getAccounts().get(k).equals(accounts.get(i))) {
										customers.get(j).getAccounts().get(k).Activate();
										LoggerUtil.LOGGER.info("Account: "+ appId + " Activated");									
										}
								}
							}
							accounts.get(i).Activate();
							AdminMenu();
						}if (accMan.equals("deny")) {
							for (int j = 0; j<customers.size(); j++) {
								for(int k = 0; k<customers.get(j).getAccounts().size(); k++) {
									if(customers.get(j).getAccounts().get(k).equals(accounts.get(i))) {
										customers.get(j).removeAccount(accounts.get(i));
										LoggerUtil.LOGGER.info("Account: "+ appId + " Activated");									
										
									}
								}
							}
							accounts.remove(i);
							AdminMenu();
							break;
						}
					}
				}
				break;
			case 2:
				System.out.println(accounts);
				System.out.println("Enter Account Id to manage: ");
				int accId = Integer.parseInt(sc.nextLine());
				for (int i = 0; i< accounts.size(); i++) {
					if(accounts.get(i).getId() == accId) {
						AccountChoice(accounts.get(i));
						break;
					}
				}
				break;
			case 3:
				System.out.println(accounts);
				System.out.println("Enter Account Id to cancel");
				int delId = Integer.parseInt(sc.nextLine());
				for (int i = 0; i<accounts.size(); i++) {
					if (accounts.get(i).getId() == delId) {
						for (int j = 0; j < customers.size(); j++) {
							for (int k = 0; k< customers.get(j).getAccounts().size(); k++) {
								if (customers.get(j).getAccounts().get(k).equals(accounts.get(i))) {
									customers.get(j).removeAccount(accounts.get(i));
								}
							}
						}
						accounts.remove(i);
						AdminMenu();
						break;
					}
				}
				AdminMenu();
				break;
			case 0: 
				MainMenu();
				break;
		}
	}
	void AccountChoice(Account a) {
		//System.out.println(a);
		System.out.println("Account Options: (Enter Number)");
		System.out.println("1: Deposit to account");
		System.out.println("2: Withdraw from Account");
		System.out.println("3: Transfer from Accounts");
		System.out.println("0: Logout");
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
			case 1:
				System.out.println("Enter Ammount to deposit: ");
				double deposit = Double.parseDouble(sc.nextLine());
				for (int i = 0; i < accounts.size(); i++) {
					if(accounts.get(i).equals(a)) {
						accounts.get(i).deposit(deposit);
						AccountChoice(a);
						break;
					}
				}
				break;
			case 2:
				System.out.println("Enter Ammount to withdraw: ");
				double withdraw = Double.parseDouble(sc.nextLine());
				for (int i = 0; i < accounts.size(); i++) {
					if(accounts.get(i).equals(a)) {
						accounts.get(i).withdraw(withdraw);
						AccountChoice(a);
						break;
					}
				}
				//a.manageAccounts();
				break;
			case 3:
				System.out.println("Enter Account number to deposit to");
				int accNum = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < accounts.size(); i++) {
					if(accounts.get(i).getId() == accNum) {
						System.out.println("Enter Ammount to deposit: ");
						double depositz = Double.parseDouble(sc.nextLine());
						a.transfer(depositz, accounts.get(i));
						AccountChoice(a);
						//AdminMenu();
						break;
					}
				}
				System.out.println("Account number: " + accNum + " not found");
				AccountChoice(a);
				break;
			case 0: 
				MainMenu();
				break;
		}
	}
	void LoadFromDB() {
		System.out.println("Loading values from database");
		LoggerUtil.LOGGER.info("Loading values from database");
		ReadIMP ri = new ReadIMP();
		try {
			customers = ri.getCustomerList();
			employees = ri.getEmployeeList();
			accounts = ri.getAccountList();
			admins = ri.getAdminList();
			ri.getAccountHolders(customers, accounts);
			LoggerUtil.LOGGER.info("Succesully loaded from database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	void LoadToDB() {
		LoadIMP li = new LoadIMP();
		try {
			LoggerUtil.LOGGER.info("Commiting changes to database");
			li.clearTables();
			for(int i = 0; i<accounts.size(); i++) {
				li.createAccount(accounts.get(i));
			}
			for(int i = 0; i<customers.size(); i++) {
				li.createCustomer(customers.get(i));
				li.createAccountHolders(customers.get(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
