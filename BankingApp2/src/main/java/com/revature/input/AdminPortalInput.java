package com.revature.input;

import com.reavature.validate.ValidatorException;
import com.revature.utilities.ScannerInstance;
import com.revature.view.ApplicationsActionView;

public class AdminPortalInput implements CanTakeInput {

	String input;
	@Override
	public int getInput() {
		System.out.println("Please Select An Option");
		input = ScannerInstance.scan.nextLine();
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
				break;
			case "2":
				System.out.println("View/Edit Users");
				break;
			case "3":
				System.out.println("Create User");
				break;
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
