package com.revature.view;

import java.util.ArrayList;

import com.reavture.beans.Account;
import com.reavture.beans.User;
import com.revature.input.CustomerPortalHomeInput;
import com.revature.service.UserAccountService;
import com.revature.utilities.OutputUtility;

public class CustomerPortalHomeView implements IsViewable {
	
	User c;
	public CustomerPortalHomeView(User c) {
		this.c = c;
	}

	@Override
	public void display() {
		String spacer = "    ";
		OutputUtility.printHeader("Welcome To The Revature Banking Customer Portal");
		ArrayList<Account> accounts = new UserAccountService(c).getAccounts();
		System.out.println("User: " + c.getUsername());
		for (Account x : accounts) {
			System.out.println("Account Id: " + x.getAccountId());
			System.out.println(spacer + "Joint Account: " + x.isJoint());
			System.out.println(spacer + "Balance: " + x.getBalance());
			System.out.println(spacer + "Status: " + x.getStatus().toString());
		}
		System.out.println("Please Select An Account Number Or Type \" Apply \" to apply");
		new CustomerPortalHomeInput(c).getInput();
	}

}
