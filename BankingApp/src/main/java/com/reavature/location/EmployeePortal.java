package com.reavature.location;

import java.util.ArrayList;
import java.util.Scanner;

import com.reavature.service.AccountsService;
import com.revature.beans.Account;
import com.revature.beans.AccountStatus;
import com.revature.beans.Employee;
import com.revature.beans.User;

public class EmployeePortal {
	Employee e;

	public EmployeePortal(Employee e) {
		this.e = e;
	}
	
	public void display() {
		System.out.println("Welcome to Revature Employee Portal");
		System.out.println("Please Select An Option");
		System.out.println("(1) View Applications");
		System.out.println("(2) View Client Details");
	}

	private void parseInput() {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		switch(input) {
		 	case "1":
		 		viewApplications();
		 		break;
		}
	}
	
	private void viewApplications() {
		Scanner in = new Scanner(System.in);
		ArrayList<Account> accounts = AccountsService.getEmployeeAccounts(e);
		for (Account a: accounts) {
			if (a.getStatus() == AccountStatus.pending) {
				System.out.println("ID: " + a.getId());
			}
		}
		System.out.println("Please Enter An Account Id");
		int input = in.nextInt();
	}
}
