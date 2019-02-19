package banking.beans;

import java.io.Serializable;

public abstract class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3273009316752941648L;
	
	protected String userName;
	protected String passwordHash;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
	
	@Override
	public String toString() {
		return "[" + userName + "]";
	}
	
	
	

	
	
	

}
