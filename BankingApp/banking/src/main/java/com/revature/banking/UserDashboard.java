package com.revature.banking;

import java.util.Scanner;

public class UserDashboard{
	static IO io = new IO();
	static String userString = io.readInputStreamContents("Users.txt");
	static String empString = io.readInputStreamContents("Users.txt");
	static String adminString = io.readInputStreamContents("Users.txt");
	static String[] userList = userString.split(System.getProperty("line.separator"));
	static int userLength = userList.length;

	public static void dash(int userType, int userID) {
		switch(userType) {
		
		case 1:
			custDash(userID);
			break;
		case 2:
			System.out.println("This is the employee");
			break;
		case 3:
			System.out.println("This is the admin");
			break;
		
		
		}
	}
	public static void custDash(int userID) {
		String custString = io.readInputStreamContents("Customers.txt");
		String[] custList = custString.split(System.getProperty("line.separator"));
		int custlength = custList.length;
		for (int i = 1; i < custlength; i++) {
			String[] custSplit = custList[i].split(":");
			int checkID = Integer.parseInt(custSplit[0]);
			if (checkID == userID) {

				boolean loggedout = false;
				while (!loggedout) {
				System.out.println("What would you like to do?");
				System.out.println(	"1 - Check your balance\n"
						+ 			"2 - Withdraw money\n"
						+ 			"3 - Deposit money\n"
						+ 			"4 - Transfer funds\n"
						+ 			"5 - Log out\n"
						+ "=================================================================");
				Scanner input = new Scanner(System.in);
				String optionStr = input.nextLine();
				int option = Integer.parseInt(optionStr);
				switch (option) {
				case 1:
					custString = io.readInputStreamContents("Customers.txt");
					custList = custString.split(System.getProperty("line.separator"));
					custSplit = custList[i].split(":");
					int accountBalance = Integer.parseInt(custSplit[1]);
					System.out.println("=================================================================\n");
					System.out.println("Your balance is $" + accountBalance);
					System.out.println("\n=================================================================");
					break;
				case 2:
					custString = io.readInputStreamContents("Customers.txt");
					custList = custString.split(System.getProperty("line.separator"));
					custSplit = custList[i].split(":");
					accountBalance = Integer.parseInt(custSplit[1]);
					System.out.println("==============How much would you like to withdraw? ==============");
					int withAmount = input.nextInt();
					int diff = accountBalance - withAmount;
					if (withAmount <= 0) {
						System.out.println("Please enter a positive number.");
					}
					else if (diff < 0) {
						System.out.println("OVERDRAW WARNING\n"
								+ "You do not have enough funds in your account to complete this transaction.");
					}
					else {
						accountBalance = diff;
						System.out.println("=================================================================\n");
						System.out.println("You have withdrawn $" + withAmount + ".\nYour new account balance is $" + accountBalance);
						System.out.println("\n=================================================================");
						String accountBal = Integer.toString(accountBalance);
						String newBal = custSplit[0] + ":" + accountBal + ":" + custSplit[2];

						System.out.println(newBal+" = "+custList[i]);
						IO.overwriter("Customers.txt", newBal, custList[i]);
					}
					break;
				case 3:
					custString = io.readInputStreamContents("Customers.txt");
					custList = custString.split(System.getProperty("line.separator"));
					custSplit = custList[i].split(":");
					accountBalance = Integer.parseInt(custSplit[1]);
					System.out.println("===============How much would you like to deposit?===============");
					int depAmount = input.nextInt();
					int deposit = accountBalance + depAmount;
					if (depAmount <= 0) {
						System.out.println("Please enter a positive number.");
					}
					else if (deposit > 1000000000) {
						System.out.println("Please only deposit amounts less than 1 Billion dollars.");
					}
					else {
						accountBalance = deposit;
						System.out.println("=================================================================\n");
						System.out.println("You have deposited $" + depAmount + ".\nYour new account balance is $" + accountBalance);
						System.out.println("\n=================================================================");
						String accountBal = Integer.toString(accountBalance);
						String newBal = custSplit[0] + ":" + accountBal + ":" + custSplit[2];

						System.out.println(newBal+" = "+custList[i]);
						IO.overwriter("Customers.txt", newBal, custList[i]);
					}
					break;
				case 4:
					custString = io.readInputStreamContents("Customers.txt");
					custList = custString.split(System.getProperty("line.separator"));
					custSplit = custList[i].split(":");
					accountBalance = Integer.parseInt(custSplit[1]);
					
					boolean success = false;
						while (!success) {
							String yourID = custSplit[0];
							String yourJoint = custSplit[2];
							System.out.println("Please enter the username of the person to whom you wish to transfer money:");
							String custTrans = input.nextLine();
						for (int j = 1; j < userLength; j++) {
							String[] transSplit = userList[j].split(":");
//							System.out.println(transSplit[1] + " " + custTrans);
//							System.out.println(transSplit[2]);
							
							if ((custTrans.equals(transSplit[1]))) {
								int transTarget = Integer.parseInt(transSplit[0]);
								for (int k = 1; k < custlength; k++) {
									String[] targSplit = custList[k].split(":");
									int checkTarg = Integer.parseInt(targSplit[0]);
									if (checkTarg == transTarget) {
										
							
					System.out.println("============== How much would you like to transfer?==============");
					int transAmount = input.nextInt();
					int balAfterTransfer = accountBalance - transAmount;
					if (transAmount <= 0) {
						System.out.println("Please enter a positive number.");
					}
					else if (balAfterTransfer < 0) {
						System.out.println("OVERDRAW WARNING\n"
								+ "You do not have enough funds in your account to complete this transaction.");
					}
					else {
						int yourAccountBalance = balAfterTransfer;
						System.out.println(targSplit[1]);
						System.out.println(Integer.toString(balAfterTransfer));
						int targBalance = Integer.parseInt(targSplit[1]);
						int newTargBalance = targBalance + transAmount;
						System.out.println("=================================================================\n");
						System.out.println("You have transferred $" + transAmount + " to " + custTrans);
						System.out.println("Your new account balance is $" + yourAccountBalance);
						System.out.println("\n=================================================================");
						String accountBal = Integer.toString(yourAccountBalance);
						
						String transBal = Integer.toString(newTargBalance);
//						System.out.println(transBal);
						String yourNewBal = yourID + ":" + accountBal + ":" + yourJoint;
						String transNewBal = targSplit[0] + ":" + transBal + ":" + targSplit[2];

//						System.out.println(yourNewBal+" = "+custList[i]);
//						System.out.println(transNewBal+" = "+custList[k]);
						
						IO.overwriter("Customers.txt", yourNewBal, custList[i]);
						IO.overwriter("Customers.txt", transNewBal, custList[k]);
						success = true;
					}
									}
								}
							}
//							else {
//								System.out.println("=======================Incorrect username!=======================");
//								success=true;
//								break;
//							}
							
						}}
					break;
				case 5:
					loggedout=true;
				}
				}
				
				
			}
		}
	}
	
}
