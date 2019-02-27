package com.revature.input;

import java.sql.SQLException;

import com.revature.menu.AdminLogin;
import com.revature.menu.AdminMenu;
import com.revature.menu.CustLogin;
import com.revature.menu.IntroMenu;
import com.revature.menu.NewCustomer;

public class MainMenuInput {
		
		
		public void SwitchIntro(String input) {
			
			//String input = InputScan.scan.nextLine();
			
			switch(input.toUpperCase()) {
			
			case "A":
				try {
					new CustLogin().CustLogMenu();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				new CustomerMenu().CustMenu();
				break;
				
			/*case "B":
				new EmployLogin().EmployLogMenu();
				new EmployeeMenu().EmployMenu();
				break;*/
				
			case "C":
				new AdminLogin().AdLogMenu();
				new AdminMenu().AdMenu();
				break;
				
			case "D":
				new NewCustomer().NewCustMenu();
				break;
				
			case "E":
				System.out.println("Good Bye");
				System.exit(0);
				break;
			
				
			default:
				System.out.println("Invalid Option, please enter another.");
				new IntroMenu().FirstMenu();
				break;
			}
			
			}

}
