package bank.application.accounts;
import bank.application.entities.Customer; 
import java.util.UUID; 

public class Account { 
	private int accountID;
	private Customer c; 
	private boolean openJointAccount; 
	private boolean login;  
	
	public Account(Customer c) {
		this.c = c; 
		this.accountID = UUID.randomUUID().clockSequence();
		c.setCustomerID(c.getUserID() + c.getLastname().charAt(0) + c.getFirstname().charAt(0));
		openJointAccount = false;
		login = false; //is_loggedin? 
	}
	
	public void register(String username, String password) {
		c.setUsername(username);
		c.setPassword(password);
		openJointAccount = true; 
		c.setLevel_of_approval(2);
		 System.out.println("Successfully created account for --> " + c.getFirstname() + " " + c.getLastname() + 
				 		  "\nYour Account Number --> " + getAccountID());
	     System.out.println(c.getFirstname() + " " + c.getLastname() + ", you have a balance of $" + c.getBalance());
	}
	
	public void Login(String username, String password) {
		if(c.getUsername() == username) {
				if(c.getPassword() == password) {
						System.out.println("You sucessfully logged in!");
						login = true;
				}
				else {
						System.out.println("You put the wrong password");
				}
			}
		  System.out.println("Your username is incorrect"); 
		  login = false; 
		}
	
	
	//getters and setters
	public Customer getCustomer() {
		return c;
	}

	public void setCustomer(Customer c) {
		this.c = c;
	}
	
	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	//Account info 
	@Override
	public String toString() {
		return c.getFirstname() + " " + c.getLastname() + "'s " + "Account [accountID=" + accountID + " Customer=" + c.getFirstname() + " " + c.getLastname() + ", openJointAccount=" + openJointAccount + "]";
	}
	
	
	
	
}
