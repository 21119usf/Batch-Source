package beans;

public class LoginAccount {
	
	protected String userName;
	protected String password;
	protected int userID;
	
	//Constructors
	public LoginAccount() {
		this.userName = "N/A";
		this.password = "N/A";
		this.userID = -1;
	}

	public LoginAccount(String userName, String password, int userID) {
		this.userName = userName;
		this.password = password;
		this.userID = userID;
	}

	
	//Mutators and Accessors
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	

}
