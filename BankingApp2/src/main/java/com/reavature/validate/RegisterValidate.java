package com.reavature.validate;

import com.reavture.beans.User;

public class RegisterValidate implements CanValidate {

	private User u;
	
	public RegisterValidate(User u) {
		this.u = u;
	}

	@Override
	public void validate() throws ValidatorException {
		// TODO Auto-generated method stub

	}

}
