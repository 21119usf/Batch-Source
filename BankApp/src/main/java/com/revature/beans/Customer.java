package com.revature.beans;


public class Customer extends User{

	/*Customer inherits from User in order to obtain name,username,password attributes
	 * The customer differs from other users in that it has an accountID as well as a 
	 * possible linked to another customer in the case of a joint account. The accountID
	 * is used to link the customers account.
	 * 
	 */
	private static final long serialVersionUID = 3881003350521595152L;
	private int accountID;
	private boolean isActivated;
	private Customer c2;
	
	
	public Customer getC2() {
		return c2;
	}

	public void setC2(Customer c2) {
		this.c2 = c2;
	}

	public Customer(String name, String username, String password) {
		super(name, username, password);
		this.isActivated = false;
	}
	
	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public boolean checkActivated() {
		return isActivated;
	}

	public void activate() {
		this.isActivated = true;
	}
	
	@Override
	public String toString() {
		String joint = "";
		if(c2 != null) {
			joint = "\n\tJoint with	: "+c2.getUsername();
		}
		String c = 	"Customer - \n\tName		: "+this.getName()+
					"\n\tUsername 	: "+this.getUsername()+
					"\n\tPassword	: "+this.getPassword()+
					joint+
					"\n\tAccount ID	: "+this.getAccountID()+"\n";
		return c;
	}
	
	
	
	
}
