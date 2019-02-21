package bank.application.entities;
import java.util.ArrayList;
import java.util.*; 

public class Admin extends Employee {
	private String adminID; 
	private HashMap<Employee, ArrayList<Customer>> set1;
	private int entity_type; 
	
	public Admin(String firstname, String lastname, String address, String userID, String email, String pn) 
 	{
		super(firstname, lastname, address, userID, email, pn);
		Random rd = new Random();
		// TODO Auto-generated constructor stub
		set1 = new HashMap<Employee, ArrayList<Customer>>(); 
		adminID = firstname.charAt(0) + "" + rd.nextInt(9999);
		entity_type = 3; 
	}
	
	public void viewAccounts() {
		
		Set set = set1.entrySet();
 		Iterator iterator = set.iterator();
 		
		while(iterator.hasNext()) {
			
		}
	}
	
	

	
	
 	
 	
	
}
