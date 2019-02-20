package com.revature.bankApp;

import java.util.Scanner;

public class RunBank {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		CustomerFunctions customerManager = new CustomerFunctions();
		MappingAccountAndUser accountManager = new MappingAccountAndUser();
		ApplicationManager applicationManager = new ApplicationManager();

		String username = "";
		String password = "";

		boolean runBank = true;
		while (runBank) {
			String firstSelection = "";
			System.out.println("========================================");
			System.out.println("==============  WELCOME  ===============");
			System.out.println("========================================");
			System.out.println("Please select an option");
			System.out.println("a: Create new account");
			System.out.println("b: Login");
			System.out.println("c: Admin Power");
			System.out.println("e: Exit Bank");

			firstSelection = scanner.nextLine();

			switch (firstSelection) {
			case "a":
				// Creating new Account
				// =====================================================================
				System.out.println("========================================");
				System.out.println("=============  NEW USER  ===============");
				System.out.println("========================================");
				System.out.println("What is your username: ");
				username = scanner.nextLine();

				System.out.println("What is your password: ");
				password = scanner.nextLine();

				applicationManager.createNewApplication(new User(username, password));// creating an application as a
																						// new user
				for (Application application : applicationManager.getApplicationMap().keySet()) {
					applicationManager.approveApplication(application, customerManager, accountManager); // manager
																											// approving
																											// the
																											// application
				}

				for (User user : customerManager.getFullMap().keySet()) {// displaying the account and balance of the 
					if (user.getUsername().equals(username)) { 			// customer that was just created
						if (user.getPassword().equals(password)) { 
																	
							System.out.println("Username:  " + user.getUsername() + " " + "Account Number:  "
									+ customerManager.getFullMap().get(user).getAccountNumber());
						}
					}
				}

				break;
			case "b":
				// Login
				// ====================================================================================
				System.out.println("========================================");
				System.out.println("===============  LOGIN  ================");
				System.out.println("========================================");
				boolean whileLoginBankRun = true;
				int checkAttemps = 0;
				String checkUser = "";
				String checkPassword = "";

				System.out.println("Login");
				System.out.println("Enter your user name");
				checkUser = scanner.nextLine();
				System.out.println("Enter your password: ");
				checkPassword = scanner.nextLine();

				while (whileLoginBankRun) {
					System.out.println("in login loop");
					for (User user : customerManager.getFullMap().keySet()) { // getting all the accounts

						if (user.getUsername().equals(checkUser)) { // comparing your username attempt to the map of
																	// users
							if (user.getPassword().equals(checkPassword)) { // comparing your password attempt to the
																			// map of users
								System.out.println("you made it in to login");
								System.out.println("========================================");
								System.out.println("Welcome " + user.getUsername() + " your account number: "
										+ customerManager.getFullMap().get(user).getAccountNumber());
								System.out.println("========================================");
								System.out.println("Please select an option");
								System.out.println("a: deposit");
								System.out.println("b: withdraw");
								System.out.println("c: balance");
								String selectionTwo = "";
								selectionTwo = scanner.nextLine();

								switch (selectionTwo) {
								case "a":
									System.out.println("how much do you want to deposit?: ");
									String sAmount = "";
									sAmount = scanner.nextLine();
									double amount = Double.parseDouble(sAmount);
									customerManager.deposit(user, amount);
									System.out.println(
											"Account Balance: " + customerManager.getFullMap().get(user).getBalance());
									break;
								case "b":
									System.out.println("how much do you want to withdraw?: ");
									String stAmount = "";
									stAmount = scanner.nextLine();
									double amount2 = Double.parseDouble(stAmount);
									customerManager.withdraw(user, amount2);
										System.out.println(
												"Account Balance: " + customerManager.getFullMap().get(user).getBalance());
									
									
									break;
								case "c":
									System.out.println(
											"Account Balance: " + customerManager.getFullMap().get(user).getBalance());
									break;
								}

								checkAttemps = 0;
								whileLoginBankRun = false;
							}
							// System.out.println("Your login was incorrect username");
							break;
						} else
							System.out.println("Your login was incorrect");

						checkAttemps++;
						if (checkAttemps == 3) {
							whileLoginBankRun = false;
							break;
						}
					}
				}
				break;
			case "c":
				for (User user : customerManager.getFullMap().keySet()) {// displaying the account and balance of the 
					 										
					System.out.println("Username: " + user.getUsername() + "   Account Number: "
					+ customerManager.getFullMap().get(user).getAccountNumber() + "    Account Balance: " +customerManager.getFullMap().get(user).getBalance());
				}
				break;
			default:
				runBank = false;
				System.out.println("Goodbye");
			}
		}
		System.out.println("end");
		scanner.close();

	}

}

