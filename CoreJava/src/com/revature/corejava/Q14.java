package com.revature.corejava;

import java.util.Calendar;
import java.util.Date;

// CoreJava question 14
public class Q14 {
	// Switch statement
	public static void switchMe(int n) {
		switch (n) {
		case 1:
			System.out.println("Square root of 144 is " + (int)Math.sqrt(144));
			break;
		case 2:
			Date today = Calendar.getInstance().getTime();
			System.out.println(today);
			break;
		case 3:
			String str = "I am learning Core Java";
			String[] sArr = str.split(" ");
			for (String s : sArr) {
				System.out.println(s);
			}
			break;
		default:
			System.out.println("Not an option");
			break;
		}
	}
	
	// Main
	public static void main(String[] args) {
		switchMe(1);
		switchMe(2);
		switchMe(3);
	}
}
