package beans;

public class User {
	protected String name;
	protected String address;
	protected String email;
	protected String phoneNum;
	protected String userName;		//Must be Unique
	protected transient String password;
	protected int accountNum;		//Must be Unique
	protected int accessLevel;

	
	//Constructor
	public User(String name, String address, String email, String phoneNum, String userName, String password,
			int accountNum, int accessLevel) {
		super();
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

	
	//What will be printed out when placed in a print method
	@Override
	public String toString() {
		return "User [name=" + name + ", address=" + address + ", email=" + email + ", phoneNum=" + phoneNum
				+ ", userName=" + userName + ", password=" + password + ", accountNum=" + accountNum + ", accessLevel="
				+ accessLevel + "]";
	}
}
