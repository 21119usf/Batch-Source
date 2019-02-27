package com.revature.view;

import com.revature.input.LoginInput;
import com.revature.utilities.OutputUtility;

public class LoginView implements IsViewable {

	@Override
	public void display() {
		OutputUtility.printHeader("Please Enter Your Login Credentials");
		new LoginInput().getInput();
	}

}
