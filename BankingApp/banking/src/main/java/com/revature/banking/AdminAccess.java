package com.revature.banking;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.banking.IO.Fixer;
import com.revature.banking.user.Customer;

public class AdminAccess {
	//initializing IO
	static IO io = new IO();
	static String userString = io.readInputStreamContents("Users.txt");
	static String[] userList = userString.split(System.getProperty("line.separator"));
	static String custString = io.readInputStreamContents("Customers.txt");
	static String[] custList = custString.split(System.getProperty("line.separator"));
	private static Logger logger = LogManager.getLogger(AdminAccess.class);
	
	
	static int userLength = userList.length;
	//admin dashboard method
	public static void adminDash(int userID) {
		//fixing
		String [] testList = Fixer.fixingList(custList);
		custList = testList;
		
		String appString = io.readInputStreamContents("Applicants.txt");
		String[] appList = appString.split(System.getProperty("line.separator"));
		//fixing again
		testList = Fixer.fixingList(appList);
		appList = testList;
		
		int custlength = custList.length;
		int appLength = appList.length;
		//while boolean login
		boolean loggedout = false;
		while (!loggedout) {
			System.out.println("What would you like to do?");
			System.out.println(	"1 - View/Modify Account Information\n"
					+ 			"2 - Approve/Deny Applications\n"
					+ 			"3 - Create new Employee\n"
					+ 			"0 - Log Out\n"
					+ "=================================================================");
			Scanner input = new Scanner(System.in);
			String optionStr = input.nextLine();
			int option = Integer.parseInt(optionStr);
			switch (option) {
			case 1:
				//to modify an account, you have to input the username first
				System.out.println("Please enter the username of the Account you wish to look up:");
				String userLookup = input.nextLine();
			for (int j = 1; j < userLength; j++) {
				
				testList = Fixer.fixingList(userList);
				userList = testList;
				String[] userSplit = userList[j].split(":");
				if ((userLookup.equals(userSplit[1]))) {
					int userTarget = Integer.parseInt(userSplit[0]);
					for (int k = 1; k < custlength; k++) {
						
						testList = Fixer.fixingList(custList);
						custList = testList;
						custlength = custList.length;
						String[] custSplit = custList[k].split(":");
						int checkCust = Integer.parseInt(custSplit[0]);
						//if you find the account
						if (checkCust == userTarget) {
							boolean goback = false;
							while (!goback) {
								//you can choose the normal 2 options from employees, as well as modify account
							System.out.println("What would you like to look up?\n"
									+ "1 - Account Balance\n"
									+ "2 - Account Information\n"
									+ "3 - Modify Account\n"
									+ "0 - Go back");
							input = new Scanner(System.in);
							optionStr = input.nextLine();
							option = Integer.parseInt(optionStr);
							switch(option) {
							case 1:
								//as before, just a simple statement of balance
								System.out.println("User " + userLookup + " has an account balance of $" + custSplit[1]);
								break;
							case 2:
								//running the customer bean
								Customer cust = new Customer();
								cust.setAccountBalance(Double.parseDouble(custSplit[1]));
								cust.setFullName(custSplit[3]);
								boolean joint = Boolean.parseBoolean(custSplit[2]);
								cust.setJoint(joint);
								int custID = Integer.parseInt(custSplit[0]);
								cust.setID(custID);
								cust.setUsername(userSplit[1]);
								System.out.println(cust.toString());
								break;
							case 3:
								//running the modifyAccounts method
								modifyAccounts(custSplit, userSplit, k, j, userID);
								break;
							case 0:
								//logout
								goback = true;
								break;
							}
							}
						}
					}
				}				
			}
				break;
			case 2://same applicant list as employees
				boolean success = false;
				while (!success) {
					System.out.println("What would you like to do?\n"
							+ "1 - View Applicant List\n"
							+ "2 - Approve/Deny Individual Applicants\n"
							+ "3 - Approve/Deny Applicants Sequentially\n"
							+ "0 - Go Back");
					String approveDenyChoice = input.nextLine();
					switch(Integer.parseInt(approveDenyChoice)) {
						case 1:
							System.out.println("=========================Applicant List:=========================");
							for (int j = 1; j < appLength; j++) {
								if (appList[j] == null) {
									continue;
								}

								String[] applicantSplit = appList[j].split(":");
								
								if (!(Boolean.parseBoolean(applicantSplit[5]))) {
									if (!(Boolean.parseBoolean(applicantSplit[4]))) {
								boolean jointApp = Boolean.parseBoolean(applicantSplit[2]);
								if (jointApp) {
									System.out.println("Applicant: " + applicantSplit[7] + ", a joint account, initial deposit: " + applicantSplit[6] + ", userID: " + applicantSplit[0]);
								}
								else {
									System.out.println("Applicant: " + applicantSplit[7] + ", initial deposit: " + 
											applicantSplit[6] + ", userID: " + applicantSplit[0]);
									}
								}
								}
							}
							
							System.out.println("=================================================================");
							break;
						case 2:
							//same search method as for employee
							System.out.println("=================================================================");
							System.out.println("Input the Applicant ID of the Applicant you wish to view:");
							String appIDcase2 = input.nextLine();
							EmployeeAccess.appReviewSearch(appIDcase2, appLength, appList, userID);
							break;
						case 3:
							//same sequential method as employee
							EmployeeAccess.appReviewSequential(appLength, appList, userID);
							break;
						case 4: 
							success = true;
							break;
					}
				}
				break;
			case 3:
				//running the employeeMake method
				employeeMake(userID);
				break;
			case 0:
				loggedout=true;
			}
		}
		
	}
	
		//employeeMake method... it makes employees
		static void employeeMake(int userID){
			boolean validName = false;
			while (!validName) {
				//as with all job usernames, the user can't pick it
				System.out.println("=================================================================");
				System.out.println("Please choose a Username");
			Scanner input = new Scanner(System.in);
			String empAttempt = input.nextLine();
			for (int i = 0; i < userLength; i++) {

				String[] userSplit = userList[i].split(":");
				String appString = io.readInputStreamContents("Applicants.txt");
				String[] appList = appString.split(System.getProperty("line.separator"));
				int appLength = appList.length;
				for (int j = 0; j < appLength; j++) {
				String[] appSplit = appList[j].split(":");
				//same info as registering
				if (empAttempt.equals(userSplit[1])) {
					System.out.println("Username already taken.\nPlease choose a different Username");
					empAttempt = input.nextLine();
				}
				else if (empAttempt.equals(appSplit[1])) {
					System.out.println("Username already taken.\nPlease choose a different Username");
					empAttempt = input.nextLine();
				}
			}
			}
			
			
			validName = true;
			boolean passLengthOkay = false;
			while (!passLengthOkay) {

			System.out.println("=================================================================");
			System.out.println("Please choose a Password with 6 to 10 characters:");
			String password = input.nextLine();
				if (password.length()>10) {
					System.out.println("This password is too long; try again.");
					System.out.println("=================================================================");
				}
				else if (password.length()<6) {
					System.out.println("This password is too short; try again");
					System.out.println("=================================================================");
				}
				else {
					//reminding the admin to write down the password as it's encrypted
					logger.info(empAttempt + " created by USERID " + userID);
					System.out.println("The employee " + empAttempt + 
							"'s account has been created; their password is \"" + password + 
							"\". Make sure they write this down!");
					System.out.println("=================================================================");
					int passint = password.hashCode();
					int encryption = (passint*500003477)%1009747;
					
					String appString = io.readInputStreamContents("Applicants.txt");
					String[] appList = appString.split(System.getProperty("line.separator"));
					int appNum = appList.length;
					
					int empID = appNum + userLength;
					io.writeOutputStreamContents(System.getProperty("line.separator") + 
							 empID + ":" + empAttempt + ":" + "2" + ":" + encryption, "Users.txt");
					passLengthOkay=true;
					validName = true;
				}
			}
			
			}
		}
		//modifyAccounts method
		static void modifyAccounts(String[] custSplit, String[] userSplit, int custLine, int userLine, int userID) {
			boolean success = false;
			while(!success) {
				//lots of modifications possible
			System.out.println("What about this account would you like to modify?");
			System.out.println(
						"1 - Password\n"
					+ 	"2 - Balance\n"
					+ 	"3 - Transfer from\n"
					+ 	"4 - Joint Status\n"
					+ 	"5 - Full Name\n"
					+ 	"6 - Cancel Account\n"
					+ 	"0 - Go Back");
			Scanner input = new Scanner(System.in);
			String choice = input.nextLine();
			int choiceInt = Integer.parseInt(choice);
			
			switch(choiceInt){
			case 1:
				//change password
				String[] testList = Fixer.fixingList(userList);
				userList = testList;

				System.out.println("=================================================================");
				System.out.println("What would you like to change "+ userSplit[1] + "'s password to?");
				String passStr = input.nextLine();
				int passint = passStr.hashCode();
				int encryption = (passint*500003477)%1009747;

				System.out.println("=================================================================");
				System.out.println(userSplit[1] + "'s password has been changed to " + passStr);
				System.out.println("Be sure that they remember this new one!");
				System.out.println("=================================================================");
				//actually not hard to change most of these, just changing one thing on one file
				logger.info(userSplit[0] + " password changed by " + userID);
				//overwriting
				String newPass = userSplit[0] + ":" + userSplit[1] + ":" + userSplit[2] + ":" + encryption;
				IO.overwriter("Users.txt", newPass, userList[userLine],userLine);
				
				break;
				//modifying the balance on account
			case 2:
				//tester fixing things
				testList = Fixer.fixingList(custList);
				custList = testList;
				int accountBalance = Integer.parseInt(custSplit[1]);
				//displays balance before asking how much to modify by
				System.out.println("Current Balance of " + userSplit[1] + ": $" + accountBalance);
				System.out.println("===============By how much would you like to modify this account?===============\n"
						+ "(to reduce the amount, input a negative number)");
				int balChange = input.nextInt();
				int newBal = accountBalance + balChange;
				//same as before, less than 1bn please
				if (Math.abs(balChange) > 1000000000) {
					System.out.println("Please only modify accounts by less than 1 Billion dollars.");
				}
				else {
					accountBalance = newBal;
					System.out.println("=================================================================\n");
					System.out.println("You have changed the account balance by $" + balChange + ".\nThe new account balance is $" + accountBalance);
					System.out.println("\n=================================================================");
					
					logger.info(userSplit[0] + "'s account balance changed by $" + balChange + " by USER " + userID);
					
					String accountBal = Integer.toString(accountBalance);
					String modBal = custSplit[0] + ":" + accountBal + ":" + custSplit[2] + ":" + custSplit[3];
					
					IO.overwriter("Customers.txt", modBal, custList[custLine],custLine);
				}
				break;
			case 3:
				//transfer money, literally the same way as cust-to-cust
				custString = io.readInputStreamContents("Customers.txt");
				custList = custString.split(System.getProperty("line.separator"));
				
				testList = Fixer.fixingList(custList);
				custList = testList;
				
				custSplit = custList[custLine].split(":");
				accountBalance = Integer.parseInt(custSplit[1]);
				CustomerAccess.transferMoney(custSplit, custList.length, custList, custLine, userID);
				logger.info("Transfer initiated by USER " + userID);
				break;
			case 4:
				//fixer
				testList = Fixer.fixingList(custList);
				custList = testList;
				//change joint bank account
				System.out.println("=================================================================");
				if (custSplit[2].equals("true")) {
				System.out.println(userSplit[1] + " currently has a Joint bank account.");
				System.out.println("Would you like to modify their joint status? (Y or N)");
				String changeJoint = input.nextLine();
				if (changeJoint.equals("Y")) {
					custSplit[2] = "false";
				}
				}
				else {
					System.out.println(userSplit[1] + " does not currently have a joint bank account.");
					System.out.println("Would you like to modify their joint status? (Y or N)");
					String changeJoint = input.nextLine();
					if (changeJoint.equals("Y")) {
						custSplit[2] = "true";
					}
				}
				//writing over
				logger.info(userSplit[0] + "'s joint status changed by USER " + userID);
				String modJoint = custSplit[0] + ":" + custSplit[1] + ":" + custSplit[2] + ":" + custSplit[3];
				IO.overwriter("Customers.txt", modJoint, custList[custLine],custLine);
				
				break;
				//changing name
			case 5:
				//fixer again
				testList = Fixer.fixingList(custList);
				custList = testList;
				System.out.println("=================================================================");
				System.out.println(userSplit[1] + " currently has their full name listed as: " + custSplit[3]);
				System.out.println("What would you like to change their listed full name to? (Input \"esc\" to go back)");
				String changeName = input.nextLine();
				if (changeName.equals("esc")) {
					break;
				}
				else {
					//allows the name to be changed
					custSplit[3] = changeName;
					logger.info(userSplit[0] + "'s full name changed by USER " + userID);
					String modName = custSplit[0] + ":" + custSplit[1] + ":" + custSplit[2] + ":" + custSplit[3];
					IO.overwriter("Customers.txt", modName, custList[custLine],custLine);
				}
				
				break;
			case 6:
				//deleting/cancelling an account
				testList = Fixer.fixingList(custList);
				custList = testList;
				testList = Fixer.fixingList(userList);
				userList = testList;
				int custLength = custList.length;
				//technically I'm lying here. the account's info is dumped, but it's still there
				System.out.println("=================================================================");
				System.out.println("WARNING: Once an account is cancelled, it cannot be returned.");
				System.out.println("Do you still want to delete " + userSplit[1] + "? (Y or N)");
				String deleteAcc = input.nextLine();
				if (deleteAcc.equals("Y")) {
					String cancelUser = userSplit[0] + ":" + userSplit[1] + ":-1:" + userSplit[3];
					IO.overwriter("Users.txt", cancelUser, userList[userLine],userLine);
					for (int i = 1; i < custLength; i++) {
						if (userSplit[0].equals(custSplit[0])) {
							//replacing the account with a default one to prevent index out of bounds errors
					String cancelAcc = custSplit[0] +  ":0:false:0" + ":CANCELLEDNUM" + custSplit[0];
					IO.overwriter("Customers.txt", cancelAcc, custList[custLine],custLine);
						}
					}
					logger.info(userSplit[0] + "'s account has been deleted by USER " + userID);
					System.out.println(userSplit[1] + "'s account has been deleted");
				}
				break;
			case 0:
				//logging out
				success = true;
				break;
				
			}
		}
		}
}
