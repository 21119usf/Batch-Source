package core.java.core_questions;

import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class question14 {

public static double squareRoot(int n) {
	return Math.sqrt((double)n);
}

public static void displayDate() {
	Date date = new Date(); 
	String current_date = DateFormat.getDateTimeInstance().format(date);
	System.out.println("Current Date: " + current_date); 
}

public static String[] splitString(String str) {
	String[] string_array = str.split(" ");
	return string_array; 
}

public static void main(String[] args) {
	System.out.println("* Press '1' to find the square \n"
			+ "root of a number using Math class method");
	System.out.println("* Press '2' to display today's date");
	System.out.println("* Press '3' to split the string");
	System.out.println("=====================================");
	//This scanner gives me a warning because Scanner is never closed
	//You can suppress it if you want!
	@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
	System.out.println("Enter number case: ");
	while(in.hasNext()) {
		int c = in.nextInt();
		switch(c) 
		{
		case 1:
			Scanner num = new Scanner(System.in); 
			System.out.println("Enter number to square root it: ");
			int n = num.nextInt(); 
			num.close();
			System.out.println("The Square Root is: " + squareRoot(n));
			break;
		case 2:
			displayDate();
			break;
		case 3:
			System.out.println("This is the string -> "
					+ "I am learning Core Java");
			String str = "I am learning Core Java";
			System.out.println("\nAnd this is the String ARRAY!!");
			for(String s : splitString(str))
				System.out.print(s + "*split*");
			break; 
		default:
			System.out.println("Try again");
			continue; 
		}
	}
	in.close();
	}
}
