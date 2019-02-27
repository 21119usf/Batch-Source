package menus;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import beans.BankAccount;
import beans.LoginAccount;
import beans.UserAccount;
import daoImplementation.BankAccountDaoImpl;
import daoImplementation.LoginAccountDaoImpl;
import daoImplementation.UserAccountDaoImpl;

public class UserMenu {
	public static BankAccountDaoImpl badi = new BankAccountDaoImpl();
	public static UserAccountDaoImpl uadi = new UserAccountDaoImpl();
	public static LoginAccountDaoImpl ladi = new LoginAccountDaoImpl();

	public static void start(LoginAccount login, UserAccount user) {
		Scanner input = new Scanner(System.in);
		int option;
	
		while (true) {
			System.out.print("\nWelcome " + login.getUserName() + "."
					+ "\nWhat would you like to do today?"
					+ "\n(0) - View my information"		//DONE
					+ "\n(1) - Perform a transaction"	//DONE
					+ "\n(2) - Create a bank account"	//DONE
					+ "\n(3) - Close a bank account"	//DONE
					+ "\n(4) - Edit my personal details"//DONE
					+ "\n(5) - Logout"
					+ "\n> ");
			option = input.nextInt();
			switch (option) {
				case 0:									//View information pertaining to me(Customer)
					printUserInfo(login, user);
					break;	
				case 1:										//Perform a transaction
					initiateTransaction(login.getUserID());
					break;
				case 2:										//Create a bank account
					createBankAccount(login.getUserID());
					break;
				case 3:										//Close a bank account
					closeBankAccount(login.getUserID());
					break;
				case 4:
					editUser(login, user);
					break;
				case 5:										//logout, return to login screen
					return;
				default:									//Invalid choice
					System.out.println("Invalid Option");
					break;
			}//outermost switch statement
		}//while loop
	}
	
	public static void printUserInfo(LoginAccount login, UserAccount user) {
		ArrayList<BankAccount> banks = new ArrayList<BankAccount>();
		try {
			banks = badi.getBankAccountsOfUser(login.getUserID());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("User ID: " + user.getUserID()
						  +"\nFirst Name: " + user.getFirstName()
						  +"\nLast Name: " + user.getLastName()
						  +"\nStreet Address: " + user.getStreetAddress()
						  +"\nE-mail: " + user.getEmail()
						  +"\nPhone #: " + user.getPhoneNum()
						  +"\nUsername: " + login.getUserName());
		System.out.println("\nBank ID\t\tBalance\t\tType");
		if (banks.size() == 0) {
			System.out.println("No active Bank Accounts.\n");
			return;
		}
		for (BankAccount b: banks)
			System.out.println(b.getBankAccountID() + "\t\t$" + b.getBalance() + "\t\t"
								+ b.getAccountType());
		System.out.println();
	}
	
	public static void createBankAccount(int userID) {
		Scanner in = new Scanner(System.in);
		System.out.print("Which type of account would you like to make?"
						  +"\n(0) - Savings"
						  +"\n(1) - Checking"
						  +"\n(2) - Cancel"
						  +"\n> ");
		int choice = in.nextInt();
		try {
			switch (choice) {
				case 0:
					badi.createBankAccount(userID, 0, "Savings");
					System.out.println("Savings account created.");
					break;
				case 1:
					badi.createBankAccount(userID, 0, "Checking");
					System.out.println("Checking account created.");
					break;
				default:
					break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void closeBankAccount(int userID) {
		ArrayList<BankAccount> banks = new ArrayList<BankAccount>();
		try {
			banks = badi.getBankAccountsOfUser(userID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (banks.size() == 0) {
			System.out.println("No active Bank Accounts to close.\n");
			return;
		}
		Scanner in = new Scanner(System.in);
		System.out.println("\nBank ID\t\tBalance\t\tType");
		for (BankAccount b: banks)
			System.out.println(b.getBankAccountID() + "\t\t$" + b.getBalance() + "\t\t"
								+ b.getAccountType());
		System.out.print("\nEnter the Bank ID of the account you wish to close: ");
		int choice = in.nextInt();
		boolean found = false;
		double currBalance = 0;
		for (BankAccount b: banks) {
			if (b.getBankAccountID() == choice) {
				currBalance = b.getBalance();
				found = true;
				break;
			}
		}
		if (found) {
			try {
				if (currBalance != 0)
					System.out.println("Only an account with a balance of $0.00 can be removed.");
				else {
					badi.removeBankAccount(choice);
					System.out.println("Bank account with the ID " + choice + " was removed.");	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
			System.out.println("Invalid choice");
	}
	
	public static void initiateTransaction(int userID) {
		ArrayList<BankAccount> banks = new ArrayList<BankAccount>();
		try {
			banks = badi.getBankAccountsOfUser(userID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (banks.size() == 0) {
			System.out.println("You do not have any accounts to perform a transaction on.");
			return;
		}
		Scanner input = new Scanner(System.in);
		int option;
		while (true) {
			System.out.print("\nWhat type of transaction would you like to perform?"
						+ "\n(0) - Deposit"
						+ "\n(1) - Withdrawal"
						+ "\n(2) - Transfer"
						+ "\n(3) - Cancel"
						+ "\n> ");
			option = input.nextInt();
			System.out.println("\nBank ID\t\tBalance\t\tType");
			for (BankAccount b: banks)
				System.out.println(b.getBankAccountID() + "\t\t$" + b.getBalance() + "\t\t"
									+ b.getAccountType());
			switch (option) {
				case 0:
					deposit(banks);
					break;
				case 1:
					withdraw(banks);
					break;
				case 2:
					transfer(banks);
					break;
				default:
					return;
			}
		}
		
	}
	
	public static void deposit(ArrayList<BankAccount> banks) {
		Scanner in = new Scanner(System.in);
		double amount = 0;
		System.out.print("Enter the Bank ID of the account you wish to deposit into: ");
		int choice = in.nextInt();
		boolean found = false;
		double currBalance = 0;
		for (BankAccount b: banks) {
			if (b.getBankAccountID() == choice) {
				currBalance = b.getBalance();
				found = true;
				break;
			}
		}
		in.nextLine();
		if (found) {
			try {
				System.out.print("How much would you like to deposit?: $");
				amount = in.nextDouble();
				if (amount < 0)
					System.out.println("Cannot deposit a negative amount.");
				else {
					badi.changeBalance(choice, currBalance + amount);
					System.out.println("New balance for Bank Account " + choice
							+ " is $" + (currBalance + amount));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
				
		}
		else
			System.out.println("Invalid choice");
	}
	
	public static void withdraw(ArrayList<BankAccount> banks) {
		Scanner in = new Scanner(System.in);
		double amount = 0;
		System.out.print("Enter the Bank ID of the account you wish to withdraw from: ");
		int choice = in.nextInt();
		boolean found = false;
		double currBalance = 0;
		for (BankAccount b: banks) {
			if (b.getBankAccountID() == choice) {
				currBalance = b.getBalance();
				found = true;
				break;
			}
		}
		in.nextLine();
		if (found) {
			try {
				System.out.print("How much would you like to withdraw?: $");
				amount = in.nextDouble();
				if (amount < 0)
					System.out.println("Cannot withdraw a negative amount.");
				else if (amount > currBalance)
					System.out.println("Insufficient Funds.");
				else {
					badi.changeBalance(choice, currBalance - amount);
					System.out.println("New balance for Bank Account " + choice
							+ " is $" + (currBalance - amount));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else
			System.out.println("Invalid choice");
	}

	public static void transfer(ArrayList<BankAccount> banks) {
		Scanner in = new Scanner(System.in);
		double amount = 0;
		System.out.print("Enter the Bank ID of the account you wish to transfer from: ");
		int choice1 = in.nextInt();
		System.out.print("Enter the Bank ID of the account you wish to transfer to: ");
		int choice2 = in.nextInt();
		boolean found1 = false;
		boolean found2 = false;
		double currBalance1 = 0;
		double currBalance2 = 0;
		for (BankAccount b: banks) {
			if (b.getBankAccountID() == choice1) {
				currBalance1 = b.getBalance();
				found1 = true;
			}
			if (b.getBankAccountID() == choice2) {
				currBalance2 = b.getBalance();
				found2 = true;
			}
		}
		in.nextLine();
		if (found1 && found2) {
			try {
				System.out.print("How much would you like to transfer?: $");
				amount = in.nextDouble();
				if (amount < 0)
					System.out.println("Cannot transfer a negative amount.");
				else if (amount > currBalance1)
					System.out.println("Insufficient Funds.");
				else {
					badi.changeBalance(choice1, currBalance1 - amount);
					badi.changeBalance(choice2, currBalance2 + amount);
					System.out.println("New balance for Bank Account " + choice1
							+ " is $" + (currBalance1 - amount)
							+ "\nNew balance for Bank Account " + choice2
							+ " is $" + (currBalance2 + amount));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		else
			System.out.println("Invalid choices");
	}
	
	public static void editUser(LoginAccount login, UserAccount user) {
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
