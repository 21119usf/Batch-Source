package com.revature.core.java.assignment;

import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SwitchActions 
{
	/*
	 * Uses a switch statement to execute certain actions based on a string input.
	 */
	public void performAction(String action)
	{
		switch (action)
		{
		case "sqrt" :
			System.out.println("Please enter a number: ");
			Scanner input = new Scanner(System.in);
			int number = input.nextInt();
			System.out.println(Math.sqrt(number));
			break;
			
		case "date" :
			Calendar calender = Calendar.getInstance();
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			String formattedDate = dateFormat.format(date);
			System.out.println("Todays's Date: " + formattedDate);
			break;
			
		case "split" :
			String unsplitString = "I am learning core Java";
			String[] splitString = unsplitString.split(" ");
			for(String string : splitString)
			{
				System.out.println(string);
			}
			break;
			
		default :
			System.out.println("Not a valid action.");
		}
	}
}
