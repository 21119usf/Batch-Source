package com.revature.interfaces;

import java.sql.SQLException;

public interface CreateNewAccountInterface {
	public void createNewAccount(String fName, String lName, String DOB, String str, String city, String st,String cell,String email,
			String usr, String pass) throws SQLException;
}
