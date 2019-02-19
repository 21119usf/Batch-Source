package banking.beans;

public class Session {
	
	private static Session instance;
	private Session() {
	}
	
	public static Session currentSession(){
		if(instance == null)
			instance = new Session();
		return instance;	
	}
	private User owner;

	public User getOwner() {
		return owner;
	}
	
	public User Login(User owner) {
		return this.owner = owner;
	}
	
	public boolean isLoggedIn(User user) {
		return owner == user;
	}
	
	public boolean userIsLoggedIn() {
		return owner != null;
	}
	
	public boolean customerIsLoggedIn() {
		return owner.getClass() == Customer.class;
	}
	
	public boolean adminIsLoggedIn() {
		return owner.getClass() == Admin.class;
	}
	
	public boolean employeeIsLoggedIn() {
		return owner.getClass() == Employee.class;
	}
	
	

}
