package bankdata;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import bankfunctions.BankMenu;
import bankfunctions.BankMenu2;
import bankfunctions.Customer;

public class PasswordCheck {
	
	public static void checker() throws SQLException {
	List<Customer> g = Readers.getCustomerInfo();	
		
		
		
	Scanner userInput2 = new Scanner(System.in);
	System.out.println("Enter your user name ");
	String t =userInput2.nextLine();
	
	System.out.println("Enter your password ");
	String k =userInput2.nextLine();	
		//check hashmap or file for values 
		String userd = t;
		//String userCheck = readFiler.get(0);
		String passer = k;
		//String passCheck = readFiler.get(1);
		//read from database to get these values
		int l = 1;
		boolean h = true;
		Customer n = indexer(1);
		//userCheck = g.get(l);
		//passCheck = g.get(l);
		//u = n.getUsername();
			// o = n.getPassword();
		
		
		//will be compared to the string value saved
		if(Checks.PassCheck(userd,passer) == true) {
			String q = Checks.idCheck(userd, passer);
			BankMenu2.entry(q);
			//System.out.println("You have successfully logged in. ");
		}
		else {
			try {
				BankMenu.menu1(1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	
	}
	
	static Customer indexer (int y) throws SQLException{
		List<Customer> g = Readers.getCustomerInfo();	
		
	
			Customer man = g.get(y);
			//man.getUsername();
			//man.getPassword();
			
			return man;
		
		
		
		
	}
	
	/*
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
	}*/
	
	
	
}
