package banking.beans;

public class Admin extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4561846158178679162L;
	public static final String fileName = "Admins";
	
	public Admin(String userName, String password) {
		this.userName = userName;
		this.passwordHash = password; //this should be hashed eventually
	}
	
	public Admin() {
		
	}

}
