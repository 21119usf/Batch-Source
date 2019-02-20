package com.revature.main;

import java.util.ArrayList;
import java.util.LinkedList;

import org.apache.logging.log4j.core.Logger;

import com.revature.bank.AdminOptions;
import com.revature.bank.CustomerOptions;
import com.revature.bank.EmployeeOptions;
import com.revature.bank.Login;
import com.revature.bank.Utility;
import com.revature.beans.Account;
import com.revature.beans.Admin;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.User;
import com.revature.fileIO.FileIO;



public class Driver {

	/*These lists define the state of the bank. The users list represents
	 * all the users (employees, admin and customers). The appQueue represents
	 * all the applicants waiting to be added (or denied) to the users and assigned
	 * an account. Accounts contains all the accounts for the customers
	 */
	public static LinkedList<Customer> appQueue;
	public static ArrayList<User> users;
	public static ArrayList<Account> accounts;
	//static Logger logger = Logger.getLogger(Driver.class);
	public static void main(String[] args) {
		
		/*These simply populate the data structures above through
		 * use of file io
		 */
		users = FileIO.readUserFile();
		accounts = FileIO.readAccountFile();
		appQueue = FileIO.readAppQueueFile();
//		Utility.print(users);
//		Utility.print2(accounts);
//		Utility.print3(appQueue);
//		Utility.init();
		User u;
		
		/*Actual banking app
		 * This while loop loops through the entire app so it can be run
		 * continuously without having to re-run the entire java program
		 * Inside the loop we prompt the user to login or app. If they login
		 * they User type is tested and depending on the subtype of user their
		 * respectives menus are ran.
		 */
		while(true) {
			String s = Login.landingPage();
			if(s.equals("1")) {
				u = Login.loginPrompt();
				if(u instanceof Customer && ((Customer) u).checkActivated()) {
					CustomerOptions.run((Customer)u);
				}
				else if(u instanceof Admin) {
					AdminOptions.run((Admin) u);
				}
				else if(u instanceof Employee){
					EmployeeOptions.run((Employee) u);
					
				}
				else {
					System.out.println("This shouldn't happen??");
				}
			}
			else if(s.equals("2")) {
				Login.applyPrompt();
			}
			else if(s.equals("quit")) {
				break;
			}
			else {
				System.out.println("Not a valid choice");
			}
		}
		/*After the banking app is exited all changes in the static
		 * lists at the top of this class are flushed to files to restore
		 * state the next time the program is run. 
		 */
		FileIO.writeUserFile(users);
		FileIO.writeAppQueueFile(appQueue);
		FileIO.writeAccountFile(accounts);
//	
	
	}
}
