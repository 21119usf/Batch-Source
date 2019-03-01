package com.revature.bank;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import com.revature.daoimpl.UserDaoImpl;


public class Bank {
	private static Scanner sc = new Scanner(System.in);
	private static User u = null;
	private static ArrayList<User> users = new ArrayList<User>();
	private static UserDaoImpl db = new UserDaoImpl(); 
	private static Logger log = LogManager.getLogger(); 
	
	public static void main(String[] args) throws Exception {
		System.out.println("===================================================================================");
		System.out.println("========================WELCOME TO MY BANK=========================================");
		System.out.println("===================================================================================");

		loop: while (true) {
			System.out.println("Options:");
			System.out.println("1 --> log into an account\n" +
								"2 --> create a customer account\n" +
								"3 --> create an admin account\n" +
								"0 --> exit system\n" +
								"Enter option:"); 
			int option = sc.nextInt();
			log.trace("[OPTION ENTERED]: " + option); 
			sc.nextLine();
			//L

			switch (option) {
			// Login log out
				case 1:
					login();
					break;
				// create customer account
				case 2:
					createCustomer();
					break;
				// create admin account
				case 3:
					createAdmin();
					break;
				// exit system
				case 0:
					break loop;
				}

			if (u != null) {
				loggedIn();
			}
		}
		System.out.println("End of program, reset to begin!"); 
	}

	public static void loggedIn() throws SQLException {
		User x = db.getUser(u.username);
		if (!x.approval) {
			System.out.println(u.username + " are not approved for deposits/withdrawals by an admin.\n");
			x = null;
			return;
		}
		
		if(x.admin)
			System.out.println("=============Welcome Admin " + x.username + " ====================");
		if(!x.admin)
			System.out.println("=============Welcome Customer " + x.username + " ====================");

		while (true) {
				System.out.println("Options:\n" +
							   	   "1 --> deposit\n" +
							   	   "2 --> withdraw");
				System.out.println("3 --> check my information");
			if (u.admin) {
				System.out.println("4 --> approve users");
				System.out.println("5 --> edit users");
				System.out.println("6 --> view all users");
				System.out.println("7 --> delete users");
			}
			System.out.println("0 --> to log out of: " + u.username);
			System.out.println("Enter option: \n");

			int option = sc.nextInt();
			sc.nextLine();
			//L
				if (!u.admin && option > 3) {
					System.out.println("Invalid option for a customer. Retry...");
					continue;
				}
						switch (option) {
						case 0:
							System.out.println(u.username + " logging out...");//logging out
							u = null;
							log.trace("[LOGGED OUT]");
							return;
						case 1:
							deposit();
							break;
						case 2:
							withdraw();
							break;
						case 3: 
							checkMyInfo();
							break;
						case 4:
							approveUsers();
							break;
						case 5: 
							updateUser(); 
							break;
						case 6: 
							viewInfo();
							break;
						case 7:
							deleteUser();
						}
			}
	}

	public static void login() throws IOException, SQLException {
		boolean authenticated = false;
		while (!authenticated) {
			System.out.println("\nEnter your user name: ");
			String username = sc.nextLine();
			u = db.getUser(username);
			if (u == null) {
				System.out.println("Invalid user name: " + username);
				return;
			}
			
			System.out.println("\nEnter your password: ");
			
			String password = sc.nextLine();

			if (!u.password.equals(password)) {
				System.out.println("Invalid password for : " + username);
				//L
				//L
			} else
				authenticated = true;
		}
		log.trace("[LOGGED IN]"); 
		System.out.println("Welcome " + u.username);
		//L

		loggedIn();
	}

	public static void createCustomer() throws SQLException {
		System.out.println("Create a customer account");
		createUser(false, false);
		System.out.println("Customer account created, username: " + u.username);
	}

	public static void createAdmin() throws SQLException {
		System.out.println("Create an admin account");
		createUser(true, true);
		db.createAccount(u.username, u.balance);
		System.out.println("Admin account created, username: " + u.username);
	}

	public static void createUser(boolean entity, boolean approval) throws SQLException {
		String name = null;
		while (true) {
			System.out.println("Enter a new user name: ");
			name = sc.nextLine();
			if (uniqueUser(name) == null)
				break;
			System.out.println("User name already exists!");
		}
		
		System.out.println("Enter a password: ");
		String password = sc.nextLine();
		u = new User(name, password, 0, entity, approval);
		db.createUser(u);////////
		System.out.println("You successfully added a user");
		log.trace("[USER CREATED]"); 
	}

	private static void approveUsers() throws SQLException {
		users = db.getAllUsers(); 
		if (users.isEmpty()) {
			System.out.println("No users in the system.");
			return;
		}
		
		while(true) {
		System.out.println("=======================================");
		System.out.println("Enter the name of the user to approve: ");
		System.out.println("=======================================");
		
		String name = sc.nextLine();
		User temp = db.getUser(name);
			if(temp != null && temp.approval) {
				System.out.println("This user is already approved, Try again");
			}
			else if(temp != null && !temp.approval){
				db.approveUser(temp);
				System.out.println(temp.username + " has been approved"); 
				db.createAccount(temp.username, temp.balance);
				return; 
			}else {
				System.out.println("That user doesn't exist in our system");
				return;
			}
		}
	}

	public static void deposit() throws SQLException {
		User temp = db.getUser(u.username); 
		System.out.println(u.username + " your current balance is : $" + temp.balance);
		System.out.println("Enter the amount to deposit: ");
		System.out.print("$");
		float amount = sc.nextFloat(); 
		float total = amount + temp.balance; 
		db.setBalance(temp.username, total);
		float temp1 = db.getBalance(u.username); 
		System.out.println(temp.username + " your new balance is : $" + temp1);
	}

	public static void withdraw() throws SQLException {
		User temp = db.getUser(u.username);
		System.out.println(u.username + " your current balance is : $" + temp.balance);
		System.out.println("Enter the amount to withdraw: ");
		System.out.print("$");
		float amount = sc.nextFloat();
		if(amount < 0) 
			System.out.println("You entered a negative amount");
		else if(amount > db.getBalance(temp.username))
			System.out.println("The amunt is greater than your current balance"); 
		else {
			float total = temp.balance - amount; 
			db.setBalance(temp.username, total);
		}
		float temp1 = db.getBalance(temp.username); 
		System.out.println(temp.username + " your new balance is : $" + temp1);
	}
	
	public static void viewInfo() throws SQLException {
		db.getAllUsers(); 
	}	
	
	public static void updateUser() throws SQLException {
		db.getAllUsers(); 
		System.out.println("=============================================");
		System.out.println("Enter the name of the user you want to EDIT: ");
		System.out.println("=============================================");
		String name = sc.nextLine();
		User temp = db.getUser(name); 
		System.out.println("Enter new info for " + temp.username);
		System.out.println("Enter new password: ");
		temp.password = sc.nextLine();
		System.out.println("Enter new balance: ");
		temp.balance = sc.nextFloat();
		db.editUser(temp);
		System.out.println("User update completed///////////"); 
	}
	
	public static void deleteUser() throws SQLException {
		db.getAllUsers(); 
		System.out.println("============================================================");
		System.out.println("Enter the name and password of the user you want to DELETE: ");
		System.out.println("============================================================");
		System.out.println("Enter the username: ");
		String usr = sc.nextLine(); 
		System.out.println("Enter the password: ");
		String pw = sc.nextLine(); 
		int uid = db.getUserId(usr, pw);
		System.out.println(uid);
		db.deleteUser(uid); 
		System.out.println(usr + " Has been DELETED"); 
	}
	
	public static void checkMyInfo() throws SQLException {
			int accountnum = db.getAccountNum(u.username);  
			System.out.println("+ My username --> " + db.getUser(u.username).username); 
			System.out.println("+ My balance 	--> " + db.getUser(u.username).balance); 
			System.out.println("+ My account number --> " + accountnum); 
			if(db.getUser(u.username).admin)
				System.out.println("+ Entity type -->  ADMIN");
			else
				System.out.println("+ Entity type -->  CUSTOMER");	
	}
	
	public static User uniqueUser(String name) throws SQLException {
			users = db.getAllUsers();
			if(!users.isEmpty()) {
				for(User x : users) {
					if(x.username.equals(name))
						return x; 
				}
			}
		return null; 
	}
}