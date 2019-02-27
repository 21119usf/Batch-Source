package com.revature.submenu;

import com.revature.people.Customer;
import com.revature.util.InputScan;

public class NewCustomer {
	private Customer c = new Customer();
	
	public void NewCustAcct() {
		
		System.out.println("Please enter your information." );
		System.out.println();
		System.out.println("Username: " );
		String input = InputScan.scan.nextLine();
		c.setUserName(input);
		System.out.println("Password: ");
		input = InputScan.scan.nextLine();
		c.setPassword(input);
		System.out.println();
		
		
	}

}
