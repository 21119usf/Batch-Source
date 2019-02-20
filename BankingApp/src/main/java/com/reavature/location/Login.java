package com.reavature.location;

import com.reavature.service.UserService;
import com.revature.beans.Admin;
import com.revature.beans.Customer;
import com.revature.beans.Employee;
import com.revature.beans.User;

public class Login {
	public void runner() {
		System.out.println("Please Login");
		User u = UserService.login();
		if (u instanceof Customer) {
			new CustomerPortal((Customer) u).display();
		} else if (u instanceof Admin) {
			new AdminPortal((Admin) u).display();
		} else if (u instanceof Employee) {
			new EmployeePortal((Employee) u).display();
		}
	}
}
