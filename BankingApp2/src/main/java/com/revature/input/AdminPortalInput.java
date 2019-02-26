package com.revature.input;

import com.reavature.validate.ValidatorException;
import com.revature.utilities.ScannerInstance;
import com.revature.view.AdminPortalView;
import com.revature.view.ApplicationsActionView;
import com.revature.view.HomeView;

public class AdminPortalInput implements CanTakeInput {

	String input;
	@Override
	public int getInput() {
		System.out.println("Please Select An Option");
		input = ScannerInstance.scan.next();
		try {
			validate();
		} catch (ValidatorException e) {
			onInvalidInput(e);
		}
		return 0;
	}

	@Override
	public void validate() throws ValidatorException {
		switch (input) {
			case "1":
				new ApplicationsActionView().display();
				new AdminPortalView().display();
				break;
			case "2":
				new HomeView().display();
			default:
				throw new ValidatorException("Invalid Input");
		}

	}

	@Override
	public void onInvalidInput(Exception e) {
		System.out.println(e.getMessage());
		getInput();
	}

}
