package bankfunctions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import bankdata.AdPassCheck;
import bankdata.PasswordCheck;

public class BankMenu {
	//starting menu to enter the app
	
	public static void menuStart() throws IOException{
		
	System.out.println("Welcome, are you a Customer, Admin, or Employee?");
	Scanner userInput = new Scanner(System.in);
	String q =userInput.nextLine();
	
	//takes in
	String h = q.toLowerCase();
	
	if (h.equals("customer") ) {
		menu1(1);
	}
	else if (h.equals("employee")) {
		menu1(2);
	}
	
	else if (h.equals("admin")) {
		menu1(3);
	}
	
	else
	{
		System.out.println("Enter a correct option \n");
		menuStart();
	}
	userInput.close();
	}
	
	
	public static void menu1(int x) throws IOException {
		
		switch(x) {
		//checks the customer class
		case 1: 
			System.out.println("To Register, Press 1.  Customer Login, Press 2.");
			Scanner userInput2 = new Scanner(System.in);
			String v =userInput2.nextLine();
			
			// Map<Integer, String> mapA = new HashMap<Integer, String>();
			//userInput2.close();
			
			if(v.equals("1"))
			{
				String temp = "k";
				System.out.println("you have entered case 1");
				
				  Registration.personalInfo(temp);
				 // g.personalSave();
				
				
			}
			else if(v.contentEquals("2")) {
				 
				 try {
					PasswordCheck.checker();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			else
			{
				System.out.println("Enter a correct input: Select 1 or 2");
				menu1(1);
			}
			break;
			
		case 2:
	
			
			// call employee class
			break;
			
			
			
		case 3:
			try {
				AdPassCheck.Checks();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			//call admin class
			break;
		}
		

}
	}
