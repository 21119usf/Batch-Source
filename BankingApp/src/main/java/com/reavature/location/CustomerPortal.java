package com.reavature.location;

import java.util.ArrayList;
import java.util.Scanner;

import com.reavature.service.AccountsService;
import com.revature.beans.Account;
import com.revature.beans.AccountStatus;
import com.revature.beans.Customer;

public class CustomerPortal {
	Customer c;
	
	public CustomerPortal(Customer c) {
		this.c = c;
	}
	public void display() {
		System.out.println("Welcome to revature customer portal");
		ArrayList<Account> accounts = AccountsService.getUsersAccounts(c.getUserId());
		if (accounts.size() == 0) {
			System.out.println("You have no accounts. type (apply) to apply for one");
		} else {
			for (Account x : accounts) {
				System.out.println(x);
				System.out.println("ID: " + x.getId() + "Balance: " + x.getBalance());
			}
		}
		parseInput();
	}
	
	public void parseInput() {
		Scanner in = new Scanner(System.in);
		String input = in.next();
		
		if (input.equals("apply")) {
			new AccountApplication(c).display();
			return;
		} else if (AccountsService.getAccountById(Integer.parseInt(input)) != null) {
			Account a = AccountsService.getAccountById(Integer.parseInt(input));
			if (a.getStatus() != AccountStatus.open) {
				System.out.println("This account is not open. Your application is still pending");
				display();
			}
			new AccountActionCustomer(a).display();
		}
	}
}
