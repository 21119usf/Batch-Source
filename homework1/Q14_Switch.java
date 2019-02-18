package com.revature.homework1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Q14_Switch {

	public static void main(String[] args) {
		System.out.println("Find square root: 	Enter 1");
		System.out.println("Display today's date:	Enter 2");
		System.out.println("Split up string: 	Enter 3");
		Scanner myScanner = new Scanner(System.in);
		int x = myScanner.nextInt();
		switch(x) {
			case 1:
				// display squareroot of 25
				System.out.println("The squre root of 25 is: " + Math.sqrt(25));
				break;
			case 2:
				// new date format
				DateFormat format = new SimpleDateFormat("MM/DD/YYYY");
				// data class for finding todays'date
				Date date = new Date();
				// display today's date
				System.out.println("Today's date is: " + format.format(date));
				break;
				
			case 3:
				String str = "I am learning Core java";		// string to split
				String[] s = str.split(" ");				// split the string and store to array
				StringBuilder sb = new StringBuilder("");	// new mutable string
				for(String string:s) {						// fill mutable string with original string words
					sb.append(string + " ");
				}
				String newStr = sb.toString();				// convert builder to a string
				System.out.println(newStr);					// display new string
				break;
		}
		myScanner.close();
	}
}
