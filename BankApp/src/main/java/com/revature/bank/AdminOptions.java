package com.revature.bank;

import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Admin;
import com.revature.beans.Customer;
import com.revature.beans.User;
import com.revature.main.Driver;

/*This class is used as control panel for the administrator where he is allowed to
 * view,edit,withdraw,deposit,transfer, or cancel any account/customer. * 
 */

public class AdminOptions {
	private static Scanner sc = new Scanner(System.in);
	
	public static void run(Admin a) {
		boolean logout = false;
		System.out.println("-------------------------------Administrator Options---------------------------------");
		System.out.println("Hello "+a.getName());
		System.out.println("\nYou da boss");
		while(!logout) {
			System.out.println("\n\t1.Approve/Deny pending applications");
			System.out.println("\t2.View Customer data");
			System.out.println("\t3.Edit Customer data");
			System.out.println("\t4.Withdraw from an account");
			System.out.println("\t5.Deposit to an account");
			System.out.println("\t6.Transfer money to account");
			System.out.println("\t7.Cancel account");
			System.out.println("\t8.Logout\n");
			System.out.print("\t-> ");
			String choice = sc.nextLine();
			if(choice.equals("1")){
					approveDenyApps();
			}else if(choice.equals("2")) {
				viewCustomers();
			}else if(choice.equals("3")) {
				editCustomers();
			}else if(choice.equals("4")) {
				withdraw();
			}else if(choice.equals("5")) {
				deposit();
			}else if(choice.equals("6")) {
				transfer();
			}else if(choice.equals("7")) {
				cancel();
			}else if(choice.equals("8")){ 
				logout = true;
			}else {
			
				System.out.println("Invalid input try again");
			}
		}
	}
	private static void approveDenyApps() {
		if(Driver.appQueue.isEmpty() || Driver.appQueue == null) {
			System.out.println("No current applicants");
			return;
		}
		System.out.println("Next applicant in queue : ");
		Customer c = Driver.appQueue.remove();
		System.out.println("\n"+c.toString());
		System.out.print("Hit 1 to approve or 0 to deny : ");
		String approval = sc.nextLine();
		if(approval.equals("1")) {
			int accID = Utility.nextAccountId();
			c.activate();
			c.setAccountID(accID);
			Driver.users.add(c);
			if(c.getC2() != null) {
				Driver.accounts.add(new Account(accID,0,c,c.getC2(),true));
				c.getC2().setAccountID(accID);
				c.getC2().activate();
				Driver.users.add(Driver.appQueue.remove());
				System.out.println("Account created");
			}else {
				Driver.accounts.add(new Account(accID,0,c,null,false));
				System.out.println("Account created");
			}			
		}else if(approval.equals("0")){
			System.out.println("Application denied");
		}else {
			System.out.println("Invalid input, try again");
		}
	}
	private static void viewCustomers() {
		System.out.print("Enter the username of the customer you want to view");
		System.out.print("\t-> ");
		String username = sc.nextLine();
		Customer d = (Customer) Utility.findUser(username);
		if(d != null) {
			System.out.print(d.toString());
			System.out.println(Utility.findAccount(d.getAccountID()).toString());
		}else {
			System.out.println("This username doesn't exist");
		}
	}
	private static void editCustomers() {
		System.out.print("Enter the username of the customer you want to edit");
		System.out.print("\t-> ");
		String username = sc.nextLine();
		Customer d = (Customer) Utility.findUser(username);
		if(d != null) {
			System.out.print(d.toString());
			System.out.println(Utility.findAccount(d.getAccountID()).toString());
		}
		System.out.println("What property would you like to edit?");
		System.out.println("\t1.Name");
		System.out.println("\t2.Username");
		System.out.println("\t3.Password");
		System.out.print("\t-> ");
		String choice = sc.nextLine();
		if(choice.equals("1")) {
			System.out.println("What would you like to change the account name to?");
			System.out.print("\t-> ");
			String newName = sc.nextLine();
			d.setName(newName);
			System.out.println("Changes made");
		}else if(choice.equals("2")) {
			System.out.println("What would you like to change the username to?");
			System.out.print("\t-> ");
			String newUsername = sc.nextLine();
			System.out.println("Changes made");
			d.setUsername(newUsername);
		}else if(choice.equals("3")) {
			System.out.println("What would you like to change the password to?");
			System.out.print("\t-> ");
			String newPassword = sc.nextLine();
			d.setPassword(newPassword);
			System.out.println("Changes made");
		}else {
			System.out.println("Incorrect input");
		}
	}
	private static void withdraw() {
		System.out.println("Enter the account number you would like to withdraw from");
		System.out.print("\t-> ");
		int accountNum = Utility.getIntFromSc();
		Account a = Utility.findAccount(accountNum);
		System.out.println("How much would you like to withdraw?");
		System.out.print("\t-> ");
		double amount = Utility.getDoubleFromSc();
		if(a != null) {
			a.withdraw(amount);
		}else {
			System.out.println("No such account exists");
		}
	}
	private static void deposit() {
		System.out.println("Enter the account number you would like to deposit to");
		System.out.print("\t-> ");
		int accountNum = Utility.getIntFromSc();
		Account a = Utility.findAccount(accountNum);
		System.out.println("How much would you like to deposit?");
		System.out.print("\t-> ");
		double amount = Utility.getDoubleFromSc();
		if(a != null) {
			a.deposit(amount);
		}else {
			System.out.println("No such account exists");
		}
	}
	private static void transfer() {

		System.out.println("Enter the account number you would like to transfer from");
		System.out.print("\t-> ");
		int accountNum = Utility.getIntFromSc();
		Account a = Utility.findAccount(accountNum);
		System.out.println("Enter the account number you would like to transfer to");
		System.out.print("\t-> ");
		accountNum = Utility.getIntFromSc();
		System.out.println("Enter the amount you would like to transfer");
		System.out.print("\t-> ");
		double amount = Utility.getDoubleFromSc();
		if(a != null) {
			a.transfer(amount,accountNum);
		}else {
			System.out.println("No such account exists");
		}
	}
	private static void cancel() {
		System.out.println("Enter the username of the account you would like to cancel");
		System.out.print("\t-> ");
		String username = sc.nextLine();
		User u = Utility.findUser(username);
		int accountNum = ((Customer)u).getAccountID();
		Driver.accounts.remove(Utility.findAccount(accountNum));
		Driver.users.remove(Utility.findUser(username));
		if(((Customer)u).getC2() != null) {
			Customer c2 = ((Customer)u).getC2();
			Driver.users.remove(c2);
		}
		System.out.println("Cancellation successful");
	}
	
}
