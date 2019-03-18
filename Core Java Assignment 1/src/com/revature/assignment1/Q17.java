package com.revature.assignment1;

import java.util.Scanner;

public class Q17 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);//scanner class open
		System.out.println("Enter amount of principal: ");//prompt for amount of principal
		float principal = in.nextFloat();//take in and store float for principal
		System.out.println("Enter the rate of interest: ");//prompt for interest rate
		float rateOfInt = in.nextInt()/100.00f;//take in and store float for interest
		System.out.println("Enter the number of years: ");//prompt for number of years
		int years = in.nextInt();;//take in and store float for time
		//getInterest(principal, rateOfInt, years);
		float interest  = getInterest(principal, rateOfInt, years);//call to get interest
		System.out.printf("The simple interest on this is: $%.2f",interest);
				
	}
	//method to calculate simple interest
	public static float getInterest(float a, float b, int c){//pass along parameters given as imput
		return a*b*c;//return the product of the values to determine simple interest 
	}

}
