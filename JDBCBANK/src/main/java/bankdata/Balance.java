package bankdata;

import java.sql.SQLException;
import java.util.List;

import bankfunctions.Customer;

public class Balance {
	
	public static String money;
	static String names;
public static String baldisplay(String y) throws SQLException {
	
	
List<BankAccInfo> g = Readers.getBankInfo();
	
	//System.out.println(g);
	for(int i = 0; i< g.size(); i++){
		//System.out.println(g.get(i).getCustxID());
		if(g.get(i).getcID().equals(y)) 
			money =g.get(i).getBals();
		}
	
	return money;
}

public static String namedisplay(String y) throws SQLException {
	
	
List<Customer> g = Readers.getCustomerInfo();
	
	//System.out.println(g);
	for(int i = 0; i< g.size(); i++){
		//System.out.println(g.get(i).getCustxID());
		if(g.get(i).getCustxID().equals(y)) 
			names =g.get(i).getName();
		}
	
	return names;
}



}
