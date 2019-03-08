package com.revature.question16;

public class Question16 {

	//Write a program to display the number of characters for a string input. 
	//The string should be entered as a command line argument using (String [ ] args).
	
	public static void main(String[] args) {
		
		String total = "";
		for(int i = 0; i < args.length; i++) {
			total += args[i] + " ";
		}
		System.out.println("Number of characters from string input: " + (total.length()-1));
	}

}
