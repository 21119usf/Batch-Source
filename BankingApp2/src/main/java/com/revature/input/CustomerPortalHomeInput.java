package com.revature.input;

import java.util.Scanner;

import com.reavature.validate.ValidatorException;
import com.reavture.beans.User;
import com.revature.utilities.ScannerInstance;
import com.revature.view.AccountApplicationView;

public class CustomerPortalHomeInput implements CanTakeInput {

	private String input;
	private User u;
	
	public CustomerPortalHomeInput(User u) {
		this.u = u;
	}

	@Override
	public int getInput() {
		Scanner scan = ScannerInstance.scan;
		input = scan.next();
		try {
			validate();
		} catch (ValidatorException e) {
			
		}
		return 0;
	}

	@Override
	public void validate() throws ValidatorException {
		if (input.equals("apply")) {
			new AccountApplicationView(u).display();;
		}
	}

	@Override
	public void onInvalidInput(Exception e) {
		// TODO Auto-generated method stub

	}

}
