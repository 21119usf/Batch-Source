package beans;

public class Employee extends User {
	
	
	//Constructors
	public Employee() {
		super();
		this.accessLevel = 1;
	}
	
	public Employee(String name, String address, String email, String phoneNum, String userName, String password,
			int accountNum) {
		super(name, address, email, phoneNum, userName, password, accountNum, 1);
	}
	
	
	//Printing Methods
	@Override
	public String toString() {
		return "Employee [\nName: " + name + "\nAddress: " + address + "\nE-mail: " + email + "\nPhone #: " + phoneNum
				+ "\nUsername: " + userName + "\nPassword: " + password + "\nAccount #: " + accountNum + "\nAccess Level: "
				+ accessLevel + "\n]";
	}
	
	@Override
	public void printAccountInfo() {
		System.out.println("Username: " + getUserName()
						+ "\nPassword: " + getPassword()
						+ "\nAccount #: " + getAccountNum()
						+ "\nAccess Level: " + getAccessLevel());
	}
}
