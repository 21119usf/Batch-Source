package dataAccessObject;

import java.util.ArrayList;

import beans.LoginAccount;

public interface LoginAccountsDao {
	
	//Create
	public void createLoginAccount(String username, String password, int userID);
	
	//Read
	public ArrayList<LoginAccount> getAllLogins();
	public LoginAccount getLogin(String username);
	
	//Update
	public void changeUsername(String username, String newUsername);
	public void changePassword(String username, String newPassword);
	
	//Delete
	public void removeLoginAccount(String username);
	
	//Misc
	public void authenticateLogin(String username, String password);
	public void verifyUniqueName(String username);
}
