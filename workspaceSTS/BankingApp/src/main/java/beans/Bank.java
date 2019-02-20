package beans;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bank {

	private ArrayList<Customer> customers;
	private ArrayList<Employee> employees;
	private ArrayList<Admin> admins;
	private ArrayList<Customer> pendingApprovalCustomers;
	private ArrayList<Employee> pendingApprovalStaff;
	static Logger logger = LogManager.getLogger(Bank.class);
	
	
	//Constructor
	public Bank() {
		this.customers = new ArrayList<Customer>();
		this.employees = new ArrayList<Employee>();
		this.admins = new ArrayList<Admin>();
		this.pendingApprovalCustomers = new ArrayList<Customer>();
		this.pendingApprovalStaff= new ArrayList<Employee>();
		
		Admin superUser = new Admin();
		superUser.setName("Admin");
		superUser.setUserName("Admin");
		admins.add(superUser);
	}
	
	
	//Methods
	
	@SuppressWarnings("unchecked")
	public void readInfo() {
		ObjectInputStream objectIn;
		try {
			objectIn = new ObjectInputStream(new FileInputStream("customers.txt"));
			customers = (ArrayList<Customer>) objectIn.readObject();
			objectIn.close();
			
			objectIn = new ObjectInputStream(new FileInputStream("employees.txt"));
			employees = (ArrayList<Employee>) objectIn.readObject();
			objectIn.close();
			
			objectIn = new ObjectInputStream(new FileInputStream("admins.txt"));
			admins = (ArrayList<Admin>) objectIn.readObject();
			objectIn.close();
			
			objectIn = new ObjectInputStream(new FileInputStream("pendingApprovalCustomers.txt"));
			pendingApprovalCustomers = (ArrayList<Customer>) objectIn.readObject();
			objectIn.close();
			
			objectIn = new ObjectInputStream(new FileInputStream("pendingApprovalStaff.txt"));
			pendingApprovalStaff = (ArrayList<Employee>) objectIn.readObject();
			objectIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeInfo(int choice) {
		ObjectOutputStream objectOut;
		try {
			switch (choice) {
			case 0:
				objectOut = new ObjectOutputStream (new FileOutputStream("customers.txt", false));
				objectOut.writeObject(customers);
				objectOut.close();
				break;
			case 1:
				objectOut = new ObjectOutputStream (new FileOutputStream("employees.txt", false));
				objectOut.writeObject(employees);
				objectOut.close();
				break;
			case 2:
				objectOut = new ObjectOutputStream (new FileOutputStream("admins.txt", false));
				objectOut.writeObject(admins);
				objectOut.close();
				break;
			case 3:
				objectOut = new ObjectOutputStream (new FileOutputStream("pendingApprovalCustomers.txt", false));
				objectOut.writeObject(pendingApprovalCustomers);
				objectOut.close();
				break;
			case 4:
				objectOut = new ObjectOutputStream (new FileOutputStream("pendingApprovalStaff.txt", false));
				objectOut.writeObject(pendingApprovalStaff);
				objectOut.close();
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
	
	
	public void login() {
		Scanner input = new Scanner(System.in); 
		String username = "";
		String password = "";
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
		logger.info(user.getUserName() + " logged in.");
		switch (user.getAccessLevel()) {
			case 0:
				adminMenu((Admin)user);
				break;
			case 1:
				employeeMenu((Employee)user);
				break;
			case 2:
				customerMenu((Customer)user);
		}
		logger.info(user.getUserName() + " logged out.");
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
		for (User e: pendingApprovalCustomers)
			if (e.userName.equals(username)) {
				return false;
		}
		for (User e: pendingApprovalStaff)
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
			break;
		default:
			System.out.println("Invalid Option\n\n");
			return;
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
			if (newUser.getAccessLevel() == 0 || newUser.getAccessLevel() == 1) {
				pendingApprovalStaff.add((Employee)newUser);
				writeInfo(4); //Update our queue for employee/admin applications
			}
			else {
				pendingApprovalCustomers.add((Customer)newUser);
				writeInfo(3); //Update our queue for customer applications
			}
			System.out.println("Your application was submitted successfully."
							+ "\nPlease wait for a staff member to approve your application."
							+ "\nOnce approved you may log in to your account and manage it.");
			logger.info(newUser.getUserName() + " submitted an application for an account.");
		}
		else if (c == 'n' || c == 'N')
			System.out.println("Your application was not submitted.");
	}

	public void adminMenu(Admin user) {
		Scanner input = new Scanner(System.in);
		Scanner strings = new Scanner(System.in);
		Scanner doubles = new Scanner(System.in);
		int option;
		String line;
		double amount;
		
		while (true) {
			System.out.print("\nWelcome " + user.getUserName() + "."
					+ "\nWhat would you like to do today?"
					+ "\n(0) - View user information"
					+ "\n(1) - Perform a transaction for a Customer"
					+ "\n(2) - View the pending list of applications to approve/deny"
					+ "\n(3) - Account Cancelation"
					+ "\n(4) - Logout"
					+ "\n> ");
			option = input.nextInt();
			switch (option) {
				case 0:										//View information pertaining to a User
					System.out.print("\nWhose user information do you want to view?"
							+ "\n(0) - Mine"
							+ "\n(1) - An Employee's"
							+ "\n(2) - A Customer's"
							+ "\n(3) - Cancel"
							+ "\n> ");
					option = input.nextInt();
					switch (option) {
					case 0:									//View information pertaining to me(Admin)
						System.out.print("\nWhich information do you want to see?"
								+ "\n(0) - Account information"
								+ "\n(1) - Personal information"
								+ "\n(2) - Cancel"
								+ "\n> ");
						option = input.nextInt();
						switch (option) {
							case 0:							//View my(Admin) account information
								viewAccountInfo(user);
								break;
							case 1:							//View my(Admin) personal information
								viewPersonalInfo(user);
								break;
							case 2:							//Do nothing by choice
								break;
							default:						//Invalid choice
								System.out.println("Invalid Option");
								break;
						}
						break;
					case 1:									//View information pertaining to an Employee
						System.out.print("Employee's Username: ");
						line = strings.nextLine();
						Employee tempEmployee = findEmployee(line);
						if (tempEmployee == null) {
							System.out.println("Employee with the username '" + line + "' was not found");
							break;
						}
						System.out.print("\nWhich information do you want to see?"
								+ "\n(0) - Account information"
								+ "\n(1) - Personal information"
								+ "\n(2) - Cancel"
								+ "\n> ");
						option = input.nextInt();
						switch (option) {
							case 0:							//View the employee's Account information
								viewAccountInfo(tempEmployee);
								break;
							case 1:							//View the employee's Personal information
								viewPersonalInfo(tempEmployee);
								break;
							case 2:							//Do nothing by choice
								break;
							default:						//Invalid choice
								System.out.println("Invalid Option");
								break;
						}
						break;
					case 2:									//View information pertaining to a Customer
						System.out.print("Customer's Username: ");
						line = strings.nextLine();
						Customer tempCustomer = findCustomer(line);
						if (tempCustomer == null) {
							System.out.println("Customer with the username '" + line + "' was not found");
							break;
						}
						System.out.print("\nWhich information do you want to see?"
								+ "\n(0) - Account information"
								+ "\n(1) - Personal information"
								+ "\n(2) - Balance"
								+ "\n(3) - Cancel"
								+ "\n> ");
						option = input.nextInt();
						switch (option) {
							case 0:							//View the customer's Account information
								viewAccountInfo(tempCustomer);
								break;
							case 1:							//View the customer's Personal information
								viewPersonalInfo(tempCustomer);
								break;
							case 2:							//View the customer's current balance
								System.out.println(tempCustomer.getUserName() + "'s Balance is");
								viewCustomerBalance(tempCustomer);
								break;
							case 3:							//Do nothing by choice
								break;
							default:						//Invalid choice
								System.out.println("Invalid Option");
								break;
						}
						break;
					case 3:
						break;
					default:
						System.out.println("Invalid Option");
					}
					break;
				case 1:										//Perform a transaction
					System.out.print("Customer's Username: ");
					line = strings.nextLine();
					Customer tempCustomer = findCustomer(line);
					if (tempCustomer == null) {
						System.out.println("Customer with the username '" + line + "' was not found");
						break;
					}
					System.out.print("\nWhat type of transaction would you like to perform?"
							+ "\n(0) - Deposit"
							+ "\n(1) - Withdrawal"
							+ "\n(2) - Transfer"
							+ "\n(3) - Cancel"
							+ "\n> ");
					option = input.nextInt();
					switch (option) {
						case 0:							//Deposit
							System.out.print("How much would you like to deposit? (Enter in the form $X.XX)\n> $");
							amount = doubles.nextDouble();
							deposit(user, tempCustomer, amount);
							//System.out.println("Transaction complete");
							break;
						case 1:							//Withdrawal
							System.out.print("How much would you like to withdraw? (Enter in the form $X.XX)\n> $");
							amount = doubles.nextDouble();
							withdraw(user, tempCustomer, amount);
							//System.out.println("Transaction complete");
							break;
						case 2:							//Transfer
							if (tempCustomer.jointAccounts.size() == 0) {
								System.out.println("This account does not have any joint accounts.");
								break;
							}
							System.out.print("How much would you like to transfer? (Enter in the form $X.XX)\n> $");
							amount = doubles.nextDouble();
							System.out.println("The following are accounts you are adjoined to?");
							for (String c: tempCustomer.jointAccounts)
								System.out.println(c);
							System.out.print("Please type the username of the recipient of the transfer: ");
							line = strings.nextLine();
							while (!tempCustomer.jointAccounts.contains(line)) {
								System.out.print("You do not have an account with the username '" + line + "' adjoined to you\n"
												+"Please type the username of the recipient of the transfer: ");
								line = strings.nextLine();
							}
							Customer recipient = findCustomer(line);
							transfer(user, tempCustomer, recipient, amount);
							//System.out.println("Transaction complete");
							break;
						case 3:							//Do nothing by choice
							break;
						default:						//Invalid choice
							System.out.println("Invalid Option");
							break;
					}
					break;
				case 2:										//View the list of applications to approve/deny
					approveMenu(user.getAccessLevel());
					break;
				case 3:										//Cancel an account
					System.out.print("Username of the account to cancel: ");
					line = strings.nextLine();
					if (!cancelAccount(line))
						System.out.println("Customer with the username '" + line + "' was not found");
					else
						System.out.println("Account successfully removed");
					break;
				case 4:										//logout, return to login screen
					return;
				default:									//Invalid choice
					System.out.println("Invalid Option");
					break;
			}//outermost switch statement
		}//while loop
	}//admin menu
	
	public void employeeMenu(Employee user) {
		Scanner input = new Scanner(System.in);
		Scanner strings = new Scanner(System.in);
		Scanner doubles = new Scanner(System.in);
		int option;
		String line;
		double amount;
		
		while (true) {
			System.out.print("\nWelcome " + user.getUserName() + "."
					+ "\nWhat would you like to do today?"
					+ "\n(0) - View user information"
					+ "\n(1) - View the pending list of applications to approve/deny"
					+ "\n(2) - Logout"
					+ "\n> ");
			option = input.nextInt();
			switch (option) {
			case 0:										//View information pertaining to a User
				System.out.print("\nWhose user information do you want to view?"
						+ "\n(0) - Mine"
						+ "\n(1) - A Customer's"
						+ "\n(2) - Cancel"
						+ "\n> ");
				option = input.nextInt();
				switch (option) {
					case 0:									//View information pertaining to me(Employee)
						System.out.print("\nWhich information do you want to see?"
								+ "\n(0) - Account information"
								+ "\n(1) - Personal information"
								+ "\n(2) - Cancel"
								+ "\n> ");
						option = input.nextInt();
						switch (option) {
							case 0:							//View my(Employee) account information
								viewAccountInfo(user);
								break;
							case 1:							//View my(Employee) personal information
								viewPersonalInfo(user);
								break;
							case 2:							//Do nothing by choice
								break;
							default:						//Invalid choice
								System.out.println("Invalid Option");
								break;
						}
						break;
				
					case 1:									//View information pertaining to a Customer
						System.out.print("Customer's Username: ");
						line = strings.nextLine();
						Customer tempCustomer = findCustomer(line);
						if (tempCustomer == null) {
							System.out.println("Customer with the username '" + line + "' was not found");
							break;
						}
						System.out.print("\nWhich information do you want to see?"
								+ "\n(0) - Account information"
								+ "\n(1) - Personal information"
								+ "\n(2) - Balance"
								+ "\n(3) - Cancel"
								+ "\n> ");
						option = input.nextInt();
						switch (option) {
							case 0:							//View the customer's Account information
								viewAccountInfo(tempCustomer);
								break;
							case 1:							//View the customer's Personal information
								viewPersonalInfo(tempCustomer);
								break;
							case 2:							//View the customer's current balance
								System.out.println(tempCustomer.getUserName() + "'s Balance is");
								viewCustomerBalance(tempCustomer);
								break;
							case 3:							//Do nothing by choice
								break;
							default:						//Invalid choice
								System.out.println("Invalid Option");
								break;
						}
						break;
					case 2:
						break;
					default:
						System.out.println("Invalid Option");
					}
					break;
			case 1:										//View the list of applications to approve/deny
				approveMenu(user.getAccessLevel());
				break;
			case 2:										//logout, return to login screen
				return;
			default:									//Invalid choice
				System.out.println("Invalid Option");
				break;
		}//outermost switch statement
				
		}
	}
	
	public void customerMenu(Customer user) {
		Scanner input = new Scanner(System.in);
		Scanner strings = new Scanner(System.in);
		Scanner doubles = new Scanner(System.in);
		int option;
		String line;
		double amount;
		
		while (true) {
			System.out.print("\nWelcome " + user.getUserName() + "."
					+ "\nWhat would you like to do today?"
					+ "\n(0) - View my information"
					+ "\n(1) - Perform a transaction"
					+ "\n(2) - Logout"
					+ "\n> ");
			option = input.nextInt();
			switch (option) {
				case 0:									//View information pertaining to me(Customer)
					System.out.print("\nWhich information do you want to see?"
							+ "\n(0) - Account information"
							+ "\n(1) - Personal information"
							+ "\n(2) - View my balance"
							+ "\n(3) - Cancel"
							+ "\n> ");
					option = input.nextInt();
					switch (option) {
						case 0:							//View my(Customer) account information
							viewAccountInfo(user);
							break;
						case 1:							//View my(Customer) personal information
							viewPersonalInfo(user);
							break;
						case 2:
							System.out.println("My balance is " + user.getBalance());
						case 3:							//Do nothing by choice
							break;
						default:						//Invalid choice
							System.out.println("Invalid Option");
							break;
					}
					break;	
				case 1:										//Perform a transaction
					System.out.print("\nWhat type of transaction would you like to perform?"
							+ "\n(0) - Deposit"
							+ "\n(1) - Withdrawal"
							+ "\n(2) - Transfer"
							+ "\n(3) - Cancel"
							+ "\n> ");
					option = input.nextInt();
					switch (option) {
						case 0:							//Deposit
							System.out.print("How much would you like to deposit? (Enter in the form $X.XX)\n> $");
							amount = doubles.nextDouble();
							deposit(user, user, amount);
							//System.out.println("Transaction complete");
							break;
						case 1:							//Withdrawal
							System.out.print("How much would you like to withdraw? (Enter in the form $X.XX)\n> $");
							amount = doubles.nextDouble();
							withdraw(user, user, amount);
							//System.out.println("Transaction complete");
							break;
						case 2:							//Transfer
							if (user.jointAccounts.size() == 0) {
								System.out.println("This account does not have any joint accounts.");
								break;
							}
							System.out.print("How much would you like to transfer? (Enter in the form $X.XX)\n> $");
							amount = doubles.nextDouble();
							System.out.println("The following are accounts you are adjoined to?");
							for (String c: user.jointAccounts)
								System.out.println(c);
							System.out.print("Please type the username of the recipient of the transfer: ");
							line = strings.nextLine();
							while (!user.jointAccounts.contains(line)) {
								System.out.print("There is no account with the username '" + line + "' adjoined to this account.\n"
												+"Please type the username of the recipient of the transfer: ");
								line = strings.nextLine();
							}
							Customer recipient = findCustomer(line);
							transfer(user, user, recipient, amount);
							//System.out.println("Transaction complete");
							break;
						case 3:							//Do nothing by choice
							break;
						default:						//Invalid choice
							System.out.println("Invalid Option");
							break;
					}
					break;
				case 2:										//logout, return to login screen
					return;
				default:									//Invalid choice
					System.out.println("Invalid Option");
					break;
			}//outermost switch statement
		}//while loop
	}
	
	public void approveMenu(int accessLevel) {
		Scanner input = new Scanner(System.in);
		char choice;
		int arraySize = pendingApprovalCustomers.size();
		if (arraySize != 0) {
			Customer tempCustomer = null;
			for (int i = 0; i < arraySize; i++) {
				tempCustomer = pendingApprovalCustomers.remove(0);
				writeInfo(3); //Update the customer applications queue
				System.out.print("\n" + tempCustomer + "\nApprove? (y/n)\n> ");
				choice = input.nextLine().charAt(0);
				if (choice == 'Y' || choice == 'y') {
					customers.add(tempCustomer);
					writeInfo(0); //Update the customers list
				}
			}
		}
		arraySize = pendingApprovalStaff.size();
		if (arraySize != 0 && accessLevel == 0) {
			Employee tempEmployee = null;
			for (int i = 0; i < arraySize; i++) {
				tempEmployee = pendingApprovalStaff.remove(0);
				writeInfo(4); //Update the employee/admin applications queue
				System.out.print("\n" + tempEmployee + "\nApprove? (y/n)\n> ");
				choice = input.nextLine().charAt(0);
				if (choice == 'Y' || choice == 'y') {
					if (tempEmployee.getAccessLevel() == 0) {
						admins.add((Admin)tempEmployee);
						writeInfo(2); //Update the admins list
					}
					else {
						employees.add(tempEmployee);
						writeInfo(1); //Update the employees list
					}
				}
			}
		}
		System.out.println("There are no more applications in queue");
	}
	
	public boolean deposit(User depositor, Customer depositee, double amount) {
		if (depositor.equals(depositee) || depositor.getAccessLevel() == 0) {//if the depositor is depositing to themselves
			depositee.deposit(amount);										//	or if the depositor is an admin
			logger.info(depositor.getUserName() + " depositted $" + amount + " into " + depositee.getUserName() + "'s account.");
			writeInfo(0);
			return true;
		}
		return false;			
	}
	
	public boolean withdraw(User withdrawer, Customer withdrawee, double amount) {
		if (withdrawer.equals(withdrawee) || withdrawer.getAccessLevel() == 0) {//if the withdrawer is withdrawing from themselves
			withdrawee.withdraw(amount);										//	or if the withdrawer is an admin
			logger.info(withdrawer.getUserName() + " withdrew $" + amount + " from " + withdrawee.getUserName() + "'s account.");
			writeInfo(0);
			return true;
		}
		return false;
	}
	
	public boolean transfer(User user, Customer source, Customer destination, double amount) {
		if (user.equals(source) || user.getAccessLevel() == 0) { 
			source.transfer(destination, amount);
			logger.info(user.getUserName() + " transferred $" + amount + " from " + source.getUserName() + "'s account to "
						+ destination.getUserName() + "'s account.");
			writeInfo(0);
			return true;
		}
		return false;
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
			if (e.userName.equals(username)) {
				writeInfo(0);
				return customers.remove(e);
			}
		}
		for (User e: employees) {
			if (e.userName.equals(username)) {
				writeInfo(1);
				return employees.remove(e);
			}
		}
		for (User e: admins) {
			if (e.userName.equals(username)) {
				writeInfo(2);
				return admins.remove(e);
			}
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
	
	public Customer findCustomer(String username) {
		for (Customer e: customers) {
			if (e.userName.equals(username))
				return e;
		}
		return null;
	}
	
	public Employee findEmployee(String username) {
		for (Employee e: employees) {
			if (e.userName.equals(username))
				return e;
		}
		return null;
	}
	
	public Admin findAdmin(String username) {
		for (Admin e: admins) {
			if (e.userName.equals(username))
				return e;
		}
		return null;
	}
	
	public void printContents() {
		System.out.println("\nCustomers:\n" + customers
							+"\n\nEmployees:\n" + employees
							+"\n\nAdmins:\n" + admins
							+"\n\nPending Customers:\n" + pendingApprovalCustomers
							+"\n\nPending Staff:\n" + pendingApprovalStaff
							+"\n");
	}
}
























