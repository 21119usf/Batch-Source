package com.revature.beans;

public class Employee extends User{

	/*Employee is a simple POJO inheritting from User
	 * 
	 */
	private static final long serialVersionUID = -7203981731471761848L;

	public Employee() {
		super();
	}

	public Employee(String name, String username, String password) {
		super(name, username, password);
	}

	@Override
	public String toString() {
		String c = 	"Employee - \n\tName		: "+this.getName()+
				"\n\tUsername 	: "+this.getUsername()+
				"\n\tPassword	: "+this.getPassword()+"\n";
	return c;
	}
	
	
	

}
