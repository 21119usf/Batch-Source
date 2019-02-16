package beans;

public class Admin extends Employee {

	//Constructors
	public Admin() {
		super();
		this.accessLevel = 0;
	}
	
	public Admin(String name, String address, String email, String phoneNum, String userName, String password,
			int accountNum) {
		super(name, address, email, phoneNum, userName, password, accountNum, -1);
		this.accessLevel = 0;
	}

}
