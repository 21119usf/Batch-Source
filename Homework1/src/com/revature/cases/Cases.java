package com.revature.cases;

import java.util.Date;

public class Cases {

	public static void threeCases(int n) {
		//add the current date
		Date d1 = new Date();
		//creates the string variable
		String todaysDate;
		
		
		
		switch (n) {
		case 1:
			//math square root
			double a = 30;
			System.out.println(Math.sqrt(a));
			a = 45;
			System.out.println();
			break;
		case 2:
			//todays date
			todaysDate = "Current date is "+ d1;
			System.out.println(todaysDate);
			break;
			
		case 3:
			//splits the sentence
			String str = "I am learning Core Java";
			String[] arr = str.split(" ");
			for (String d : arr) {
				System.out.println(d);
			}
			break;
		}
		System.out.println();

	}
	//calls the three cases
	public static void main(String[] args) {
		threeCases(1);
		threeCases(2);
		threeCases(3);

	}
}
