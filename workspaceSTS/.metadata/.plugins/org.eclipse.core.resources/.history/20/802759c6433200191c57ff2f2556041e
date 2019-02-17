package beans;

public abstract class User {
	protected String name;
	protected String address;
	protected String email;
	protected String phoneNum;
	protected String userName;		//Must be Unique
	protected transient String password;
	protected int accountNum;		//Must be Unique
	protected int accessLevel;

	
	//Constructors
	public User() {
		this.name = "";
		this.address = "";
		this.email = "";
		this.phoneNum = "";
		this.userName = "";
		this.password = "";
		this.accountNum = -1;
		this.accessLevel = -1;
	}
	
	public User(String name, String address, String email, String phoneNum, String userName, String password,
			int accountNum, int accessLevel) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.phoneNum = phoneNum;
		this.userName = userName;
		this.password = password;
		this.accountNum = accountNum;
		this.accessLevel = accessLevel;
	}
	
	
	//Setters and Getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
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
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public int getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	
	//Printing Methods
	@Override
	public String toString() {
		return "User [Name:" + name + ", Address:" + address + ", E-mail:" + email + ", Phone #:" + phoneNum
				+ ", Username:" + userName + ", Password:" + password + ", Account #:" + accountNum + ", Access Level:"
				+ accessLevel + "]";
	}
	
	public void printPersonalInfo() {
		System.out.println("Name: " + getName()
						+ "\nAddress: " + getAddress()
						+ "\nE-mail: " + getEmail()
						+ "\nPhone #: " + getPhoneNum());
	}
	
	public abstract void printAccountInfo();
}
