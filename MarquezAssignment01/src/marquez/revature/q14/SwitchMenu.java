package marquez.revature.q14;

import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;

/* Write a program that demonstrates the switch case. Implement the following functionalities in
 * the cases:java
 * Case 1: Find the square root of a number using the Math class method.
 * Case 2: Display today’s date.
 * Case 3: Split the following string and store it in a string array.
 * “I am learning Core Java”
 */

public class SwitchMenu 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Choose an option:\n1. Find a square root"
							+"\n2. Display today's date"
							+"\n3. Splitting the string \"I am learning Core Java\" and storing it in an array");
		int choice = scan.nextInt();
		// switch statement for the menu 
		switch(choice)
		{
			case 1:
				System.out.println("Input a number:");
				int num = scan.nextInt();
				num = (int) Math.sqrt(num);
				System.out.println("The square root of the number inputed is " + num);
				break;
			case 2:
				Date today = Calendar.getInstance().getTime();
				System.out.println("Today's date is " + today);
				break;
			case 3:
				String phrase = "I am learning Core Java";
				String[] strArray = phrase.split(" ", 5);
				for(String s : strArray)
				{
					System.out.println(s);
				}
				break;
			default:
				System.out.println("Input a number between 1-3");
				break;
				
		}
		scan.close();
	}
}
