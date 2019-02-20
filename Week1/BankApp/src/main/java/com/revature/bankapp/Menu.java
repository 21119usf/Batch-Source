package com.revature.bankapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Employee> employees = new ArrayList<Employee>();
	static ArrayList<Customer> customers = new ArrayList<Customer>();
	static ArrayList<Admin> admins = new ArrayList<Admin>();
	//static ArrayList<Application> applications = new ArrayList<Application>();
	static ArrayList<Account> accounts = new ArrayList<Account>();

	public static void main(String[] args) {
		System.out.println("Welcome to the Banking App");
		Menu menu = new Menu();
		menu.LoadFromFile();
		menu.MainMenu();
	}
	void MainMenu() {
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
						AdminMenu();
						break;
					}
				}
				System.out.println("Incorrect Username or password");
				MainMenu();
				break;
			case 0: 
				LoadToFile();
				System.out.println("Loaded to text files exiting program");
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
				Account newAcc = new Account();
				System.out.println("Joint Account? yes/no");
				String joint = sc.nextLine();
				if (joint.equals("yes")){
					System.out.println("Enter joint customer Id: ");
					int jAcc = Integer.parseInt(sc.nextLine());
					for(int i = 0; i < customers.size(); i++) {
						if(customers.get(i).getId() == jAcc) {
							customers.get(i).addAccounts(newAcc);
						}
					}
				}
				for (int i = 0; i<customers.size(); i++) {
					if(customers.get(i).equals(c)) {
						customers.get(i).addAccounts(newAcc);
						//c.addAccounts(newAcc);
						accounts.add(newAcc);
						System.out.println("Applied for an account");
						CustomerMenu(c);
						break;
					}
				}
				CustomerMenu(c);
				break;
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
					if(accounts.get(i) == a) {
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
					if(accounts.get(i) == a) {
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
			eb.close();
			BufferedReader ab = new BufferedReader(new FileReader("Admin.txt"));
			String as = "";
				while((as=ab.readLine())!=null) {
					String lines[] = new String[2];
					lines = as.split(" ");
					Admin adm = new Admin(lines[0],lines[1]);
					admins.add(adm);
				}
			ab.close();
			BufferedReader accb = new BufferedReader(new FileReader("Account.txt"));
			String accs = "";
				while((accs=accb.readLine())!=null) {
					String lines[] = new String[2];
					lines = accs.split(" ");
					Account acc = new Account(Integer.parseInt(lines[0]),Boolean.parseBoolean(lines[1]), Double.parseDouble(lines[2]));
					accounts.add(acc);
				}
			accb.close();
			
			BufferedReader cb = new BufferedReader(new FileReader("Customer.txt"));
				String cs = "";
					while((cs=cb.readLine())!=null) {
						ArrayList<String> lines = new ArrayList<String>(Arrays.asList(cs.split(" ")));
						Customer cus = new Customer(lines.get(0),lines.get(1), lines.get(2), lines.get(3), Integer.parseInt(lines.get(4)));
						int accNum = Integer.parseInt(lines.get(5));
						for (int i = 0; i< accNum;i++) {
							for (int j = 0; j<accounts.size(); j++) {
								if(accounts.get(j).getId() == Integer.parseInt(lines.get(6+i)))
									cus.addAccounts(accounts.get(j));
							}
						}
						customers.add(cus);
					}
			cb.close();
		} 
		catch (Exception e) {}
	}
	void LoadToFile() {
		try {
			BufferedWriter cr = new BufferedWriter(new FileWriter("Customer.txt", false));
			String cs = "";
			for (int i= 0; i< customers.size(); i++) {
				cs = cs+customers.get(i).getUsername()+ " "+ customers.get(i).getPassword() + " "+ customers.get(i).getName()+" "+customers.get(i).getLast()+ " "+customers.get(i).getId()+ " "+ customers.get(i).getAccounts().size()+ " ";
				for (int j = 0; j < customers.get(i).getAccounts().size(); j++) {
					cs = cs + customers.get(i).getAccounts().get(j).getId();
				}
					if (i != customers.size()-1) {
						cs = cs + "\n";
					}
			}
			//System.out.println(cs);
			cr.write(cs);
			cr.close();
			
			BufferedWriter accr = new BufferedWriter(new FileWriter("Account.txt", false));
			String accs = "";
			for (int i= 0; i< accounts.size(); i++) {
				accs = accs+accounts.get(i).getId()+ " "+ accounts.get(i).getActive() + " "+ accounts.get(i).getBalance();
					if (i != accounts.size()-1) {
						accs = accs + "\n";
					}
			}
			//System.out.println(accs);
			accr.write(accs);
			accr.close();

			BufferedWriter er = new BufferedWriter(new FileWriter("Employee.txt", false));
			String es = "";
			for (int i= 0; i< admins.size(); i++) {
				es = es+employees.get(i).getUsername()+ " "+ employees.get(i).getPassword();
					if (i != employees.size()-1) {
						es = es + "\n";
					}
			}
			//System.out.println(es);
			er.write(es);
			er.close();
			
			BufferedWriter admr = new BufferedWriter(new FileWriter("Admin.txt", false));
			String adms = "";
			for (int i= 0; i< admins.size(); i++) {
				adms = adms+admins.get(i).getUsername()+ " "+ admins.get(i).getPassword();
					if (i != admins.size()-1) {
						adms = adms + "\n";
					}
			}
			//System.out.println(adms);
			admr.write(adms);
			admr.close();
			
			
		} catch (Exception e) {}
	}
}
