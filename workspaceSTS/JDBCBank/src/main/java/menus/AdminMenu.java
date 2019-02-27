package menus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import beans.BankAccount;
import beans.LoginAccount;
import beans.UserAccount;
import daoImplementation.LoginAccountDaoImpl;
import daoImplementation.UserAccountDaoImpl;
import menus.UserMenu;

public class AdminMenu {
	public static UserAccountDaoImpl uadi = new UserAccountDaoImpl();
	public static LoginAccountDaoImpl ladi = new LoginAccountDaoImpl();
	
	public static void start(LoginAccount login, UserAccount user) {
		Scanner input = new Scanner(System.in);
		int option;
	
		while (true) {
			System.out.print("\nWelcome " + login.getUserName() + "."
					+ "\nWhat would you like to do today?"
					+ "\n(0) - View list of pending users"		//
					+ "\n(1) - View/Edit user accounts"			//
					+ "\n(2) - View/Edit admin accounts"		//
					+ "\n(3) - Logout"							//
					+ "\n> ");
			option = input.nextInt();
			System.out.println();
			switch (option) {
				case 0:									//View information pertaining to me(Customer)
					viewPendingList();
					break;	
				case 1:										//Perform a transaction
					viewUsers(login.getUserID());
					break;
				case 2:										//Create a bank account
					viewAdmins(login.getUserID());
					break;
				case 3:										//logout, return to login screen
					return;
				default:									//Invalid choice
					System.out.println("Invalid Option");
					break;
			}//outermost switch statement
		}//while loop
	}
	
	public static void viewPendingList() {
		Scanner input = new Scanner(System.in);
		char choice;
		ArrayList<UserAccount> users = new ArrayList<UserAccount>();
		try {
			users = uadi.getPendingUsers();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (users.size() != 0) {
			for (UserAccount u: users) {
				System.out.print("\n" + u + "\nApprove? (y/n)\n> ");
				choice = input.nextLine().charAt(0);
				if (choice == 'Y' || choice == 'y') {
					try {
						uadi.changeApproval(u.getUserID(), 1);
					} catch (SQLException e) {
						e.printStackTrace();
					}
//					logger.info(tempCustomer.getUserName() + "'s application was approved.");
				}
				else {
					try {
						uadi.removeUser(u.getUserID());
						ladi.removeLoginAccount(u.getUserID());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
//					logger.info(tempCustomer.getUserName() + "'s application was denied.");
				}
			}
		}
		System.out.println("There are no more applications in queue");
	}
	
	public static void viewUsers(int userID) {
		ArrayList<UserAccount> users = new ArrayList<UserAccount>();
		Scanner in = new Scanner(System.in);
		try {
			users = uadi.getAllRegularUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("List of Normal Users\nUser ID\t\tFull Name");
		for (UserAccount u: users) {
			System.out.println(u.getUserID() + "\t\t" + u.getFirstName() + " " + u.getLastName());
		}
		System.out.println("Enter the User ID of the account you wish to access: ");
		int choice = in.nextInt();
		boolean found = false;
		UserAccount user = null;
		for (UserAccount a: users) {
			if (a.getUserID() == choice) {
				user = a;
				found = true;
				break;
			}
		}
		if (found) {
			try {
				
				UserMenu.start(ladi.getLogin(choice), user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
			System.out.println("Invalid choice");
	}
	
	public static void viewAdmins(int userID) {
		ArrayList<UserAccount> users = new ArrayList<UserAccount>();
		Scanner in = new Scanner(System.in);
		try {
			users = uadi.getAllAdmins();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("List of Admins\nUser ID\t\tFull Name");
		for (UserAccount u: users) {
			System.out.println(u.getUserID() + "\t\t" + u.getFirstName() + " " + u.getLastName());
		}
		System.out.println("Enter the User ID of the account you wish to access: ");
		int choice = in.nextInt();
		boolean found = false;
		UserAccount user = null;
		LoginAccount login = null;
		for (UserAccount a: users) {
			if (a.getUserID() == choice) {
				user = a;
				found = true;
				break;
			}
		}
		try {
			login = ladi.getLogin(choice);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (found) {
			UserMenu.editUser(login, user);
		}
		else
			System.out.println("Invalid choice");
	}
}

















