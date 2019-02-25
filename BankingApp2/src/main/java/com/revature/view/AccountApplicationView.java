package com.revature.view;

import com.reavture.beans.User;
import com.revature.input.AccountCreationInput;
import com.revature.utilities.OutputUtility;

public class AccountApplicationView implements IsViewable {

	User u;

	public AccountApplicationView(User u) {
		this.u = u;
	}

	@Override
	public void display() {
		OutputUtility.printHeader("Account Creation Form");
		new AccountCreationInput(u).getInput();
	}

}
