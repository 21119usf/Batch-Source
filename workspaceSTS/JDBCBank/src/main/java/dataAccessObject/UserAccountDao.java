package dataAccessObject;

import java.util.ArrayList;

import beans.UserAccount;

public interface UserAccountDao {

	//Create
	public void createUserAccount(String firstName, String lastName, String streetAddress,
									String email, String phoneNum, int approval, int isAdmin);
	
	//Read
	public ArrayList<UserAccount> getAllUsers();
	public UserAccount getUser(int userID);
	
	//Update
	public void changeFirstName(int userID, String newFirstName);
	public void changeLastName(int userID, String newLastName);
	public void changeStreetAddress(int userID, String newStreetAddress);
	public void changeEmail(int userID, String newEmail);
	public void changePhoneNum(int userID, String newPhoneNum);
	public void changeApproval(int userID);
	
	//Delete
	public void removeUser(int userID);
}
