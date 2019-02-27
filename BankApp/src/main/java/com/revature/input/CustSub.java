package com.revature.input;

import com.revature.menu.CustomerMenu;
import com.revature.submenu.CheckBalance;
import com.revature.submenu.DepositMunny;
import com.revature.submenu.WithdrawMunny;
import com.revature.util.InputScan;

public class CustSub {
	
public void SwitchCustSub(String input) {
		
		input = InputScan.scan.nextLine();
		
		switch(input.toUpperCase()) {
		
		case "A":
			new CheckBalance().ShowBalance();
			break;
			
		case "B":
			new DepositMunny().deposit();
			break;
			
		case "C":
			new WithdrawMunny().withdraw();
			break;
			
		case "D":
			System.out.println();
			System.out.println();
			break;
			
		case "E":
			System.out.println("Good Bye");
			System.exit(0);
			break;
		
			
		default:
			System.out.println("Invalid Option, please enter another.");
			new CustomerMenu().CustMenu();
			break;
		}
		
		
	}

}
