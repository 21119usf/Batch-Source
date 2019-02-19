package banking.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import banking.Driver;
import banking.IO;
import banking.beans.Customer;
import banking.beans.Session;

public class CustomersController extends BaseController<Customer> {
	
	private static CustomersController instance;
	private CustomersController() {
	}
	
	public static CustomersController getInstance(){
		if(instance == null)
			instance = new CustomersController();
		return instance;	
	}

	@Override
	public Customer NEW(String ... args) {
		
		//error message
		if(args != null && args.length > 0) {
			System.out.println(args[0]);
		}
		
		String userName = "";
		String password = "";
		Scanner input = Driver.input;
		while(!Customer.validUsername(userName)) {
			System.out.println("Please enter a valid username. Must be 6-20 alphabetical characters long with no spaces.");
			if(input.hasNextLine()) {
				userName = input.nextLine();
				if(userName.equals("exit")) {
					System.exit(0);
				}
			}
		}
		
		while(!Customer.validPassword(password)) {
			System.out.println("Please enter a valid password. Must be 6-40 characters long with no spaces.");
			if(input.hasNextLine()) {
				password = input.nextLine();
				if(password.equals("exit")) {
					System.exit(0);
				}
			}
		}
		
		return CREATE(userName, password);
	}

	@Override
	public Customer CREATE(String ... args) {
		Customer newcus = new Customer(args[0], args[1]);
		
		ArrayList<Customer> ob = new ArrayList<Customer>();
		ob = IO.ReadFile(Customer.fileName, ob);
		
		for(Customer cus : ob) {
			if(cus.getUserName().equals(args[0])) {
				NEW("Username already taken"); //go to new action again
				//System.out.println("Username already taken.");
				return null;
			}
		}
		
		ob.add(newcus);
		
		IO.writeFile(Customer.fileName, ob);
		System.out.println("Your account has been created.");
		Session.currentSession().Login(newcus);
		SHOW(newcus.getUserName());
		return newcus;
	}

	@Override
	public Customer SHOW(String ... args) {
		ArrayList<Customer> ob = new ArrayList<Customer>();
		ob = IO.ReadFile(Customer.fileName, ob);
		
		if(Session.currentSession().customerIsLoggedIn()) {
			for(Customer cus : ob) {
				if(cus.getUserName().equals(args[0])) {
					System.out.println("Welcome " + cus.getUserName());
					AccountsController.getInstance().INDEX();
					return cus;
				}
			}
			
			
		} else if(Session.currentSession().employeeIsLoggedIn() || Session.currentSession().adminIsLoggedIn()) {
			for(Customer cus : ob) {
				if(cus.getUserName().equals(args[0])) {
					System.out.println(cus.getUserName() + "'s Profile");
					AccountsController.getInstance().INDEX(cus.getUserName());
					return cus;
				}
			}
		}
		return null;
	}

	@Override
	public void INDEX(String... args) {
		ArrayList<Customer> ob = new ArrayList<Customer>();
		ob = IO.ReadFile(Customer.fileName, ob);
		
		System.out.println("Customers:");
		for(Customer cus : ob) {
			System.out.print(cus.toString() + " ");
		}
		System.out.println("");
		System.out.println("Enter a customer name.");
		Scanner input = Driver.input;
		boolean validOption = false;
		
		
		while(validOption == false) {
			if(input.hasNextLine()) {
				String option = input.nextLine();
				
				if(option.equals("exit")) {
					return;
				} else {
					for(Customer cus : ob) {
						if(cus.getUserName().equals(option)) {
							CustomersController.getInstance().SHOW(option);
							return;
						}
					}
					System.out.println("Invalid customer name.");
				}
			}
		}
		
		
	}

	@Override
	public Customer EDIT(String ... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer UPDATE(Customer arg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DELETE(String ... args) {
		// TODO Auto-generated method stub
		
	}

}
