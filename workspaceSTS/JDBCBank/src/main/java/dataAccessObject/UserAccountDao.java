package dataAccessObject;

import java.util.ArrayList;

import beans.UserAccount;
import java.sql.SQLException;

public interface UserAccountDao {

	//Create
	public void createUserAccount(int userID, String firstName, String lastName, String streetAddress,
									String email, String phoneNum, int approval, int isAdmin) throws SQLException;
	
	//Read
	public ArrayList<UserAccount> getAllUsers() throws SQLException;
	public ArrayList<UserAccount> getPendingUsers() throws SQLException;
	public ArrayList<UserAccount> getAllRegularUsers() throws SQLException;
	public ArrayList<UserAccount> getAllAdmins() throws SQLException;
	public UserAccount getUser(int userID) throws SQLException;
	
	//Update
	public void changeFirstName(int userID, String newFirstName) throws SQLException;
	public void changeLastName(int userID, String newLastName) throws SQLException;
	public void changeStreetAddress(int userID, String newStreetAddress) throws SQLException;
	public void changeEmail(int userID, String newEmail) throws SQLException;
	public void changePhoneNum(int userID, String newPhoneNum) throws SQLException;
	public void changeApproval(int userID, int approval) throws SQLException;
	
	//Delete
	public void removeUser(int userID) throws SQLException;
}
