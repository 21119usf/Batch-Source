package com.revature.input;


import com.reavature.validate.ValidatorException;
import com.revature.utilities.ScannerInstance;

public class HomeInput implements CanTakeInput {
	String input;

	public int getInput() {
		int choice = 0;
		input = ScannerInstance.scan.nextLine();
		try {
			validate();
		} catch (ValidatorException e) {
			onInvalidInput(e);
		}
		try {
		choice = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			onInvalidInput(e);
		}
		return choice;
	}

	public void validate() throws ValidatorException {
		if (input.equals("1")) {
			// Do Nothing
		} else if (input.equals("2")) {
			// Do Nothing
		} else {
			throw new ValidatorException("Invalid Input");
		}
	}

	public void onInvalidInput(Exception e) {
		System.out.println("Invalid Input");
		getInput();
	}

}
