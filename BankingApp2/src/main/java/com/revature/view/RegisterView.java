package com.revature.view;

import com.revature.input.RegisterInput;
import com.revature.utilities.OutputUtility;

public class RegisterView implements IsViewable {

	@Override
	public void display() {
		OutputUtility.printHeader("Registration Form");
		int input = new RegisterInput().getInput();
		
	}

}
