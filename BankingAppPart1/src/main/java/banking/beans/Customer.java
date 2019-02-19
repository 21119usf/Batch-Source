package banking.beans;

public class Customer extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4421054980308988116L;
	
	public static final String fileName = "Customers";
	
	public Customer(String userName, String password) {
		this.userName = userName;
		this.passwordHash = password; //this should be hashed eventually
	}
	
	public Customer() {
		
	}

	
	/* Used when signing up, for user name and password requirements */
	public static boolean validUsername(String userName) {
		
		//use regex here
		if(userName.contains(" ") || userName.length() > 20 || userName.length() < 6) {
			return false;
		}
		return true;
		
	}
	
	public static boolean validPassword(String password) {
		
		//use regex here
		if(password.contains(" ") || password.length() > 40 || password.length() < 6) {
			return false;
		}
		return true;
	}
	
	
}
