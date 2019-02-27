package bankdata;

public class BankAccInfo {

	private String account;
	private String bals;
	 private String cID;
	 
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBals() {
		return bals;
	}

	public void setBals(String bals) {
		this.bals = bals;
	}

	public String getcID() {
		return cID;
	}

	public void setcID(String cID) {
		this.cID = cID;
	}

	
	 
	@Override
	public String toString() {
		return "BankAccInfo [account=" + account + ", bals=" + bals + ", cID=" + cID + "]";
	}

	public BankAccInfo(String accID, String balance, String custID) {
		super();
		this.account = accID;
		this.bals = balance;
		this.cID = custID;
	}
	
	
}
