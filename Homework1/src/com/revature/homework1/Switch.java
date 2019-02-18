package com.revature.homework1;
import java.util.Date;

public class Switch {
	
	/*
	 * theSwitch method uses a switch statement to compare a user input to different cases
	 * if the input is a 1, we will find the square root of a hardcoded number
	 * if the input is a 2, we display todays date
	 * if the input is a 3, we split at string at each delimiter of " " a space, and put it into an array 
	 * of strings and print out the result of whichever case is tested
	 */
	
	public static void theSwitch(int x) {
		int a = x;
		switch(a) {
		
		case 1:  int root = (int) Math.sqrt(9);
				 System.out.println(root);
		break;
		
		case 2: Date todaysDate = new Date();
				System.out.println(todaysDate.toString());
		
		break;
		
		case 3:	String str = "I am learning core java";
				String[] strArray = str.split(" ");
				for(int i =0;i<strArray.length;i++) {
					System.out.println(strArray[i]);
				}
		break;
			
			
		}
	}

	public static void main(String[] args) {//implementation of the switch methods
		// TODO Auto-generated method stub
		theSwitch(1);
		System.out.println(" ");
		theSwitch(2);
		System.out.println(" ");
		theSwitch(3);
	}

}
