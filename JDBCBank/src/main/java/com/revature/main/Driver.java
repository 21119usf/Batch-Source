package com.revature.main;

import com.revature.options.AdminOptions;
import com.revature.options.Apply;
import com.revature.options.CustomerOptions;
import com.revature.options.MainOptions;

public class Driver {

	public static void main(String[] args) {
		boolean end = false;
		while(!end) {
			String choice = MainOptions.homeScreen();
			if(choice.equals("1")) {
				int cid = CustomerOptions.login();
				CustomerOptions.custMenu(cid);
			}else if(choice.equals("2")) {
				AdminOptions.login();
				AdminOptions.adminMenu();
			}else if(choice.equals("3")) {
				Apply.apply();
			}else if(choice.equals("quit")){
				end = true;
			}else {
				System.out.println("That is not a valid input");
			}
		}
	}
}
