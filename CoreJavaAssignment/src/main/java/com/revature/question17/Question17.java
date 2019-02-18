package com.revature.question17;

import java.util.Scanner;

public class Question17 {

	//Write a program that calculates the simple interest 
	//on the principal, rate of interest and number of years 
	//provided by the user. Enter principal, rate and time 
	//through the console using the Scanner class.
	//Interest = Principal* Rate* Time

	static Scanner input = new Scanner(System.in);
	public static int principal;
	public static int time;
	public static int rate;
	
	public static void simpleInterest(int a, int b, int c) {
		int interest = a*b*c;
		System.out.println("The total interest that will be paid on the loan is: $" + interest);
	}
	
	public static void main(String[] args) {
		System.out.println("What is your principal?");
		principal = input.nextInt();
		
		System.out.println("What is your interest rate?");
		rate = input.nextInt();
		
		System.out.println("How long will your loan payments last?");
		time = input.nextInt();
		
		simpleInterest(principal, rate, time);
	}

}
