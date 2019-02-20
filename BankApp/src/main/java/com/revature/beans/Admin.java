package com.revature.beans;

public class Admin extends Employee{

	/*Admin extends employee and thus User. It doesn't have any fields or
	 * meaningful methods. It main use is to differenciate between other users
	 * 
	 */
	private static final long serialVersionUID = -4347772239263541076L;

	public Admin() {
		super();
	}

	public Admin(String name, String username, String password) {
		super(name, username, password);
	}

	@Override
	public String toString() {
		String a = 	"Admin - \n\tName		: "+this.getName()+
				"\n\tUsername 	: "+this.getUsername()+
				"\n\tPassword	: "+this.getPassword()+"\n";
	return a;
	}
	

	
}
