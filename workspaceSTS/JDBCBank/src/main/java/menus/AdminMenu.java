package menus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import beans.BankAccount;
import beans.LoginAccount;
import beans.UserAccount;
import daoImplementation.LoginAccountDaoImpl;
import daoImplementation.UserAccountDaoImpl;

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
				System.out.println("\n" + u + "\nApprove? (y/n)\n> ");
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
		
		System.out.println("List of Normal Users\n\tUser ID\t\tFull Name");
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
				
				UserMenu.start(ladi.getLogin(userID), user);
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
		
		System.out.println("List of Admins\n\tUser ID\t\tFull Name");
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
			login = ladi.getLogin(userID);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (found) {
			editAdmin(login, user);
		}
		else
			System.out.println("Invalid choice");
	}
	
	public static void editAdmin(LoginAccount login, UserAccount user) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.print("\nWhich field would you like to change?"
				+ "\n(0) - First Name"		//DONE
				+ "\n(1) - Last Name"	//DONE
				+ "\n(2) - Street Address"	//DONE
				+ "\n(3) - E-mail"	//DONE
				+ "\n(4) - Phone #"					//DONE
				+ "\n(5) - Username"
				+ "\n(6) - Password"
				+ "\n(7) - Cancel"
				+ "\n> ");
			int option = input.nextInt();
			try {
				switch (option) {
					case 0:
						System.out.print("First Name: ");
						user.setFirstName(input.nextLine());
						uadi.changeFirstName(user.getUserID(), user.getFirstName());
						break;
					case 1:
						System.out.print("Last Name: ");
						user.setLastName(input.nextLine());
						uadi.changeLastName(user.getUserID(), user.getLastName());
						break;
					case 2:
						System.out.print("Street Address: ");
						user.setStreetAddress(input.nextLine());
						uadi.changeStreetAddress(user.getUserID(), user.getStreetAddress());
						break;
					case 3:
						System.out.print("E-mail: ");
						user.setEmail(input.nextLine());
						uadi.changeEmail(user.getUserID(), user.getEmail());
						break;
					case 4:
						System.out.print("Phone #: ");
						user.setPhoneNum(input.nextLine());
						uadi.changePhoneNum(user.getUserID(), user.getPhoneNum());
						break;
					case 5:
						boolean uniqueLogin = false;
						String username = "";
						while (!uniqueLogin || username.equals("")) {
							System.out.print("Username: ");
							username = input.nextLine();
							try {
								uniqueLogin = ladi.verifyUniqueName(username);
							} catch (SQLException e) {
								e.printStackTrace();
							}
							if (username.equals(""))
								System.out.println("You must enter a username.");
							else if (!uniqueLogin)
								System.out.println("Sorry, that username is already taken.");
							
						}
						ladi.changeUsername(login.getUserName(), username);
						login.setUserName(username);
						break;
					case 6:
						System.out.print("Password: ");
						login.setPassword(input.nextLine());
						ladi.changePassword(login.getUserName(), login.getPassword());
						break;
					case 7:
						return;
					default:
						System.out.println("Invalid Option");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

















