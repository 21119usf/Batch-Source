package com.reavature.location;

import java.util.ArrayList;
import java.util.Scanner;

import com.revature.beans.Account;
import com.revature.beans.Customer;
import com.revature.io.FileIO;

public class AccountApplication {
	Customer c;

	public AccountApplication(Customer c) {
		super();
		this.c = c;
	}
	
	public void display() {
		ArrayList<Account> accounts = FileIO.getFromFile("accounts.txt");
		ArrayList<Integer> owner = new ArrayList<Integer>();
		owner.add(c.getUserId());
		System.out.println("Please enter opening deposit ammount");
		Scanner in = new Scanner(System.in);
		double input = Double.parseDouble(in.nextLine());
		accounts.add(new Account(accounts.size(), owner, input));
		FileIO.savedata(accounts, "accounts.txt");
		new CustomerPortal(c).display();
	}
}
