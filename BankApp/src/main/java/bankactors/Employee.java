package bankactors;

import java.util.ArrayList;
import java.util.Random;

import account.Account;

public class Employee extends Actor
{
	private static final long serialVersionUID = -38938952630852801L;
	private int empID;
	private String username;
	private String password;
	private ArrayList<Account> accounts;
	
	//constructor
	public Employee(String username, String password, String firstName, String lastName) 
	{
		Random r = new Random();
		empID = r.nextInt(100);
		setUsername(username);
		setPassword(password);
		setFirstName(firstName);
		setLastName(lastName);
		accounts = new ArrayList<Account>();
	}
	
	//getters
	public int getEmpID() {return empID;}
	public String getUsername() {return username;}
	public String getPassword() {return password;}
	public ArrayList<Account> getAccounts() {return accounts;}
	//setters
	public void setEmpID(int empID) {this.empID = empID;}
	public void setUsername(String username) {this.username = username;}
	public void setPassword(String password) {this.password = password;}
	public void setAccounts(ArrayList<Account> accounts) {this.accounts = accounts;}
	
}
