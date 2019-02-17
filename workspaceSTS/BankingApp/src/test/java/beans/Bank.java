package beans;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
	private ArrayList<Customer> customers;
	private ArrayList<Employee> employees;
	private ArrayList<Admin> admins;
	private ArrayList<User> pendingApprovalQueue;
	
	
	//Constructor
	public Bank() {
		this.customers = new ArrayList<Customer>();
		this.employees = new ArrayList<Employee>();
		this.admins = new ArrayList<Admin>();
		this.pendingApprovalQueue = new ArrayList<User>();
		
		Admin superUser = new Admin();
		superUser.setName("Admin");
		superUser.setUserName("Admin");
		admins.add(superUser);
	}
	
	
	//Methods
	
	public int start() {
		System.out.print("Welcome to the Marx Bank"
				+"\nTo select options, please type the number next to your choice and hit enter"
				+"\n\nWould you like to login, register, or exit?"
				+"\n(1) - Login"
				+"\n(2) - Register"
				+"\n(3) - Exit"
				+"\n> ");
		
		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		//input.close();            //Closing this scanner causes a problem with input in login
		return option;
	}
	
	
	public User login() {
		Scanner input = new Scanner(System.in); 
		String username;
		String password;
		User user = null;
		boolean successfulLogin = false;
		
		while (!successfulLogin) {
			System.out.print("Username: ");
			username = input.nextLine();
			System.out.print("Password: ");
			password = input.nextLine();
			user = validateCredentials(username, password);
			if (user == null)
				System.out.println("Invalid username/password combination");
			else
				successfulLogin = true;
		}
		return user;
	}
	
	public User validateCredentials(String username, String password) {
		for (User e: customers) {
			if (e.userName.equals(username) && e.password.equals(password))
				return e;
		}
		for (User e: employees) {
			if (e.userName.equals(username) && e.password.equals(password))
				return e;
		}
		for (User e: admins) {
			if (e.userName.equals(username) && e.password.equals(password))
				return e;
		}
		return null;
	}
	
	public boolean isUniqueID(String username) {
		for (User e: customers) {
			if (e.userName.equals(username))
				return false;
		}
		for (User e: employees) {
			if (e.userName.equals(username))
				return false;
		}
		for (User e: admins) {
			if (e.userName.equals(username))
				return false;
		}
		for (User e: pendingApprovalQueue)
			if (e.userName.equals(username)) {
				return false;
		}
		return true;
	}
	
	public void registerApplication() {
		System.out.print("\nWhat type of account will you be registering for?"
				+"\n(1) - Customer"
				+"\n(2) - Employee"
				+"\n(3) - Administrator"
				+"\n> ");
		Scanner input = new Scanner(System.in);
		int option = input.nextInt();
		User newUser = null;
		switch (option) {
		case 1:
			newUser = new Customer();
			break;
		case 2:
			newUser = new Employee();
			break;
		case 3:
			newUser = new Admin();
		}
		System.out.print("Please enter the following information for your account"
							+ "\nName: ");
		input.nextLine();	//this is to clear the newline character after the integer
			
		newUser.setName(input.nextLine());
		System.out.print("Address: ");
		newUser.setAddress(input.nextLine());
		System.out.print("E-mail address: ");
		newUser.setEmail(input.nextLine());
		System.out.print("Phone #: ");
		newUser.setPhoneNum(input.nextLine());
		
		boolean uniqueLogin = false;
		String username = "";
		while (!uniqueLogin || username.equals("")) {
			System.out.print("Username: ");
			username = input.nextLine();
			uniqueLogin = isUniqueID(username);
			if (username.equals(""))
				System.out.println("You must enter a username.");
			else if (!uniqueLogin)
				System.out.println("Sorry, that username is already taken.");
			
		}
		newUser.setUserName(username);
		System.out.print("Password: ");
		newUser.setPassword(input.nextLine());
		
		
		System.out.print("\nYour application shows...\n" + newUser.toString()
						+ "\nIs this what you would like to submit? (y/n)\n> ");
		char c = input.nextLine().charAt(0);
		if (c == 'y' || c == 'Y') {
			pendingApprovalQueue.add(newUser);
			System.out.println("Your application was submitted successfully."
							+ "\nPlease wait for a staff member to approve your application."
							+ "\nOnce approved you may log in to your account and manage it");
		}
		else if (c == 'n' || c == 'N')
			System.out.println("Your application was not submitted.");
	}
	
	public void loggedInMenu(User user) {
		Scanner input = new Scanner(System.in);
		int option;
		switch(user.getAccessLevel()) {
		case 0: 		//Admin Menu
			System.out.print("\nWelcome " + user.getUserName() + "."
					+ "\nWhat would you like to do today?"
					+ "\n(1) - View a user's account info"
					+ "\n(2) - View a user's personal info"
					+ "\n(3) - View a customer's balance"
					+ "\n(4) - Deposit Money into customer's account"
					+ "\n(5) - Withdraw Money from customer's account"
					+ "\n(6) - Transfer Money between two customer's accounts"
					+ "\n(7) - Account Cancellation"
					+ "\n(8) - View the pending list of applications to approve/deny"
					+ "\n(9) - Logout"
					+ "\n> ");
			break;
		case 1:			//Employee Menu
			System.out.print("\nWelcome " + user.getUserName() + "."
					+ "\nWhat would you like to do today?"
					+ "\n(1) - View a customer's account info"
					+ "\n(2) - View a customer's personal info"
					+ "\n(3) - View a customer's balance"
					+ "\n(8) - View the pending list of applications to approve/deny"
					+ "\n(9) - Logout"
					+ "\n> ");
			break;
		case 2:			//Customer Menu
			System.out.print("\nWelcome " + user.getUserName() + "."
					+ "\nWhat would you like to do today?"
					+ "\n(1) - View my account info"
					+ "\n(2) - View my personal info"
					+ "\n(3) - View my balance"
					+ "\n(4) - Deposit Money"
					+ "\n(5) - Withdraw Money"
					+ "\n(6) - Transfer Money"
					+ "\n(9) - Logout"
					+ "\n> ");
		}
		option = input.nextInt();
	}
	
	public boolean deposit(User depositor, Customer depositee, double amount) {
		if (depositor.equals(depositee) || depositor.getAccessLevel() == 0) {//if the depositor is depositing to themselves
			depositee.deposit(amount);										//	or if the depositor is an admin
			return true;
		}
		return false;			
	}
	
	public boolean withdraw(User withdrawer, Customer withdrawee, double amount) {
		if (withdrawer.equals(withdrawee) || withdrawer.getAccessLevel() == 0) {//if the withdrawer is withdrawing from themselves
			withdrawee.deposit(amount);										//	or if the withdrawer is an admin
			return true;
		}
		return false;
	}
	
	public boolean transfer(User user, Customer source, Customer destination, double amount) {
		if (user.equals(source) || user.getAccessLevel() == 0) { 
			source.transfer(destination, amount);
			return true;
		}
		return false;
	}
	
	public void approveCustomer(Customer customer) {
		customers.add(customer);
		pendingApprovalQueue.remove(customer);
	}
	
	public void approveEmployee(Employee employee) {
		employees.add(employee);
		pendingApprovalQueue.remove(employee);
	}
	
	public void approveAdmin(Admin admin) {
		admins.add(admin);
		pendingApprovalQueue.remove(admin);
	}
	
	public void deny(User user) {
		pendingApprovalQueue.remove(user);
	}
	
	public void viewPersonalInfo(User user) {
		user.printPersonalInfo();
	}
	
	public void viewAccountInfo(User user) {
		user.printAccountInfo();
	}
	
	public void viewCustomerBalance(Customer customer) {
		System.out.println("$" + customer.getBalance());
	}
	
	public boolean cancelAccount(String username) {
		for (User e: customers) {
			if (e.userName.equals(username))
				return customers.remove(e);
		}
		for (User e: employees) {
			if (e.userName.equals(username))
				return employees.remove(e);
		}
		for (User e: admins) {
			if (e.userName.equals(username))
				return employees.remove(e);
		}
		return false;
	}
	
	public User findAccount(String username) {
		for (User e: customers) {
			if (e.userName.equals(username))
				return e;
		}
		for (User e: employees) {
			if (e.userName.equals(username))
				return e;
		}
		for (User e: admins) {
			if (e.userName.equals(username))
				return e;
		}
		return null;
	}
}
























