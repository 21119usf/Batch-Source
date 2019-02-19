package banking.beans;

public class Employee extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8458427093919288559L;
	public static final String fileName = "Employees";
	
	public Employee(String userName, String password) {
		this.userName = userName;
		this.passwordHash = password; //this should be hashed eventually
	}
	
	public Employee() {
		
	}

}
