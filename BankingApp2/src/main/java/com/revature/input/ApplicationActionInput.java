package com.revature.input;

import com.reavature.validate.ValidatorException;
import com.reavture.beans.Account;
import com.revature.utilities.ScannerInstance;

public class ApplicationActionInput implements CanTakeInput {
	
	Account a;
	String input;
	public ApplicationActionInput(Account a) {
		this.a = a;
	}

	@Override
	public int getInput() {
		input = ScannerInstance.scan.nextLine();
		try {
			validate();
			if (input.equals("Y")) {
				System.out.println("APPROVE APPLICATION");
			} else if (input.equals("N")) {
				System.out.println("DENY APPLICATION");
			} else {
				// DO NOTHING
			}
		} catch (ValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void validate() throws ValidatorException {
		if (input.equals("Y") || input.equals("N") || input.equals("X")) {
			
		} else {
			throw new ValidatorException("Invalid Input");
		}
	}

	@Override
	public void onInvalidInput(Exception e) {
		// TODO Auto-generated method stub

	}

}
