package bankactors;

import java.util.ArrayList;
import java.util.Random;

import account.Account;

public class Admin extends Actor
{
	private static final long serialVersionUID = -8341287647857135190L;
	private int adminID;
	private String username;
	private String password;
	private ArrayList<Account> accounts;
	
	//constructor
	public Admin(String username, String password, String firstName, String lastName) 
	{
		Random r = new Random();
		adminID = r.nextInt(100);
		setUsername(username);
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		accounts = new ArrayList<Account>();
	}
	
	//getters
	public int getAdminID() {return adminID;}
	public String getUsername() {return username;}
	public String getPassword() {return password;}
	public ArrayList<Account> getAccounts() {return accounts;}
	//setters
	public void setAdminID(int adminID) {this.adminID = adminID;}
	public void setUsername(String username) {this.username = username;}
	public void setPassword(String password) {this.password = password;}
	public void setAccounts(ArrayList<Account> accounts) {this.accounts = accounts;}
	
	
	
	
}
