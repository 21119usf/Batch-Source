package com.revature.assignment1;

import java.util.Date;
import java.util.Scanner;

public class Q14 {
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//open scanner class
		System.out.println("Please enter a number between 1 and 3");//[prompt for value between 1 and three
		int java = in.nextInt();//take int value
		demoSwitch(java);//call method switch demonstration
		in.close();//close scanner
	}
	//switch method
	public static void demoSwitch(int java) {

		switch(java){//pass int throhg
		case 1:	getSquareRoot();//case one calls square root method
				break;
		case 2:	getDate();//case two calls current date
				break;
		case 3:	splitString();//case three splits
				break;
		default:
			System.out.println("Try again");
		}		
	}
	
	public static void getSquareRoot() {//method to find square root
	
			System.out.println("Enter an integer to find the square root");//prompt for number
			int j=in.nextInt();//input
			System.out.println("The square root of "+j+" is: "+Math.sqrt(j));//found the suare root using Math.sqrt(j)
	}
	
	public static void getDate() {//get date using the Date() utility
		Date date = new Date();//new date object
		System.out.println(date);//display date
	}
	//method to split string
	public static void splitString() {
		String unsplit = "I am learning core java";//unslplit string
		String[] splitted = unsplit.split(" ");//splitted string
		System.out.println("\"I am learning core java\" split in an array results in: ");
		for(String x: splitted) {//enhanced for loop to show splitted string
			System.out.println(x+ " ");
		}
	}
	
}
