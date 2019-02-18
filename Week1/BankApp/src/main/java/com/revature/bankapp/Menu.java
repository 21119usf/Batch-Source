package com.revature.bankapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Employee> employees = new ArrayList<Employee>();
	static ArrayList<Customer> customers = new ArrayList<Customer>();
	static ArrayList<Admin> admins = new ArrayList<Admin>();
	static ArrayList<Application> applications = new ArrayList<Application>();
	static ArrayList<Account> accounts = new ArrayList<Account>();

	public static void main(String[] args) {
		System.out.println("Welcome to the Banking App");
		Menu menu = new Menu();
		menu.MainMenu();
	}
	void MainMenu() {
		LoadFromFile();
		//System.out.println(employees);
		//System.out.println(applications);
		//System.out.println(accounts);
		//System.out.println(admins);
		//System.out.println(customers);
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
						AdminMenu(admins.get(i));
						break;
					}
				}
				System.out.println("Incorrect Username or password");
				MainMenu();
				break;
			case 0: 
				break;
		}
	}
	void CustomerMenu(Customer c) {
		System.out.println("Menu Options: (Enter Number)");
		System.out.println("1: Apply for account");
		System.out.println("2: Check Applicaions");
		System.out.println("3: Check Accounts");
		System.out.println("0: Logout");
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
			case 1:
				Application app = new Application();
				c.apply(app);
				CustomerMenu(c);
				break;
			case 2:
				CustomerMenu(c);
				break;
			case 3:
				break;
			case 0: 
				MainMenu();
				break;
		}
	}
	void AccountMenu(Account a) {
		System.out.println("Menu Options: (Enter Number)");
		System.out.println("1: Withdraw");
		System.out.println("2: Deposit");
		System.out.println("3: Transfer");
		System.out.println("0: Logout");
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
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
	void AdminMenu(Admin a) {
		System.out.println("Menu Options: (Enter Number)");
		System.out.println("1: Manage Applications");
		System.out.println("2: Manage Accounts");
		System.out.println("3: Cancel Accounts");
		System.out.println("0: Logout");
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
			case 1:
				break;
			case 2:
				AccountChoice(a);
				break;
			case 3:
				a.cancelAccount();
				break;
			case 0: 
				MainMenu();
				break;
		}
	}
	void AccountChoice(Admin a) {
		System.out.println(accounts);
		System.out.println("Account Options: (Enter Number)");
		System.out.println("1: Deposit to account");
		System.out.println("2: Withdraw from Account");
		System.out.println("3: Transfer from Accounts");
		System.out.println("4: Cancel Account");
		System.out.println("0: Logout");
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
			case 1:
				System.out.println("Enter Account number to deposit to");
				int accNum = Integer.parseInt(sc.nextLine());
				for (int i = 0; i < accounts.size(); i++) {
					if(accounts.get(i).getId() == accNum) {
						double deposit = Double.parseDouble(sc.nextLine());
						accounts.get(i).deposit(deposit);
						AdminMenu(a);
						break;
					}
				}
				System.out.println("Account number: " + accNum + " not found");
				break;
			case 2:
				a.manageAccounts();
				break;
			case 3:
				a.cancelAccount();
				break;
			case 4:
				break;
			case 0: 
				MainMenu();
				break;
		}
	}
	void LoadFromFile() {
		try {
			BufferedReader eb = new BufferedReader(new FileReader("Employee.txt"));
			String es = "";
				while((es=eb.readLine())!=null) {
					String lines[] = new String[2];
					lines = es.split(" ");
					Employee emp = new Employee(lines[0],lines[1]);
					employees.add(emp);
				}
			BufferedReader ab = new BufferedReader(new FileReader("Admin.txt"));
			String as = "";
				while((as=ab.readLine())!=null) {
					String lines[] = new String[2];
					lines = as.split(" ");
					Admin adm = new Admin(lines[0],lines[1]);
					admins.add(adm);
				}
			BufferedReader accb = new BufferedReader(new FileReader("Account.txt"));
			String accs = "";
				while((accs=accb.readLine())!=null) {
					String lines[] = new String[2];
					lines = accs.split(" ");
					Account acc = new Account(Integer.parseInt(lines[0]),Double.parseDouble(lines[1]));
					accounts.add(acc);
				}
			BufferedReader appb = new BufferedReader(new FileReader("Application.txt"));
			String apps = "";
				while((apps=appb.readLine())!=null) {
					String lines[] = new String[1];
					lines = apps.split(" ");
					Application app = new Application(Integer.parseInt(lines[0]));
					applications.add(app);
				}
			
			BufferedReader cb = new BufferedReader(new FileReader("Customer.txt"));
				String cs = "";
					while((cs=cb.readLine())!=null) {
						ArrayList<String> lines = new ArrayList<String>(Arrays.asList(cs.split(" ")));
						Customer cus = new Customer(lines.get(0),lines.get(1), lines.get(2), lines.get(3), Integer.parseInt(lines.get(4)));
						int appNum = Integer.parseInt(lines.get(5));
						for (int i = 0; i< appNum;i++) {
							for (int j = 0; j<applications.size(); j++) {
								if(applications.get(j).getAppId() == Integer.parseInt(lines.get(6+i)))
									cus.addApplications(applications.get(j));
							}
						}
						int accNum = Integer.parseInt(lines.get(6+appNum));
						for (int i = 0; i< accNum;i++) {
							for (int j = 0; j<accounts.size(); j++) {
								if(accounts.get(j).getId() == Integer.parseInt(lines.get(7+appNum+i)))
									cus.addAccounts(accounts.get(j));
							}
						}
						customers.add(cus);
					}
		} 
		catch (Exception e) {}
	}
}
