package com.reavature.validate;

/*
 * Class that is used to validate a users login credentials
 */
public class LoginValidator implements CanValidate {
	String username;
	String password;
	
	

	public LoginValidator(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}



	public void validate() throws ValidatorException {
		if (username == null) {
			throw new ValidatorException("Username can not be null");
		}
		if (username.length() < 8) {
			throw new ValidatorException("Username can not be less then 8 charecters long");
		}
		if (username.length() > 25) {
			throw new ValidatorException("Username can not be longer then 25 charecters");
		}
		if (password.length() < 8) {
			throw new ValidatorException("Password can not be less then 8 charecters long");
		} else if (password.length() > 25) {
			throw new ValidatorException("Password can not be longer then 25 charecters");
		}
	}

}
