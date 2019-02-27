package bankdata;

import java.sql.SQLException;
import java.util.List;

import bankfunctions.Customer;

public class Checks {

public static boolean PassCheck (String y,String e) throws SQLException{
		
		List<Customer> g = Readers.getCustomerInfo();
		
		//System.out.println(g);
		for(int i = 0; i< g.size(); i++){
			//System.out.println(g.get(i).getCustxID());
			if(g.get(i).getUsername().equals(y)& g.get(i).getPassword().equals(e) ) {
				return true;
			}
			
		}
		return false;
	}

public static String f;
public static String idCheck (String y, String e) throws SQLException{
	
	List<Customer> g = Readers.getCustomerInfo();
	
	//System.out.println(g);
	for(int i = 0; i< g.size(); i++){
		//System.out.println(g.get(i).getCustxID());
		if(g.get(i).getUsername().equals(y)& g.get(i).getPassword().equals(e) ) 
			f =g.get(i).getCustxID();
		}
	return f;	
}
	


	
	

	




}
