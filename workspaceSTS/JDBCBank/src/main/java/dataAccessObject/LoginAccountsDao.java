package dataAccessObject;

import java.util.ArrayList;

import beans.LoginAccount;
import java.sql.SQLException;

public interface LoginAccountsDao {
	
	//Create
	public void createLoginAccount(String username, String password) throws SQLException;
	
	//Read
	public ArrayList<LoginAccount> getAllLogins() throws SQLException;
	public LoginAccount getLogin(String username) throws SQLException;
	
	//Update
	public void changeUsername(String username, String newUsername) throws SQLException;
	public void changePassword(String username, String newPassword) throws SQLException;
	
	//Delete
	public void removeLoginAccount(String username) throws SQLException;
	
	//Misc
	public boolean authenticateLogin(String username, String password) throws SQLException;
	public boolean verifyUniqueName(String username) throws SQLException;
}
