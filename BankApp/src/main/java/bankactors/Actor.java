package bankactors;

import java.io.Serializable;

public abstract class Actor implements Serializable 
{
	private static final long serialVersionUID = 7180546653665389518L;
	
	private String firstName;
	private String lastName;
	private long ssn;
	private String address;
	//getters
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public long getSsn() {return ssn;}
	public String getAddress() {return address;}
	//setters
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setSsn(long ssn) {this.ssn = ssn;}
	public void setAddress(String address) {this.address = address;}
	
	
	
	
}
