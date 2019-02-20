package com.reavature.location;

import java.util.ArrayList;
import java.util.Scanner;

import com.reavature.service.AccountsService;
import com.revature.beans.Account;
import com.revature.beans.Admin;

public class ViewApplications {
	
	private Admin a;
	
	public ViewApplications(Admin a) {
		super();
		this.a = a;
	}

	public void display() {
		System.out.println("Pennding Applications");
		System.out.println("Please type in the id of the account you wish to view");
		ArrayList<Account> pendingAccounts = AccountsService.getPendingAccounts();
		for (Account x: pendingAccounts) {
			System.out.println("Id: " + x.getId());
		}
		parseInput(pendingAccounts);
	}
	
	private void parseInput(ArrayList<Account> pendingAccounts) {
		Scanner in = new Scanner(System.in);
		int input = Integer.parseInt(in.nextLine());
		for (Account x: pendingAccounts) {
			if (x.getId() == input) {
				System.out.println("Account " + x.getId() + " Selected");
				new ApplicationAction(x, a).display();
				return;
			}
		}
		System.out.println("Invalid Input");
		display();
	}
}
