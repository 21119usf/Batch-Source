package com.revature.view;

import com.revature.input.HomeInput;
import com.revature.utilities.OutputUtility;

public class HomeView implements IsViewable {

	@Override
	public void display() {

		OutputUtility.printHeader("Welcome To The Revature Banking Portal");
		System.out.println("Please Select An Option");
		System.out.println("1) Login");
		System.out.println("2) Register");
		System.out.println("3) Exit");
		HomeInput hi = new HomeInput();
		int input = hi.getInput();
		if (input == 1) {
			new LoginView().display();
		} else if (input == 2) {
			new RegisterView().display();
		} else if (input == 3) {
			System.exit(0);
		}
	}

}
