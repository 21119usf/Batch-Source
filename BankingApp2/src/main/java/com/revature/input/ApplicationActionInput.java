package com.revature.input;

import com.reavature.validate.ValidatorException;
import com.reavture.beans.Account;
import com.revature.service.ApplicationActionService;
import com.revature.utilities.ScannerInstance;

public class ApplicationActionInput implements CanTakeInput {
	
	Account a;
	String input;
	public ApplicationActionInput(Account a) {
		this.a = a;
	}

	@Override
	public int getInput() {
		input = ScannerInstance.scan.next();
		try {
			validate();
			if (input.equalsIgnoreCase("Y")) {
				new ApplicationActionService(a).approveApplication();
			} else if (input.equalsIgnoreCase("N")) {
				new ApplicationActionService(a).denyApplication();
			} else {
				// DO NOTHING
			}
		} catch (ValidatorException e) {
			System.out.println("Invalid Input");
			getInput();
		}
		return 0;
	}

	@Override
	public void validate() throws ValidatorException {
		if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N") || input.equalsIgnoreCase("X")) {
			
		} else {
			throw new ValidatorException("Invalid Input");
		}
	}

	@Override
	public void onInvalidInput(Exception e) {
		// TODO Auto-generated method stub

	}

}
