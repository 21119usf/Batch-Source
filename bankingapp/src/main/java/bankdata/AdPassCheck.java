package bankdata;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import bankfunctions.Admin;
import bankfunctions.BankMenu;
import bankfunctions.BankMenu2;
import bankfunctions.Customer;

public class AdPassCheck {

	public static void Checks () throws SQLException {
		String q = Admin.adminusr;
		String i = Admin.adminps;
	Scanner userInput2 = new Scanner(System.in);
	System.out.println("Enter your user name ");
	String t =userInput2.nextLine();
	
	System.out.println("Enter your password ");
	String k =userInput2.nextLine();	
		
	
		
		//will be compared to the string value saved
		if(q.equals(t)& i.equals(k)) {
			String enter = Admin.adminid;
			Admin.adminPortal(enter);
			//System.out.println("You have successfully logged in. ");
		}
		else {
			try {
				System.out.println("Your password was incorrect");
				BankMenu.menuStart();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
	
	}
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
}
