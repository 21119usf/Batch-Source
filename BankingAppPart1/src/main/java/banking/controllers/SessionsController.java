package banking.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import banking.Driver;
import banking.IO;
import banking.beans.Admin;
import banking.beans.Customer;
import banking.beans.Employee;
import banking.beans.Session;

public class SessionsController extends BaseController<Session> {
	
	private static SessionsController instance;
	private SessionsController() {
	}
	
	public static SessionsController getInstance(){
		if(instance == null)
			instance = new SessionsController();
		return instance;	
	}

	@Override
	public Session NEW(String ... args) {
		
		//error message
		if(args != null && args.length > 0) {
			System.out.println(args[0]);
		}
		
		String userName = "";
		String password = "";
		Scanner input = Driver.input;
		System.out.println("Please enter your username.");
		while(!input.hasNextLine());
		if(input.hasNextLine()) { //unnecessary
			userName = input.nextLine();
			if(userName.equals("exit")) {
				System.exit(0);
			}
		}
		
		
	
		System.out.println("Please enter your password.");
		while(!input.hasNextLine());
		if(input.hasNextLine()) {
			password = input.nextLine();
			if(password.equals("exit")) {
				System.exit(0);
			}
		}
			
		
		
		
		CREATE(userName, password);
		return null;
	}

	@Override
	public Session CREATE(String ... args) {
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		customers = IO.ReadFile(Customer.fileName, customers);
		
		for(Customer cus : customers) {
			if(cus.getUserName().equals(args[0])) {
				if(cus.getPasswordHash().equals(args[1])) {
					Session.currentSession().Login(cus);
					CustomersController.getInstance().SHOW(cus.getUserName());
					return Session.currentSession();
				}
				break;
			}
		}
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees = IO.ReadFile(Employee.fileName, employees);
		
		for(Employee emp : employees) {
			if(emp.getUserName().equals(args[0])) {
				if(emp.getPasswordHash().equals(args[1])) {
					Session.currentSession().Login(emp);
					EmployeesController.getInstance().SHOW(emp.getUserName());
					return Session.currentSession();
				}
				break;
			}
		}
		
		ArrayList<Admin> ob = new ArrayList<Admin>();
		ob = IO.ReadFile(Admin.fileName, ob);
		
		for(Admin adm : ob) {
			if(adm.getUserName().equals(args[0])) {
				if(adm.getPasswordHash().equals(args[1])) {
					Session.currentSession().Login(adm);
					AdminsController.getInstance().SHOW(adm.getUserName());
					return Session.currentSession();
				}
				break;
			}
		}
		NEW("Invalid credentials.");
		return null;
	}

	@Override
	public Session SHOW(String ... args) {
		// UNUSED
		return null;
	}

	@Override
	public void INDEX(String... args) {
		// UNUSED
		
	}

	@Override
	public Session EDIT(String ... args) {
		// UNUSED
		return null;
	}

	@Override
	public Session UPDATE(Session arg) {
		// UNUSED
		return null;
	}

	@Override
	public void DELETE(String ... args) {
		// Logout
		
	}

}
