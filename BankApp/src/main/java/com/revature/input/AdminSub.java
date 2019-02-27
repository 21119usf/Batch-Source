package com.revature.input;

import com.revature.submenu.ApproveDeny;
import com.revature.submenu.DeleteAccount;
import com.revature.submenu.UpdateAccount;
import com.revature.submenu.ViewAccount;
import com.revature.util.InputScan;

public class AdminSub {
	
	public void SwitchCustSub() {
		
		String input = InputScan.scan.nextLine();
		
		switch(input) {
		
		case "A":
			new ViewAccount().View();
			break;
			
		case "B":
			new ApproveDeny().AppDenAcct();
			break;
			
		case "C":
			new DeleteAccount().DelAcct();
			break;
			
		case "D":
			new UpdateAccount().UpAcct();
			break;
			
		case "E":
			System.out.println("Good Bye");
			System.exit(0);
			break;
		
			
		default:
			System.out.println("Invalid Option, please enter another.");
			break;
		}
		
		
	}

}
