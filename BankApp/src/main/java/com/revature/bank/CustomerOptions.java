package com.revature.bank;

import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Customer;
/*This class is used to allow to customer to view,withdraw,depost,transfer from their account
 * 
 */
public class CustomerOptions {

	static Scanner sc = new Scanner(System.in);
	
	public static void run(Customer c) {
		boolean logout = false;
		System.out.println("-------------------------------Customer Options---------------------------------");
		System.out.println("Hello "+c.getName());
		while(!logout) {
			System.out.println("\nWhat would you like to do?");
			System.out.println("\t1.Withdraw");
			System.out.println("\t2.Deposit");
			System.out.println("\t3.Transfer");
			System.out.println("\t4.View Balance");
			System.out.println("\t5.Logout\n");
			System.out.print("-> ");
			String choice = sc.nextLine();
			Account a = Utility.findAccount(c.getAccountID());
			double amount;
			if(choice.equals("1")) {
				System.out.println("How much would you like to withdraw?");
				System.out.print("\t -> ");
				amount = Utility.getDoubleFromSc();
				a.withdraw(amount);
			}else if(choice.equals("2")) {
				System.out.println("How much would you like to deposit?");
				System.out.print("\t -> ");
				amount = Utility.getDoubleFromSc();
				a.deposit(amount);
			}else if(choice.equals("3")) {
				System.out.println("Enter the account number you would like to transfer to");
				System.out.print("\t -> ");
				int accountNum = Utility.getIntFromSc();
				System.out.println("Enter the amount you would like to transfer");
				System.out.print("\t -> ");
				amount = Utility.getDoubleFromSc();
				a.transfer(amount,accountNum);
			}else if(choice.equals("4")) {
				System.out.println(a.getBalance()+" dollars in your account");
			}else if(choice.equals("5")) {
				logout = true;
			}else {
				System.out.println("Invalid input");
			}
		}
	}
}
