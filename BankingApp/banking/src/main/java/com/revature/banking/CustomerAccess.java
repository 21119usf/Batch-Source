package com.revature.banking;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.beans.Account;
import com.revature.daoimpl.AccountDaoImpl;
import com.revature.util.ExceptionCatcher;

public class CustomerAccess {
	//as before initializing all of the files from the IO
	private static Logger logger = LogManager.getLogger(CustomerAccess.class);
	
	
	
	public static void custDash(int userID) {
		ExceptionCatcher ec = new ExceptionCatcher();
		Scanner input = new Scanner(System.in);
		
		//since UserID is the primary key for the customer and user list, we check against the two to ensure we're accessing the right account
			
				//while loop
				boolean loggedout = false;
				while (!loggedout) {
					AccountDaoImpl adi = new AccountDaoImpl();
					try {
						List<Account> accounts = adi.getAccountList(userID);
						int numberOfAccounts = accounts.size();
						System.out.println("You currently have " + numberOfAccounts + " accounts.");
//						for (Account elem : accounts) {
//							System.out.println(elem);
//						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					List<Account> accounts = null;
					try {
						accounts = adi.getAccountList(userID);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int numberOfAccounts = accounts.size();
					if (numberOfAccounts == 0) {
						System.out.println("UserID = " + userID);
						System.out.println("You do not currently have an account! Would you like to create one? (Y or N)");
						String optionStr = input.nextLine();
						if (optionStr.equals("Y")) {
							System.out.println("How much would you like to deposit in this account?");
							optionStr = input.nextLine();
							Double startBal = Double.parseDouble(optionStr);
							Double rounded = (double) Math.round(startBal*100d)/100d;
							System.out.println("You have deposited " + rounded);
							try {
								adi.createAccount(startBal, userID);
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						else {
							break;
						}
					}
					else {
						System.out.println("What would you like to do?");
					for (int i = 0;i<numberOfAccounts;i++) {
					
					try {
						System.out.println(	(i+1) + " - View Account " + adi.pullAccountID(userID).get(i));
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					}
					System.out.println((numberOfAccounts+1) + " - Create Account");
					//System.out.println((numberOfAccounts+2) + " - Edit Personal Information");	
					System.out.println( "0 - Log Out\n"
							+ "=================================================================");
					String optionStr = input.nextLine();

					Integer option =ec.parseIntCheck(optionStr);
					if (option==0) {
						loggedout=true;
						break;
					}
					else if(option<=numberOfAccounts) {
						for (int i = 0;i<numberOfAccounts;i++) {
							if(option==(i+1)) {
								try {
									int accID = adi.pullAccountID(userID).get(i);
									accountActions(accID,userID);
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
					else if (option==(numberOfAccounts+1)) {
						System.out.println("Are you sure you would like to create a new Account? (Y or N)");
						optionStr = input.nextLine();
						if (optionStr.equals("Y")) {
						System.out.println("How much would you like to deposit in this new account?");
						optionStr = input.nextLine();

						Double startBal =ec.parseDoubCheck(optionStr);
						Double rounded = (double) Math.round(startBal*100d)/100d;
						System.out.println("You have deposited " + rounded);
						System.out.println("=================================================================");
						try {
							adi.createAccount(startBal, userID);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							}
						}
					}
				}
			}
				}
		public static void accountActions(int accountID, int userID) {
			ExceptionCatcher ec = new ExceptionCatcher();
			AccountDaoImpl adi = new AccountDaoImpl();
		boolean loggedout=false;
			Scanner input = new Scanner(System.in);
			while (!loggedout) {
			System.out.println( "======================Accessing account " + accountID + "======================");
			System.out.println( "What would you like to do?");
			System.out.println(	"1 - View Balance\n"
					+ 			"2 - Withdraw money\n"
					+ 			"3 - Deposit money\n"
					+ 			"4 - Transfer funds\n"
					+ 			"5 - Delete Account\n"
					+ 			"0 - Go Back\n"
					+ 			"=================================================================");
			
			input = new Scanner(System.in);
			String optionStr = input.nextLine();
			Integer option =ec.parseIntCheck(optionStr);
			
			switch (option) {
			case 1:
				Double accountBalance;
				try {
					accountBalance = adi.pullAccountBalance(accountID);
					//grabbing balance info from the customers file
					System.out.println("=================================================================\n");
					System.out.println("The balance in account " + accountID + " is $" + accountBalance);
					System.out.println("\n=================================================================");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case 2:
				System.out.println("How much are you intending to withdraw?");
				input = new Scanner(System.in);
				String withdrawStr = input.nextLine();
				Double withdraw =ec.parseDoubCheck(withdrawStr);
				if (withdraw>0) {
				try {
					adi.withdrawFunds(accountID, withdraw, userID);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				else {
					System.out.println("Please enter a valid number");
				}
				break;
			case 3:
				System.out.println("How much are you intending to deposit?");
				input = new Scanner(System.in);
				String depositStr = input.nextLine();

				Double deposit =ec.parseDoubCheck(depositStr);
				if (deposit>0) {
				try {
					adi.depositFunds(accountID, deposit, userID);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				else {
					System.out.println("Please enter a valid number");
				}
				break;
			case 4:
				System.out.println("How much are you intending to transfer?");
				input = new Scanner(System.in);
				String transferStr = input.nextLine();

				Double transfer =ec.parseDoubCheck(transferStr);
				Double rounded = (double) Math.round(transfer*100d)/100d;
				transfer = rounded;
				if (transfer>0) {
					System.out.println("Enter the account number of the account you wish to transfer $" + transfer + " to:");
					String targAccStr = input.nextLine();
					Integer targID = ec.parseIntCheck(targAccStr);
				try {
					adi.transferFunds(accountID,targID, transfer, userID);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				else {
					System.out.println("Please enter a valid number");
				}
				break;
			case 5:
				System.out.println("Deleting an account CANNOT be undone! Are you sure you want to delete account " + accountID + "? (Y or N)");
				input = new Scanner(System.in);
				String decision = input.nextLine();
				if (decision.equals("Y")) {
					try {
						adi.deleteAccount(accountID, userID);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					loggedout = true;
				}
				break;
			case 0:
				loggedout=true;
				break;
			
		}
			}	
}
}
