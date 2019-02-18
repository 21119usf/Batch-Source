package com.revature.question14;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class Question14 {

	/*
	 * Write a program that demonstrates the switch case. 
	 * Implement the following functionalities in the cases:java
		Case 1: Find the square root of a number using the Math class method.
		Case 2: Display today’s date.
		Case 3: Split the following string and store it in a string array.
       	 “I am learning Core Java”
	 */
	
	static Scanner input = new Scanner(System.in);
	public static int choice;
	public static int square;
	
	
	
	public static void cases(int a) {
		switch(a) {
		case 1:
			System.out.println("Enter value to find square root: ");
			square = input.nextInt();
				System.out.println("The square root of " + square + " is " + Math.sqrt(square));
			break;
		case 2:
			java.util.Date date=new java.util.Date();  
			System.out.println("Todays date is: " + date); 
			break;
		case 3:
			String stored = new String("I am learning Core Java");
			String[] strList = new String[5];
			ArrayList<String> strArray = new ArrayList<>();
			strList = stored.split(" ");
			
			for(int i = 0; i < strList.length; i++) {
				strArray.add(strList[i]);
			}
			System.out.println(strArray);
			break;
		}
	}
	public static void main(String[] args) {
			cases(1);
			cases(2);
			cases(3);
	}
}
