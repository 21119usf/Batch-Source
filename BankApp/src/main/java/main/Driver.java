package main;

import menu.views.AccountOptions;
import menu.views.AdminOptions;
import menu.views.CustomerOptions;
import menu.views.EmployeeOptions;
import menu.views.MenuOptions;

public class Driver 
{
	public static void main(String[] args) 
	{
		System.out.println("Welcome to the Bank!!!"
	    +"\nWhat are you?");
		// Load data from files
		CustomerOptions.loadCustomers();
		EmployeeOptions.loadEmployees();
		AdminOptions.loadAdmins();
		AccountOptions.loadAccounts();
		int choice = 0;
		choice = MenuOptions.displayMenu();
		
		switch (choice) {
		case 1:		
			System.out.println("Welcome to the Customer Menu!!!");
			MenuOptions.displayCustomerPage();
			break;
		case 2:		
			System.out.println("Welcome to the Employee Menu!!!");
			MenuOptions.displayEmployeePage();
			break;
		case 3:
			System.out.println("Welcome to the Admin Menu!!!");
			MenuOptions.displayAdminPage();
			break;
		case 4:		
			System.out.println("See you until your next transaction");
			return;
		}
	}
}
