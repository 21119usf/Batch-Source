package bankfunctions;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import bankdata.AdminDao;
import bankdata.Balance;
import bankdata.Checks;
import bankdata.Readers;

public class Admin {

	public static void adminPortal(String s) throws SQLException {
		
		if (s.equals(Admin.adminid) ) {
			List<Customer> userData = Readers.getCustomerInfo();
			Scanner bankScans = new Scanner(System.in);
			System.out.println("Welcome Administrator");
			System.out.println("What would you like to do? \n" + "1.) Create Users 2). View Accounts 3). Delete Users 4). Update Users 5). Logout ");
			String userInput3 = bankScans.nextLine();
			String h = userInput3.toLowerCase();
			
			if (h.equals("1") ) {
				createUser();
			}
			else if (h.equals("2")) {
				System.out.println(userData);
				adminPortal(s);
			}
			
			else if (h.equals("3")) {
				deleteUser();
			}
		
			else if (h.equals("4")) {
				
			}
			else if(h.equals("5")) {
				
				System.out.println("Now Logging off account");
				try {
					BankMenu.menuStart();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else {
				System.out.println("Enter a correct numerical option");
				adminPortal(s);
			}

			}
		else {
			System.out.println("Validation error: Logging out");
			try {
				BankMenu.menuStart();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
 	
 	
 	
	static void createUser(){
		String n = Admin.adminid;
		Registration.personalInfo(n);
		
	}
	
	static void deleteUser() throws SQLException{
		System.out.println("Enter the User ID number of the user you want to delete");
		Scanner bankScans = new Scanner(System.in);
		String userInput3 = bankScans.nextLine();
		Scanner bankScans2 = new Scanner(System.in);
		System.out.println("Are you sure you want to delete this user? " +"1). Yes 2). No");
					String userInput4 = bankScans.nextLine();
		
		
		List<Customer> g = Readers.getCustomerInfo();
			
			//System.out.println(g);
			for(int i = 0; i< g.size(); i++){
				//System.out.println(g.get(i).getCustxID());
				String xx = null;
				if(g.get(i).getCustxID().equals(userInput3)) 
					//write delete method in sql
					xx = g.get(i).getCustxID();
				
					String k = userInput4.toLowerCase();
					if(k.equals("1") || k.equals("yes")) {
						
					AdminDao.deleteUser(xx);
					System.out.println("User is Successfully Deleted");
					adminPortal(adminid);
					
					}
					else {
						System.out.println("Going back to the admin portal");
						adminPortal(adminid);
					}
				}
			
		
		bankScans.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static String adminusr;
 	public static String adminps;
 	public static String adminid;
	
	public static void getAdmins() {
 		
 		Properties prop = new Properties();
 		
 		try {
			prop.load(new FileReader("database.properties"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
 		adminusr = prop.getProperty("adminUser");
 		adminps = prop.getProperty("adminPass");
 		adminid = prop.getProperty("adminID");
 	
 	}
	
	
}
