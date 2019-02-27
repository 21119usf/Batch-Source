package bank.beans;

public class Admin
{
	private int adminID;
	private String username;
	private String password;
	
	//getters
	public int getAdminID() {return adminID;}
	public String getUsername() {return username;}
	public String getPassword() {return password;}
	//setters
	public void setAdminID(int adminID) {this.adminID = adminID;}
	public void setUsername(String username) {this.username = username;}
	public void setPassword(String password) {this.password = password;}
	
	@Override
	public String toString() {
		return "Admin [adminID=" + adminID + ", username=" + username + ", password=" + password + "]";
	}
}
