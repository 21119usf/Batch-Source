package com.reavature.location;

import java.util.ArrayList;
import java.util.Scanner;

import com.reavature.service.AccountsService;
import com.revature.beans.Account;
import com.revature.beans.AccountStatus;
import com.revature.beans.Admin;
import com.revature.beans.User;
import com.revature.io.FileIO;

public class ApplicationAction {
	private Account a;
	private Admin ad;
	
	
	public ApplicationAction(Account a, Admin ad) {
		super();
		this.a = a;
		this.ad = ad;
	}


	public void display() {
		System.out.println("Owner Details");
		User u = AccountsService.getUser(a);
		System.out.println("First Name: " + u.getFirstName());
		System.out.println("Last Name: " + u.getLastName());
		System.out.println("SSN: " + "*****"  + u.getSSN().substring(5, 9));
		System.out.println("Address: " + u.getAddress());
		parseInput();
	}
	
	private void parseInput() {
		System.out.println("Accept (a), Deny (d), Back To Portal (b)");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch (input) {
			case "a":
				a.setStatus(AccountStatus.open);
				AccountsService.updateAccount(a);
				break;
			case "d":
				a.setStatus(AccountStatus.denied);
				break;
			case "b":
				new AdminPortal(ad).display();
				break;
		}
	}
}
