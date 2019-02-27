package beans;

public class UserAccount {

	protected int userID;
	protected String firstName;
	protected String lastName;
	protected String streetAddress;
	protected String email;
	protected String phoneNum;
	protected int approval;			//0 = hasn't been approved, 1 = was approved
	protected int isAdmin;			//0 = regular user, 1 = admin

	
	//Constructors
	public UserAccount() {
		this.userID = -1;
		this.firstName = "N/A";
		this.lastName = "N/A";
		this.streetAddress = "N/A";
		this.email = "N/A";
		this.phoneNum = "N/A";
		this.approval = 0;
		this.isAdmin = 0;
	}

	public UserAccount(int userID, String firstName, String lastName, String streetAddress,
			String email, String phoneNum, int approval, int isAdmin) {
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.streetAddress = streetAddress;
		this.email = email;
		this.phoneNum = phoneNum;
		this.approval = approval;
		this.isAdmin = isAdmin;
	}
	
	
	//Mutators and Accessors
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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

	public int getApproval() {
		return approval;
	}

	public void setApproval(int approval) {
		this.approval = approval;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "UserAccount [userID=" + userID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ",\nstreetAddress=" + streetAddress + ", email=" + email + ", phoneNum=" + phoneNum
				+ ",\napproval=" + approval + ", isAdmin=" + isAdmin + "]";
	}
	
	
	
}
