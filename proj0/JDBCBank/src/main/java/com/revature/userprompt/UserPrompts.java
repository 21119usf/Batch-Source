package com.revature.userprompt;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.revature.beans.Customer;
import com.revature.driver.BankAppMain;
import com.revature.implementers.AdminImpl;
import com.revature.implementers.CustomerImpl;
import com.revature.implementers.CustomerLookUp;
import com.revature.implementers.EmployeeImpl;
import com.revature.logs.Logging;

public class UserPrompts{
	
	static final Scanner myScanner = new Scanner(System.in);
	List<CustomerLookUp> accts = new ArrayList<CustomerLookUp>();
	static String[] credentials = new String[2];
	private double amount;
	int choice;
	int acctID;
	int userID;
	int rtng_number;
	long acct_number;
	String choosing = "yes";
	
	public UserPrompts() {
	}
	
	public String[] logInPrompt() {
		System.out.println("Enter username: ");
		String usrAtmp = myScanner.nextLine().trim();
		System.out.println("Enter password: ");
		String passAtmp = myScanner.nextLine().trim();
		credentials[0]=(usrAtmp);
		credentials[1]=(passAtmp);
		System.out.println("\n>>>>> Hang tight while we search the cloud for you ........");
		return credentials;
	}
	public void AdminPrompt(int userID) {
		while(choosing.equalsIgnoreCase("yes")) {
		AdminImpl adImpl = new AdminImpl();
			System.out.println("------ CHOOSE AN OPTION ------");
			System.out.println("Force Customer Deposit 	-> Enter 1: ");
			System.out.println("Force Customer Withrawal	-> Enter 2: ");
			System.out.println("Transfer Customer Account	-> Enter 3: ");
			System.out.println("Approve Account Request 	-> Enter 4: ");
			System.out.println("Deny Account Request 	 	-> Enter 5: ");
			System.out.println("Cancel Account		 	-> Enter 6: ");
			int choice = myScanner.nextInt();
			myScanner.nextLine();

		switch(choice) {
			
			case 1:
				System.out.println("Enter the Account ID# you would like to perform a deposit for.");
				try {
					adImpl.viewAllAccountIDs();
					int lookUpID = myScanner.nextInt();
					myScanner.nextLine();
					System.out.println("Great... How much would you like to deposit?");
					amount = myScanner.nextDouble();
					myScanner.nextLine();
					System.out.println("Depoist Successful...\nAmount Deposited -> $"+amount+ "\nNew Balance -> $" + adImpl.deposit(lookUpID, amount));
					Logging.LOGGER.info("Admin made customer deposit => Admin ID:" + userID + "$"+amount);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Would you like to continue transactions? Type \"yes\" or \"no\"");
				choosing = myScanner.nextLine();
				break;
			case 2:
				try {
					System.out.println("Enter the >>>> ACCOUNT ID <<<< you would like to perform a withdrawal for.");
					adImpl.viewAllAccountIDs();
					int lookUpID = myScanner.nextInt();
					myScanner.nextLine();
					System.out.println("Great... How much would you like to deposit?");
					amount = myScanner.nextDouble();
					myScanner.nextLine();
					System.out.println("Depoist Successful...\nAmount Deposited -> $"+amount+ "\nNew Balance -> $" + adImpl.withdraw(lookUpID, amount));
					Logging.LOGGER.info("Admin made customer withdraw => Admin ID:" + userID + "$"+amount);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					System.out.println("Enter the >>>> ACCOUNT ID <<<< you would like to perform a transfer for.");
					adImpl.viewAllAccountIDs();
					int lookUpID = myScanner.nextInt();
					myScanner.nextLine();
					System.out.println("Great... to which account would you like to trasnfer to?");
					amount = myScanner.nextDouble();
					myScanner.nextLine();
					System.out.println("Depoist Successful...\nAmount Deposited -> $"+amount+ "\nNew Balance -> $" + adImpl.deposit(lookUpID, amount));
					Logging.LOGGER.info("Admin made customer transfer => Admin ID:" + userID + "$"+amount);
				} catch (SQLException e) {
					e.printStackTrace();
				}

			case 4:
				try {
					System.out.println("Enter the >>>> USER ID <<<< of the customer who's account you would like to approve.\n");
					adImpl.viewAPendingAccounts();
					userID = myScanner.nextInt();
					myScanner.nextLine();
					adImpl.approveAccount(userID);
					Logging.LOGGER.info("Admin approved customer account => Admin ID:" + userID);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			// deny customer request
			case 5:
				try {
					System.out.println("Enter the >>>> USER ID <<<< of the customer who's accountyou would like to deny.\n");
					adImpl.viewAPendingAccounts();
					userID = myScanner.nextInt();
					myScanner.nextLine();
					adImpl.denyAccount(userID);
					Logging.LOGGER.info("Admin denied customer account => Admin ID:" + userID);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			// cancel customer account
			case 6:
			try {
				System.out.println("Enter the >>>> USER ID <<<< of the customer who's account you would like to cancel.\n");
				adImpl.viewAllAccountIDs();
				int custUserID = myScanner.nextInt();
				myScanner.nextLine();
				System.out.println("Now enter their >>>> ACCOUNT ID <<<<");
				acctID = myScanner.nextInt();
				myScanner.nextLine();
				adImpl.cancelAccount(custUserID, acctID);
				Logging.LOGGER.info("Admin canceled customer account => Admin ID:" + userID);
				System.out.println();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
			}
		}
		System.out.println("Back to Main Menu => Enter 1");
		System.out.println("Logout 		 => Enter 2");
		int off = myScanner.nextInt();
		if(off==1) {
			try {
				BankAppMain.main(null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {System.exit(0);}
	}
		
		public void EmployeePrompt(int userID) {
			EmployeeImpl emImpl = new EmployeeImpl();
			CustomerImpl cImpl = new CustomerImpl();
			List<CustomerLookUp> pending = new ArrayList<CustomerLookUp>();
				System.out.println("------ CHOOSE AN OPTION ------");
				System.out.println("Customer Account Information 	-> Enter 1: ");
				System.out.println("Customer Account Balanace 	-> Enter 2: ");
				System.out.println("Approve Account Request 	-> Enter 3: ");
				System.out.println("Deny Account Request 	 	-> Enter 4: ");
				
				// should have a check account status (approved, denied, pending)
				int choice = myScanner.nextInt();
				myScanner.nextLine();
				
				switch(choice) {
				case 1:
					try {
						System.out.println("Enter the >>>> USER ID <<<< the customer who's account information you wold like to view.\n");
						emImpl.viewAllAccountIDs();
						int lookUpID = myScanner.nextInt();
						myScanner.nextLine();
						System.out.println(cImpl.viewAccount(lookUpID).get(0).toString());
						Logging.LOGGER.info("Employee viewed customer account => Employee ID:" + userID);
						myScanner.nextLine();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						break;
				case 2:;
					try {
						System.out.println("Enter the >>>> ACCOUNT ID <<<< of the customer who's account balance you would like to view.\n");
						emImpl.viewAllAccountIDs();
						int lookUpID = myScanner.nextInt();
						myScanner.nextLine();
						System.out.println("Account Balance for >>>> USER ID <<<< "+lookUpID+" = $" + emImpl.viewAccountBalance(lookUpID));
						Logging.LOGGER.info("Employee viewed customer account balance => Employee ID:" + userID);
						myScanner.nextLine();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 3:
					try {
						System.out.println("Enter the>>>> USER ID <<<< of the customer who's account you would like to approve.\n");
						emImpl.viewAPendingAccounts();
						userID = myScanner.nextInt();
						myScanner.nextLine();
						emImpl.approveAccount(userID);
						Logging.LOGGER.info("Employee approved customer account => Employee ID:" + userID);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					myScanner.close();
					break;
					
				case 4:
					try {
						System.out.println("Enter the >>>> USER ID <<<< of the customer who's accountyou would like to deny.");
						emImpl.viewAPendingAccounts();
						userID = myScanner.nextInt();
						myScanner.nextLine();
						emImpl.denyAccount(userID);
						Logging.LOGGER.info("Employee denied customer account => Employee ID:" + userID);
						myScanner.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
				default: myScanner.close();
				}
		}
		public void CustomerPrompt(int userID) {
			CustomerImpl cImpl = new CustomerImpl();
				System.out.println("------ CHOOSE AN OPTION ------");
				System.out.println("Make Deopist 		-> Enter 1: ");
				System.out.println("Make Withdrawal 	-> Enter 2: ");
				System.out.println("Transfer		-> Enter 3: ");
				System.out.println("Create a Joint Account 	-> Enter 4: ");
				System.out.println("View My Account Info 	-> Enter 5: ");
				System.out.println("View My Account Balance -> Enter 6: ");
				System.out.println("Cancel My Account	-> Enter 7: ");
				System.out.println("Logout 			-> Enter 8:");
				choice = myScanner.nextInt();
				myScanner.nextLine();
				switch(choice) {
				case 1:
					System.out.println("How much would you like to deposit?");
					amount = myScanner.nextDouble();
					myScanner.nextLine();
					try {
						Customer c = (Customer)cImpl.viewAccount(userID).get(0);
						acctID = c.getAccountID();
						System.out.println("Depoist Successful...\nAmount Deposited -> $"+amount+ "\nNew Balance -> $" + cImpl.deposit(acctID, amount));
						Logging.LOGGER.info("Employee made deposit => Customer ID:" + userID + "$"+amount);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					myScanner.close();
					break;
					
				case 2:
					System.out.println("How much would you like to withdraw?");
					amount = myScanner.nextDouble();
					myScanner.nextLine();
					try {
						Customer c = (Customer)cImpl.viewAccount(userID).get(0);
						acctID = c.getAccountID();
						System.out.println("Withdraw Successful...\nAmount Withdrawn -> $"+amount+ "\nRemaing Balance -> $" + cImpl.withdraw(acctID, amount));
						Logging.LOGGER.info("Employee made withdraw => Customer ID:" + userID + "$"+amount);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					myScanner.close();
					break;
				
				case 3:
					System.out.println("Please enter the Routing Number of the account you wish to trasnfer to: ");
					rtng_number = myScanner.nextInt();
					myScanner.nextLine();
					System.out.println("Thank you...\nNow enter the Account Number of the account you wish to trasnfer to: ");
					acct_number = myScanner.nextLong();
					myScanner.nextLine();
					System.out.println("Thank you...\nNow enter the Amount you wish to transfer:  ");
					amount = myScanner.nextDouble();
					myScanner.nextLine();
					try {
						Customer c = (Customer)cImpl.viewAccount(userID).get(0);
						acctID = c.getAccountID();
						double[] balances = cImpl.trasnfer(acctID, rtng_number, acct_number, amount);
						System.out.println("Transfer Successful... \nAmount transfered -> $"+amount+"\nNew Balance -> $"+balances[0]);
						System.out.println("Your remaining balance -> $"+balances[1]);
						Logging.LOGGER.info("Employee made transfer => Customer ID:" + userID + "$" +amount);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
					
				case 4:
					break;
				case 5:
					try {
						System.out.println("You current balance is: $" + cImpl.viewAccountBalance(userID));
						Logging.LOGGER.info("Employee viewed account balance => Customer ID:" + userID);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				case 6:
					try {
						cImpl.cancelAccount(userID, acctID);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				
				case 7:
					try {;
						System.out.println(cImpl.viewAccount(userID).get(0).toString());
						Logging.LOGGER.info("Employee viewed account => Customer ID:" + userID);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					myScanner.close();
					break;
					
				case 8:
					System.out.println("Logout Successful... Goodbye");
					Logging.LOGGER.info("Employee logged out => Customer ID:" + userID);
					myScanner.close();
					System.exit(0);
					break;
				}
			myScanner.close();
				
		}
}
