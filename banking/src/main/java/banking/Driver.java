package banking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//Import log4j classes.
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Driver {
	
	private static final Logger logger = LogManager.getLogger(Driver.class);
	 
	private final static Set<String> USERTYPES = Collections.unmodifiableSet(
			new	HashSet<String>(Arrays.asList("Customer","Employee","Admin","New User")));
	
	public static void main(String[] args) {
		// Initialize and welcome the user
		System.out.println("Welcome to Good Banker, home of the Good Banker, May I take your order?!");
		logger.trace("Entering Application");
		Scanner in = new Scanner(System.in);
		
		// Determine user type
		String usertype;
		do {System.out.println("What type of user are you?");
			System.out.print("Customer, Employee, Admin, or New User: ");
			usertype = in.nextLine();
		} while (!USERTYPES.contains(usertype));
		
		// If new user, initiate new user
		if(usertype.contains("New")) {
			usertype = User.createID(in);
		}
		System.out.println("Welcome " + usertype + "!, Would you care to log in?");
		boolean verified = false;
		String username = "", pw = "";
		while (!verified) {
			System.out.print("Username: ");
			username = in.nextLine();
			System.out.print("Password: ");
			pw = in.nextLine();
			verified = User.login(username, pw, usertype);
		}
		String options = "";
		ArrayList<Account> allAccounts = Account.populateAccounts();
		char c = usertype.charAt(0);
		switch (c) {
		case 'C':
			Customer C = new Customer(username);
			ArrayList<Account> myAccounts = new ArrayList<Account>();
			for(Account a: allAccounts) {
				if (a.getCustomers().contains(username)) {
					myAccounts.add(a);
				}
			}
			options = "Open Account, List Accounts, Withdraw, Deposit, Transfer, or Quit";
			String console = "";
			System.out.println("Welcome " + username + "! What can I help you with?");
			// for the rest of the program
			do {
				System.out.println(options);
				console = in.nextLine();
				if (console.contains("Open Account")) {
					System.out.println("Fantastic! How much would you like to begin with?");
					double initialDeposit = in.nextDouble();
					in.nextLine();
					String jointusers = "";
					String fu = ";";
					while (fu.length() > 0) {
					System.out.print("If there is another customer you wish to grant access"
							+ " to this account please input their name now."
							+ " \nIf not, just press enter: ");
							fu = in.nextLine();
							if (fu.length() > 0) {
								jointusers = jointusers + ";" + fu;
							}
					}
					Account newAccount = C.openAccount(initialDeposit, jointusers);
					myAccounts.add(newAccount);
					allAccounts.add(newAccount);
				} else if (console.contains("List Accounts")) {
					for (Account a: myAccounts) {
						a.display();
					}
				} else if (console.contains("Withdraw")) {
					for (Account a: myAccounts) {
						a.display();
					}
					System.out.print("Please enter the account # you wish to withdraw from: ");
					Integer ID = Integer.parseInt(in.nextLine());
					for(Account a: myAccounts) {
						if (a.getID().equals(ID)) {
							if (a.isActive()) {
								System.out.print("\nHow much would you like to withdraw?: ");
								double withdrawal = Double.parseDouble(in.nextLine());
								a.withdraw(C, withdrawal);
								System.out.println("Here is your $" + withdrawal + ", " + username);
							} else {
								System.out.println("Sorry account has yet to be activated, try again later");
							}
						}
					}
					
				} else if (console.contains("Deposit")) {
					for (Account a: myAccounts) {
						a.display();
					}
					System.out.print("Please enter the account # you wish to Deposit into: ");
					Integer ID = Integer.parseInt(in.nextLine());
					for(Account a: myAccounts) {
						if (a.getID().equals(ID)) {
							if (a.isActive()) {
								System.out.print("\nHow much would you like to deposit?: ");
								double deposit = Double.parseDouble(in.nextLine());
								a.withdraw(C, deposit);
								System.out.println("Thank for your $" + deposit + ", " + username +
										"\nYour new account Balance is: $" + a.getBalance());
							} else {
								System.out.println("Sorry account has yet to be activated, try again later");
							}
						}
					}
				} else if (console.contains("Transfer")) {
					for (Account a: myAccounts) {
						a.display();
					}
					System.out.print("Please enter the account # you wish to transfer from: ");
					Integer fromID = Integer.parseInt(in.nextLine());
					System.out.print("Please enter the account # you wish to transfer to: ");
					Integer toID = Integer.parseInt(in.nextLine());
					for(Account a: myAccounts) {
						if (a.getID().equals(fromID)) {
							if (a.isActive()) {
								System.out.print("\nHow much would you like to transfer?: ");
								double deposit = Double.parseDouble(in.nextLine());
								for(Account b: allAccounts) {
									if (b.getID().equals(toID)) {
										if (b.isActive()) {
											a.transfer(C, b, deposit);
										}
									} else {
										System.out.println("Sorry account has yet to be activated, try again later");
									}
								}
							} else {
								System.out.println("Sorry account has yet to be activated, try again later");
							}
						}
					}
				}
			} while (!console.contains("Quit"));
			System.out.println("Have a nice day!");
			break;
			
		case 'E':
			Employee E = new Employee(username);
			options = "Approve Account, List Accounts, Withdraw, Deposit, or Transfer";
			do {
				System.out.println(options);
				console = in.nextLine();
				if (console.contains("Approve Account")) {
					System.out.print("Please enter the account # you wish to approve: ");
					Integer ID = Integer.parseInt(in.nextLine());
					for (Account a: allAccounts) {
						if (a.getID().equals(ID)) {
							E.approve(a);
						}
					}
				} else if (console.contains("List Accounts")) {
					for (Account a: allAccounts) {
						a.display();
					}
				} else if (console.contains("Withdraw")) {
					System.out.print("Please enter the account # you wish to withdraw from: ");
					Integer ID = Integer.parseInt(in.nextLine());
					for(Account a: allAccounts) {
						if (a.getID().equals(ID)) {
							if (a.isActive()) {
								System.out.print("\nHow much would you like to withdraw?: ");
								double withdrawal = Double.parseDouble(in.nextLine());
								a.withdraw(E, withdrawal);
								System.out.println("Here is your $" + withdrawal + ", " + username +
										"\nYour new account Balance is: $" + a.getBalance());
							} else {
								System.out.print("Sorry account has yet to be activated, would you like to activate it? Y/N: ");
								if(in.nextLine().contains("Y")) {
									E.approve(a);
									System.out.print("\nHow much would you like to withdraw?: ");
									double withdrawal = Double.parseDouble(in.nextLine());
									a.withdraw(E, withdrawal);
									System.out.println("Here is your $" + withdrawal + ", " + username +
											"\nYour new account Balance is: $" + a.getBalance());
								} else {
									System.out.println("I can't withdraw from an inactive account");
								}
							}
						}
					}
					
				} else if (console.contains("Deposit")) {
					System.out.print("Please enter the account # you wish to Deposit into: ");
					Integer ID = Integer.parseInt(in.nextLine());
					for(Account a: allAccounts) {
						if (a.getID().equals(ID)) {
							if (a.isActive()) {
								System.out.print("\nHow much would you like to deposit?: ");
								double deposit = Double.parseDouble(in.nextLine());
								a.withdraw(E, deposit);
								System.out.println("Thank for your $" + deposit + ", " + username +
										"\nYour new account Balance is: $" + a.getBalance());
							} else {
								System.out.print("Sorry account has yet to be activated, would you like to activate it? Y/N: ");
								if(in.nextLine().contains("Y")) {
									E.approve(a);
									System.out.print("\nHow much would you like to deposit?: ");
									double deposit = Double.parseDouble(in.nextLine());
									a.deposit(E, deposit);
									System.out.println("Thank for your $" + deposit + ", " + username +
											"\nYour new account Balance is: $" + a.getBalance());
								} else {
									System.out.println("I can't deposit to an inactive account");
								}
							}
						}
					}
				} else if (console.contains("Transfer")) {
					System.out.print("Please enter the account # you wish to transfer from: ");
					Integer fromID = Integer.parseInt(in.nextLine());
					System.out.print("Please enter the account # you wish to transfer to: ");
					Integer toID = Integer.parseInt(in.nextLine());
					for(Account a: allAccounts) {
						if (a.getID().equals(fromID)) {
							if (a.isActive()) {
								System.out.print("\nHow much would you like to transfer?: ");
								double deposit = Double.parseDouble(in.nextLine());
								for(Account b: allAccounts) {
									if (b.getID().equals(toID)) {
										if (b.isActive()) {
											a.transfer(E, b, deposit);
										}
									} else {
										System.out.println("Sorry account has yet to be activated.");
									}
								}
							} else {
								System.out.println("Sorry account has yet to be activated.");
							}
						}
					}
				}
			} while (!console.contains("Quit"));
			break;
			
		case 'A':
			Admin A = new Admin(username);
			options = "Approve Account, Edit Account, List Accounts, Withdraw, Deposit, or Transfer";
			do {
				System.out.println(options);
				console = in.nextLine();
				if (console.contains("Approve Account")) {
					System.out.print("Please enter the account # you wish to approve: ");
					Integer ID = Integer.parseInt(in.nextLine());
					for (Account a: allAccounts) {
						if (a.getID().equals(ID)) {
							A.approve(a);
						}
					}
				} else if (console.contains("Edit Account")) {
					System.out.print("Please enter the account # you wish to edit: ");
					Integer ID = Integer.parseInt(in.nextLine());
					for (Account a: allAccounts) {
						if (a.getID().equals(ID)) {
							a.display();
							System.out.println("What do you want to change?");
							String fu = in.nextLine();
							if (fu.contains("ID")) {
								System.out.println("What do you want the ID to be");
								a.setID(Integer.parseInt(in.nextLine()));
							} else if (fu.contains("Balance") || fu.contains("balance")) {
								System.out.println("What do you want the Balance to be");
								a.setBalance(Double.parseDouble(in.nextLine()));
							} else if (fu.contains("Activ")) {
								System.out.println("Do you want the account to be active? (Y/N)");
								if (in.nextLine().contains("Y")) {
									A.approve(a);
								} else {
									A.deny(a);
								}
							} else if (fu.contains("Customer")) {
								System.out.println("What Customers do you want on the Account?");
								a.setCustomers(in.nextLine());
								//This can fuck things up, but what are admins for?
							}
						}
					}
				} else if (console.contains("List Accounts")) {
					for (Account a: allAccounts) {
						a.display();
					}
				} else if (console.contains("Withdraw")) {
					System.out.print("Please enter the account # you wish to withdraw from: ");
					Integer ID = Integer.parseInt(in.nextLine());
					for(Account a: allAccounts) {
						if (a.getID().equals(ID)) {
							if (a.isActive()) {
								System.out.print("\nHow much would you like to withdraw?: ");
								double withdrawal = Double.parseDouble(in.nextLine());
								a.withdraw(A, withdrawal);
								System.out.println("Here is your $" + withdrawal + ", " + username +
										"\nYour new account Balance is: $" + a.getBalance());
							} else {
								System.out.print("Sorry account has yet to be activated, would you like to activate it? Y/N: ");
								if(in.nextLine().contains("Y")) {
									A.approve(a);
									System.out.print("\nHow much would you like to withdraw?: ");
									double withdrawal = Double.parseDouble(in.nextLine());
									a.withdraw(A, withdrawal);
									System.out.println("Here is your $" + withdrawal + ", " + username +
											"\nYour new account Balance is: $" + a.getBalance());
								} else {
									System.out.println("I can't withdraw from an inactive account");
								}
							}
						}
					}
					
				} else if (console.contains("Deposit")) {
					System.out.print("Please enter the account # you wish to Deposit into: ");
					Integer ID = Integer.parseInt(in.nextLine());
					for(Account a: allAccounts) {
						if (a.getID().equals(ID)) {
							if (a.isActive()) {
								System.out.print("\nHow much would you like to deposit?: ");
								double deposit = Double.parseDouble(in.nextLine());
								a.withdraw(A, deposit);
								System.out.println("Thank for your $" + deposit + ", " + username +
										"\nYour new account Balance is: $" + a.getBalance());
							} else {
								System.out.print("Sorry account has yet to be activated, would you like to activate it? Y/N: ");
								if(in.nextLine().contains("Y")) {
									A.approve(a);
									System.out.print("\nHow much would you like to deposit?: ");
									double deposit = Double.parseDouble(in.nextLine());
									a.deposit(A, deposit);
									System.out.println("Thank for your $" + deposit + ", " + username +
											"\nYour new account Balance is: $" + a.getBalance());
								} else {
									System.out.println("I can't deposit to an inactive account");
								}
							}
						}
					}
				} else if (console.contains("Transfer")) {
					System.out.print("Please enter the account # you wish to transfer from: ");
					Integer fromID = Integer.parseInt(in.nextLine());
					System.out.print("Please enter the account # you wish to transfer to: ");
					Integer toID = Integer.parseInt(in.nextLine());
					for(Account a: allAccounts) {
						if (a.getID().equals(fromID)) {
							if (a.isActive()) {
								System.out.print("\nHow much would you like to transfer?: ");
								double deposit = Double.parseDouble(in.nextLine());
								for(Account b: allAccounts) {
									if (b.getID().equals(toID)) {
										if (b.isActive()) {
											a.transfer(A, b, deposit);
										}
									} else {
										System.out.println("Sorry account has yet to be activated.");
									}
								}
							} else {
								System.out.println("Sorry account has yet to be activated.");
							}
						}
					}
				}
			} while (!console.contains("Quit"));
			break;
			
		default:
			System.out.println("something went wrong, sorry");
		}
		// Cleanly Close the application
		logger.trace("Closing Application");
		Account.saveAccounts(allAccounts);
		in.close();	
		}
}
