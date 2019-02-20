package com.revature.bank;

import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.main.Driver;
/*This class is used to allow employees to view accounts or add/deny pending applications 
 */
public class EmployeeOptions {
	
	static Scanner sc = new Scanner(System.in);

	public static void run(Employee e) {
		System.out.println("-------------------------------Employee Options---------------------------------");
		System.out.println("Hello "+e.getName());
		System.out.println("\nTime to get to work");
		boolean logout = false;
		while(!logout) {
			System.out.println("\n\t1.Approve/Deny pending applications");
			System.out.println("\t2.View Customer data");
			System.out.println("\t3.Logout\n");
			System.out.print("\t-> ");
			String choice = sc.nextLine();
			if(choice.equals("1")){
					approveDenyApps();
			}else if(choice.equals("2")) {
				viewCustomers();
			}else if(choice.equals("3")) {
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
		System.out.print("Enter the username of the customer you want to view :  ");
		String username = sc.nextLine();
		Customer d = (Customer) Utility.findUser(username);
		if(d != null) {
			System.out.print(d.toString());
			System.out.println(Utility.findAccount(d.getAccountID()).toString());
		}else {
			System.out.println("This username doesn't exist");
		}
	}
	
}
