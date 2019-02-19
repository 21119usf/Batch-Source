package banking;

import java.util.Scanner;

import banking.beans.Session;
import banking.controllers.AccountsController;
import banking.controllers.CustomersController;
import banking.controllers.SessionsController;

public class Driver {
	
	public static Scanner input;

	public static void main(String[] args) {
		
		/* ArrayList<Customer> testData0 = new ArrayList<Customer>();
		
		for(int i = 0; i < 10; i++) {
			Customer cus = new Customer("username" + i, "password" + i);
			testData0.add(cus);
		}
		
		IO.writeFile(Customer.fileName, testData0); 
		
		ArrayList<Employee> testData1 = new ArrayList<Employee>();
		
		for(int i = 0; i < 10; i++) {
			Employee cus = new Employee("employeename" + i, "password" + i);
			testData1.add(cus);
		}
		
		Employee noelemployee = new Employee("noelemployee", "password");
		testData1.add(noelemployee);
		
		IO.writeFile(Employee.fileName, testData1); 
		
		ArrayList<Admin> testData2 = new ArrayList<Admin>();
		
		for(int i = 0; i < 10; i++) {
			Admin cus = new Admin("adminname" + i, "password" + i);
			testData2.add(cus);
		}
		Admin noeladmin = new Admin("noeladmin", "password");
		testData2.add(noeladmin);
		
		IO.writeFile(Admin.fileName, testData2); 
		
		ArrayList<Account> testData3 = new ArrayList<Account>();
		
		for(int i = 0; i < 10; i++) {
			Account cus = new Account("accountname" + i, "ownername" + i, i * 100, false, "", true);
			testData3.add(cus);
		}
		
		IO.writeFile(Account.fileName, testData3); */
		
		
		System.out.println("Welcome to the Revature Banking App.");
		System.out.println("You may enter \"exit\" at anytime to quit the application or leave a submenu.");
		input = new Scanner(System.in);
		
		
		while(!Session.currentSession().userIsLoggedIn()) {
			System.out.println("Please enter \"login\" or \"signup\" to continue.");
			if(input.hasNextLine()) {
				String option = input.nextLine();
				
				if(option.equals("login")) {
					SessionsController.getInstance().NEW();
				} else if(option.equals("signup")) {
					CustomersController.getInstance().NEW();
				} else if(option.equals("exit")) {
					System.exit(0);
				} else {
					System.out.println("Invalid Option.");
				}
			}
		}
		
		while(Session.currentSession().adminIsLoggedIn()) {
			System.out.println("Please enter \"logout\", \"customers\" or \"pending accounts\"  to continue.");
			
			if(input.hasNextLine()) {
				String option = input.nextLine();
				
				if(option.equals("pending accounts")) {
					AccountsController.getInstance().INDEX("pending accounts");
					
				} else if(option.equals("customers")) {
					CustomersController.getInstance().INDEX();
					
				} else if(option.equals("logout")) {
					System.out.println("Signed out.");
					System.exit(0);
				} else if(option.equals("exit")) {
					System.exit(0);
				} else {
					System.out.println("Invalid Option.");
				}
			}
		}
		//so far same as admin, might remove this duplicate code
		while(Session.currentSession().employeeIsLoggedIn()) {
			System.out.println("Please enter \"logout\", \"customers\" or \"pending accounts\"  to continue.");
			
			if(input.hasNextLine()) {
				String option = input.nextLine();
				
				if(option.equals("pending accounts")) {
					AccountsController.getInstance().INDEX("pending accounts");
				} else if(option.equals("logout")) {
					System.out.println("Signed out.");
					System.exit(0);
				} else if(option.equals("customers")) {
					CustomersController.getInstance().INDEX();
				} else if(option.equals("exit")) {
					System.exit(0);
				} else {
					System.out.println("Invalid Option.");
				}
			}
		}
		
		while(Session.currentSession().customerIsLoggedIn()) {
			System.out.println("Please enter \"logout\" or \"accounts\" to continue.");
			
			if(input.hasNextLine()) {
				String option = input.nextLine();
				
				if(option.equals("accounts")) {
					AccountsController.getInstance().INDEX();
				} else if(option.equals("logout")) {
					System.out.println("Signed out.");
					System.exit(0);
				} else if(option.equals("exit")) {
					System.exit(0);
				} else {
					System.out.println("Invalid Option.");
				}
			}
		}

	}

}
