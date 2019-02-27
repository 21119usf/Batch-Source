package com.revature.util;

public class UserNameRules {
	String userName;
	String password;
	
	
	public UserNameRules(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


	public void UNRules() {
		if (userName == null) {
			Error ("Invaild Input");
		}
		if (userName.length() < 6) {
			Error("Username can not be less then 6 charecters");
		}
		if (userName.length() > 20) {
			Error("Username can not be more then 20 charecters");
		}
		if (password.length() < 6) {
			Error("Password can not be less then 8 charecters long");
		} else if (password.length() > 12) {
			Error("Password can not be longer then 12 charecters");
		}
	}


	private void Error(String string) {
		// TODO Auto-generated method stub
		
	}

}
