package com.revature.options;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daoImpl.CustomerDaoImpl;

public class CustomerOptions {
	public static Scanner sc = new Scanner(System.in);
	public static Logger logger = LogManager.getLogger(CustomerOptions.class);
	
	public static int login() {
		int custId = 0;
		while(true) {
			System.out.print("Enter your username: ");
			String username = sc.nextLine();
			System.out.print("Enter your password: ");
			String password = sc.nextLine();
			CustomerDaoImpl cdi = new CustomerDaoImpl();
			try {
				custId = cdi.loginCustomer(username, password);
				System.out.println("Login Successful!");
				break;
			}catch (SQLException e) {
				System.out.println("Incorrect credentials try again");
			}
		}
		return custId;
		
	}
	
	public static void custMenu(int cid) {
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		while(true) {
			System.out.println("\n\t1.View Accounts and balances");
			System.out.println("\t2.Create new account");
			System.out.println("\t3.Delete account");
			System.out.println("\t4.Deposit");
			System.out.println("\t5.Withdraw");
			System.out.println("\t6.Logout");
			String choice = sc.nextLine();
			if(choice.equals("1")) {
				try {
					cdi.getAccountBalances(cid);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if(choice.equals("2")) {
				try {
					cdi.createNewAccount(cid);
					System.out.println("Account created");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if(choice.equals("3")) {
				try {
					cdi.getAccountBalances(cid);
					System.out.println("Which account would you like to delete (can only delete empty accounts)");
					int accId = Integer.parseInt(sc.nextLine());
					if(cdi.getBalance(accId) == 0) {
						cdi.delete(accId);
						System.out.println("Account "+accId+" deleted");
					}else {
						System.out.println("This account needs to be emptied before it can be deleted");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(choice.equals("4")) {
				try {
					cdi.getAccountBalances(cid);
					System.out.println("Enter the number of the account you would like to deposit to: ");
					int accId = parser(sc.nextLine());
					System.out.println("How much would you like to deposit: ");
					double amount = Double.parseDouble(sc.nextLine());
					double bal = cdi.getBalance(accId);
					cdi.deposit(accId,bal,amount,cid);
					System.out.println("New Balance: "+(bal+amount));
					logger.info("Customer "+cid+" deposited "+amount+" new balance: "+(bal+amount) );
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(choice.equals("5")) {
				try {
					cdi.getAccountBalances(cid);
					System.out.println("Enter the number of the account you would like to withdraw from: ");
					int accId = parser(sc.nextLine());
					System.out.println("How much would you like to withdraw: ");
					double amount = Double.parseDouble(sc.nextLine());
					double bal = cdi.getBalance(accId);
					if(bal >= amount) {
						cdi.withdraw(accId,bal-amount,cid);
						System.out.println("New Balance: "+cdi.getBalance(accId));
						logger.info("Customer "+cid+" withdrew "+amount+" new balance: "+(bal-amount) );
					}else {
						System.out.println("Insufficient funds");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(choice.equals("6")) {
				System.out.println("Have a nice day!");
				break;
			}else {
				System.out.println("Incorrect input try again");
			}
		}
	}
	public static int parser(String s) {
		while(true) {
			try {
				return Integer.parseInt(s);
			}catch(NumberFormatException e) {
				System.out.println("invalid format, try again");
				s = sc.nextLine();
			}
		}
	}
}