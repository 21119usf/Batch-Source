package com.revature.view;

import com.revature.input.AdminPortalInput;
import com.revature.utilities.OutputUtility;

public class AdminPortalView implements IsViewable {

	@Override
	public void display() {
		OutputUtility.printHeader("Welcome To The Revature Banking Admin Portal");
		System.out.println("1) Applications");
		System.out.println("2) View/Users");
		System.out.println("3) Create Users");
		new AdminPortalInput().getInput();
	}

}
