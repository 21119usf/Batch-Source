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
				+"\n\nWould you like to login or register?"
				+"\n(1) - Login"
				+"\n(2) - Register"
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
			user = validate(username, password);
			if (user == null)
				System.out.println("Invalid username/password combination");
			else
				successfulLogin = true;
		}
		return user;
	}
	
	public User validate(String username, String password) {
		for (User e: customers) {
			if (e.userName.equals(username) && e.password.equals(password)) {
				return e;
			}
		}
		for (User e: employees) {
			if (e.userName.equals(username) && e.password.equals(password)) {
				return e;
			}
		}
		for (User e: admins) {
			if (e.userName.equals(username) && e.password.equals(password)) {
				return e;
			}
		}
		return null;
	}
	
	public boolean registerApplication() {
//		System.out.print("What type of account will you be registering for?"
//				+"\n(1) - Customer"
//				+"\n(2) - Employee"
//				+"\n(3) - Administrator"
//				+"\n> ");
//option = ints.nextInt();
//User newUser;
//switch (option) {
//	case 1:
//		Customer newCustomer = new Customer();
//	case 2:
//		
//}
		return false;
	}
	
	public boolean deposit(double amount) {
		return false;
	}
	
	public boolean withdraw(double amount) {
		return false;
	}
	
	public boolean transfer(double amount) {
		return false;
	}
	
	public boolean approve() {
		return false;
	}
	
	public boolean deny() {
		return false;
	}
	
	public void viewPersonalInfo() {
		
	}
	
	public void viewAccountInfo() {
		
	}
	
	public void viewCustomerBalance() {
		
	}
	
	public boolean cancelAccount() {
		return false;
	}
}
























