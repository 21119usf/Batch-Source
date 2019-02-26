package com.revature.view;

import com.revature.input.AdminPortalInput;
import com.revature.utilities.OutputUtility;

// Initial View for Admin Portal
public class AdminPortalView implements IsViewable {

	@Override
	public void display() {
		OutputUtility.printHeader("Welcome To The Revature Banking Admin Portal");
		System.out.println("1) Applications");
		System.out.println("2) Log Out");
		new AdminPortalInput().getInput();
	}

}
