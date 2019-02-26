package com.revature.input;

import com.reavature.validate.LoginValidator;
import com.reavature.validate.ValidatorException;
import com.revature.service.UserEntryService;
import com.revature.utilities.LoggerUtil;
import com.revature.utilities.Props;
import com.revature.utilities.ScannerInstance;
import com.revature.view.AdminPortalView;

public class LoginInput implements CanTakeInput {
	private String username;
	private String password;

	public int getInput() {
		System.out.println("Please Enter Credentials");
		System.out.print("Username: ");
		username = ScannerInstance.scan.next();
		System.out.print("Password: ");
		password = ScannerInstance.scan.next();
		try {
			validate();
			if (username.equals(Props.getProps().getProperty("admin_username")) &&
					password.equals(Props.getProps().getProperty("admin_password"))) {
				LoggerUtil.LOGGER.info("Admin Log In Attempt");
				new AdminPortalView().display();
			} else {
				LoggerUtil.LOGGER.info(username + ": " +"Log In Attempt");
				new UserEntryService().login(username, password);
			}
		} catch (ValidatorException e) {
			onInvalidInput(e);
		}
		return 1;
	}

	public void validate() throws ValidatorException {
		new LoginValidator(username, password).validate();
	}

	public void onInvalidInput(Exception e) {
		System.out.println(e.getMessage());
		getInput();
	}

}
