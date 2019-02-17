package beans;

public class Admin extends Employee {

	//Constructors
	public Admin() {
		super();
		this.accessLevel = 0;
	}
	
	public Admin(String name, String address, String email, String phoneNum, String userName, String password,
			int accountNum) {
		super(name, address, email, phoneNum, userName, password, accountNum);
		this.accessLevel = 0;
	}
	
	//Printing Methods
		@Override
		public String toString() {
			return "Administrator [\nName: " + name + "\nAddress: " + address + "\nE-mail: " + email + "\nPhone #: " + phoneNum
					+ "\nUsername: " + userName + "\nPassword: " + password + "\nAccount #: " + accountNum + "\nAccess Level: "
					+ accessLevel + "\n]";
		}

}
