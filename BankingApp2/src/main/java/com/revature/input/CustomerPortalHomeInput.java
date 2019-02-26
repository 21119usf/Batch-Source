package com.revature.input;

import java.util.ArrayList;
import java.util.Scanner;

import com.reavature.validate.ValidatorException;
import com.reavture.beans.Account;
import com.reavture.beans.User;
import com.revature.utilities.ScannerInstance;
import com.revature.view.AccountApplicationView;
import com.revature.view.CustomerAccountPage;
import com.revature.view.HomeView;

public class CustomerPortalHomeInput implements CanTakeInput {

	private String input;
	private User u;
	ArrayList<Account> accounts;
	public CustomerPortalHomeInput(User u, ArrayList<Account> accounts) {
		this.u = u;
		this.accounts = accounts;
	}

	@Override
	public int getInput() {
		Scanner scan = ScannerInstance.scan;
		input = scan.next();
		try {
			validate();
		} catch (ValidatorException e) {
			
		}
		return 0;
	}

	@Override
	public void validate() throws ValidatorException {
		if (input.equalsIgnoreCase("apply")) {
			new AccountApplicationView(u).display();
		} else if (input.equalsIgnoreCase("out")) {
			new HomeView().display();
		} else {
			for (Account a : accounts) {
				if (input.equals(String.valueOf(a.getAccountId()))) {
					new CustomerAccountPage(a, accounts, u).display();
					return;
				}
			}
			throw new ValidatorException("Invalid Input");
		}
	}

	@Override
	public void onInvalidInput(Exception e) {
		// TODO Auto-generated method stub

	}

}
