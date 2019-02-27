package com.revature.menu;

import com.revature.input.MainMenuInput;
import com.revature.util.InputScan;

public class IntroMenu {
	
	public void FirstMenu() {
	
	
		
	System.out.println();
	System.out.println("  WELCOME  ");
	System.out.println();
	System.out.println("A. Customer");
	/*System.out.println("B. Employee");*/
	System.out.println("C. Admin");
	System.out.println();
	System.out.println("D. New Customer");
	System.out.println();
	System.out.println("E. Exit");
	System.out.println();
	System.out.println("Enter an option: ");
	String input = InputScan.scan.nextLine();
	new MainMenuInput().SwitchIntro(input);
	
	}

}
