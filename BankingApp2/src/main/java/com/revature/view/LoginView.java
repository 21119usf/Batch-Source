package com.revature.view;

import com.reavture.beans.User;
import com.revature.input.LoginInput;
import com.revature.service.UserEntryService;
import com.revature.utilities.OutputUtility;

public class LoginView implements IsViewable {

	@Override
	public void display() {
		OutputUtility.printHeader("Please Enter Your Login Credentials");
		int input = new LoginInput().getInput();
	}

}
