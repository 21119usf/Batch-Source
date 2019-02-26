package com.revature.view;

import java.util.ArrayList;

import com.reavture.beans.Account;
import com.reavture.beans.User;
import com.revature.input.CustomerAccountPageInput;
import com.revature.utilities.OutputUtility;

public class CustomerAccountPage implements IsViewable {

	Account a;
	ArrayList<Account> accounts;
	User u;
	public CustomerAccountPage(Account a, ArrayList<Account> accounts, User u) {
		this.a = a;
		this.accounts = accounts;
		this.u = u;
	}

	@Override
	public void display() {
		OutputUtility.printHeader("Account Action Page");
		System.out.println("Account Id: " + a.getAccountId());
		System.out.println("Balance: " + a.getBalance());
		System.out.println("Status: " + a.getStatus());
		System.out.println("Please Select An Action");
		System.out.println("1) Deposit");
		System.out.println("2) Withdraw");
		System.out.println("3) Close");
		System.out.println("4) Logout");
		new CustomerAccountPageInput(a, accounts, u).getInput();
	}

}
