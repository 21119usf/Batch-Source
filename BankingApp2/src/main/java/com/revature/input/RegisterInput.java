package com.revature.input;

import java.util.Scanner;

import com.reavature.validate.ValidatorException;
import com.reavture.beans.User;
import com.reavture.beans.UserRole;
import com.revature.service.UserEntryService;
import com.revature.utilities.ScannerInstance;

public class RegisterInput implements CanTakeInput {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String SSN;
	private String email;

	@Override
	public int getInput() {
		Scanner scan = ScannerInstance.scan;
		System.out.print("Username: ");
		username = scan.next();
		System.out.print("Password: ");
		password = scan.next();
		System.out.print("First Name: ");
		firstName = scan.next();
		System.out.print("Last Name: ");
		lastName = scan.next();
		System.out.print("Social Security Number: ");
		SSN = scan.next();
		System.out.print("Email: ");
		email = scan.next();
		try {
			validate();
			User u = new User();
			u.setEmail(email);
			u.setFirstName(firstName);
			u.setLastName(lastName);
			u.setUsername(username);
			u.setSSN(SSN);
			u.setRole(UserRole.customer);
			new UserEntryService().register(u, password);
			// 	new CustomerPortalHomeView(u).display();
		} catch (ValidatorException e) {
			onInvalidInput(e);
		}
		return 0;
	}

	@Override
	public void validate() throws ValidatorException {
		if (username.length() < 8) {
			throw new ValidatorException("Username must be greater then 8 charecters");
		}
		if (username.length() > 25) {
			throw new ValidatorException("Username must be less then 25 charecters");
		}
		if (password.length() < 8) {
			throw new ValidatorException("Password must be greater then 8 charecters");
		}
		if (password.length() > 25) {
			throw new ValidatorException("Password must be less then 25 charecters");
		}
		if (firstName.length() < 2) {
			throw new ValidatorException("First Name must be greater then 1 charecters");
		}
		if (firstName.length() > 25) {
			throw new ValidatorException("First Name must be less then 25 charecters");
		}
		if (lastName.length() < 2) {
			throw new ValidatorException("Last Name must be greater then 1 charecters");
		}
		if (lastName.length() > 25) {
			throw new ValidatorException("Last Name must be less then 25 charecters");
		}
		if (SSN.length() != 9) {
			throw new ValidatorException("Social Security Number must be 9 charecters long");
		}
		if (email.length() < 4) {
			throw new ValidatorException("Email Invalid");
		}

	}

	@Override
	public void onInvalidInput(Exception e) {
		System.out.println(e.getMessage());
		getInput();
	}

}
