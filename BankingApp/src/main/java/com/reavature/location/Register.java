package com.reavature.location;

import com.reavature.service.UserService;
import com.revature.beans.Customer;

public class Register {
	public void register() {
		System.out.println("Please enter the inforamtion below to register");
		Customer c = UserService.createCustomer();
		new CustomerPortal(c).display();
	}
}
