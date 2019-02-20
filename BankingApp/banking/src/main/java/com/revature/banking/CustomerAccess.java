package com.revature.banking;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.banking.IO.Fixer;

public class CustomerAccess {
	//as before initializing all of the files from the IO
	private static Logger logger = LogManager.getLogger(CustomerAccess.class);
	static IO io = new IO();
	static String userString = io.readInputStreamContents("Users.txt");
	static String[] userList = userString.split(System.getProperty("line.separator"));
	static int userLength = userList.length;
	
	
	public static void custDash(int userID) {
		String custString = io.readInputStreamContents("Customers.txt");
		String[] custList = custString.split(System.getProperty("line.separator"));
		//fixing customer list
		String[] testList = Fixer.fixingList(custList);
		custList = testList;
		
		int custlength = custList.length;
		for (int i = 1; i < custlength; i++) {


			String[] custSplit = custList[i].split(":");
			int checkID = Integer.parseInt(custSplit[0]);
			
			//since UserID is the primary key for the customer and user list, we check against the two to ensure we're accessing the right account
			if (checkID == userID) {
				//while loop
				boolean loggedout = false;
				while (!loggedout) {
					//giving customers the ability to choose what to do with a switch statement
				System.out.println("What would you like to do?");
				System.out.println(	"1 - Check your balance\n"
						+ 			"2 - Withdraw money\n"
						+ 			"3 - Deposit money\n"
						+ 			"4 - Transfer funds\n"
						+ 			"0 - Log out\n"
						+ "=================================================================");
				Scanner input = new Scanner(System.in);
				String optionStr = input.nextLine();
				int option = Integer.parseInt(optionStr);
				switch (option) {
				case 1:
					//Checking your balance
					//re-instantiating the customer list to ensure that the balance is up to date
					custString = io.readInputStreamContents("Customers.txt");
					custList = custString.split(System.getProperty("line.separator"));
					
					testList = Fixer.fixingList(custList);
					custList = testList;
					
					custSplit = custList[i].split(":");
					//grabbing balance info from the customers file
					int accountBalance = Integer.parseInt(custSplit[1]);
					System.out.println("=================================================================\n");
					System.out.println("Your balance is $" + accountBalance);
					System.out.println("\n=================================================================");
					break;
				case 2:
					//withdrawal, as above re-instantiating customers
					custString = io.readInputStreamContents("Customers.txt");
					custList = custString.split(System.getProperty("line.separator"));
					
					testList = Fixer.fixingList(custList);
					custList = testList;
					
					custSplit = custList[i].split(":");
					accountBalance = Integer.parseInt(custSplit[1]);
					System.out.println("==============How much would you like to withdraw? ==============");
					int withAmount = input.nextInt();
					//subtracting withdrawal amount from total in balance read from file
					int diff = accountBalance - withAmount;
					//to prevent some bloke from getting cheeky
					if (withAmount <= 0) {
						System.out.println("Please enter a positive number.");
					}
					//this bank does not allow overdrawals, so it will prevent the completion of this transaction
					else if (diff < 0) {
						System.out.println("OVERDRAW WARNING\n"
								+ "You do not have enough funds in your account to complete this transaction.");
					}
					//if you don't break those rules you get to do stuff
					else {
						accountBalance = diff;
						//nice little graphic showing the amount withdrawn
						System.out.println("=================================================================\n");
						System.out.println("You have withdrawn $" + withAmount + ".\nYour new account balance is $" + accountBalance);
						System.out.println("\n=================================================================");
						
						logger.info("CUSTOMER " + userID + "has withdrawn $" + withAmount);
						//converting the int value to String
						String accountBal = Integer.toString(accountBalance);
						//setting up the row to be re-attached to the file
						String newBal = custSplit[0] + ":" + accountBal + ":" + custSplit[2] + ":" + custSplit[3];
						//overwriter method used to, well, overwrite files
						IO.overwriter("Customers.txt", newBal, custList[i],custlength);
					}
					break;
				case 3:
					//re-instantiated
					custString = io.readInputStreamContents("Customers.txt");
					custList = custString.split(System.getProperty("line.separator"));
					//fixing
					testList = Fixer.fixingList(custList);
					custList = testList;
					
					custSplit = custList[i].split(":");
					accountBalance = Integer.parseInt(custSplit[1]);
					//pretty much the same code, but with deposits instead
					System.out.println("===============How much would you like to deposit?===============");
					int depAmount = input.nextInt();
					int deposit = accountBalance + depAmount;
					if (depAmount <= 0) {
						System.out.println("Please enter a positive number.");
					}
					//to ensure no stack overflow, we're limiting deposits (as if Billionaires deposit all their money in a checking account)
					else if (deposit > 1000000000) {
						System.out.println("Please only deposit amounts less than 1 Billion dollars.");
					}
					else {
						accountBalance = deposit;
						System.out.println("=================================================================\n");
						System.out.println("You have deposited $" + depAmount + ".\nYour new account balance is $" + accountBalance);
						System.out.println("\n=================================================================");
						
						logger.info("CUSTOMER " + userID + "has deposited $" + depAmount);
						//same as above
						String accountBal = Integer.toString(accountBalance);
						String newBal = custSplit[0] + ":" + accountBal + ":" + custSplit[2] + ":" + custSplit[3];
						//overwriting previous information
						IO.overwriter("Customers.txt", newBal, custList[i],custlength);
					}
					break;
				case 4:
					//transferring money
					//this one is so crazy I split it into its own method below
					custString = io.readInputStreamContents("Customers.txt");
					custList = custString.split(System.getProperty("line.separator"));
					
					testList = Fixer.fixingList(custList);
					custList = testList;
					
					custSplit = custList[i].split(":");
					accountBalance = Integer.parseInt(custSplit[1]);
					
					boolean success = false;
						while (!success) {
							//while loop solely for the method
							transferMoney(custSplit, custlength, custList, i, userID);
							success = true;
						}
					break;
				case 0:
					//ensuring the ability to log out
					loggedout=true;
				}
				}
				
				
			}
		}
	}
	//transfer money method, also used in adminAccess
		static void transferMoney(String custSplit[], int custlength, String[] custList, int fromLine, int userID){
					String[] testList = Fixer.fixingList(custList);
					custList = testList;
					testList = Fixer.fixingList(userList);
					userList = testList;
					//normal stuff
					custSplit = custList[fromLine].split(":");
					Scanner input = new Scanner(System.in);
					//listing all ID's as from and target/targ, to ensure no mistakes are made in sending money to whom
					String fromID = custSplit[0];
					int fromAccountBalance = Integer.parseInt(custSplit[1]);
					String fromJoint = custSplit[2];
					String fromFullName = custSplit[3];
					
					
					
					System.out.println("Please enter the username of the person to whom you wish to transfer money:");
					String custTrans = input.nextLine();
					//searching usernames for the input
				for (int j = 1; j < userLength; j++) {
					
					String[] transSplit = userList[j].split(":");
					if ((custTrans.equals(transSplit[1]))) {
						//parsing the string piece by piece
						int transTarget = Integer.parseInt(transSplit[0]);
						for (int k = 1; k < custlength; k++) {
							String[] targSplit = custList[k].split(":");
							int checkTarg = Integer.parseInt(targSplit[0]);
							if (checkTarg == transTarget) {
								
					
			System.out.println("============== How much would you like to transfer?==============");
			int transAmount = input.nextInt();
			int balAfterTransfer = fromAccountBalance - transAmount;
			//again, preventing negative shenanigans
			if (transAmount <= 0) {
				System.out.println("Please enter a positive number.");
			}
			//...and preventing overdrawal
			else if (balAfterTransfer < 0) {
				System.out.println("OVERDRAW WARNING\n"
						+ "There are not enough funds in this account to complete this transaction.");
			}
			else {
				//if all else succeeds, we now have a transfer path
				int yourAccountBalance = balAfterTransfer;
				int targBalance = Integer.parseInt(targSplit[1]);
				int newTargBalance = targBalance + transAmount;
				System.out.println("=================================================================\n");
				System.out.println("You have transferred $" + transAmount + " to " + custTrans);
				System.out.println("This account has a new account balance of $" + yourAccountBalance);
				System.out.println("\n=================================================================");
				
				logger.info("CUSTOMER " + fromID + " has transferred $" + transAmount + "to CUSTOMER " + targSplit[0]);
				
				String accountBal = Integer.toString(yourAccountBalance);
				//overwriting both the from and the target customer
				String transBal = Integer.toString(newTargBalance);
				String yourNewBal = fromID + ":" + accountBal + ":" + fromJoint + ":" + fromFullName;
				String transNewBal = targSplit[0] + ":" + transBal + ":" + targSplit[2] + ":" + targSplit[3];
			
				IO.overwriter("Customers.txt", yourNewBal, custList[fromLine],custlength);
				IO.overwriter("Customers.txt", transNewBal, custList[k],custlength);
				}
							}
						}
					}
				}
				}
}
