package com.revature.input;

import com.reavature.validate.ValidatorException;
import com.reavture.beans.Account;
import com.reavture.beans.User;
import com.revature.service.UserAccountService;
import com.revature.utilities.ScannerInstance;
import com.revature.view.CustomerPortalHomeView;

public class AccountCreationInput implements CanTakeInput {
	
	User u;
	String joint;
	double ammount;
	Account a;

	public AccountCreationInput(User u) {
		this.u = u;
		this.a = new Account();
	}

	@Override
	public int getInput() {
		System.out.print("If Joint Account Enter The User Id of The Co-owner Else Type  \" x \": ");
		joint = ScannerInstance.scan.next();
		System.out.print("Please Enter Opening Deposit: ");
		ammount = Double.parseDouble(ScannerInstance.scan.next());
		try {
			validate();
			new UserAccountService(u).createAccount(a);
			new CustomerPortalHomeView(u).display();
		} catch (ValidatorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void validate() throws ValidatorException {
		if (ammount < 0) {
			throw new ValidatorException("Opening Balance Can Not Be 0 or Less");
		}
		setAccount();
	}

	@Override
	public void onInvalidInput(Exception e) {
		// TODO Auto-generated method stub

	}
	
	public void setAccount() {
		a.setPrimaryOwner(u.getId());
		if (joint.equals("x") == false) {
			a.setSecondaryOwner(Integer.parseInt(joint));
		}
		a.setBalance(ammount);
	}

}
