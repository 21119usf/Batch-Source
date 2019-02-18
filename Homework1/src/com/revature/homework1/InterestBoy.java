package com.revature.homework1;
import java.util.*;

public class InterestBoy {
	/*
	 * this program reads input from the user and ask for a principle amount, a rate of interest
	 * and how many years we will be calculation interest for. once we have the input our calculateInterest method
	 * converts the entered rate to an actual percentage and then initialize a loop to calculate the interest
	 * for how many years the user input. the interest is calculated yearly and displayed to the user 
	 * with two decimal places
	 */
		public static void calculateInterest(double princ, double rate, int year) {
			double yearlyInterest; 
			double total = princ;
			double decimalRate = rate/100;
			
			System.out.println(princ + ":  yearly interest is " + decimalRate);
			for(int i = 1; i <= year; i++) {
				yearlyInterest = total * decimalRate;
				total += yearlyInterest;
				System.out.println("After year " + i + " " + (String.format("%.2f",total)));
				
			}
			
			
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner getInfo = new Scanner(System.in);
		System.out.println("This program will calculate interest, with input from you!");
		System.out.println("Please enter a principal amount: ");
		double prince = getInfo.nextDouble();
		System.out.println("Please enter a rate of interest: ");
		double rates = getInfo.nextDouble();
		
		System.out.println("Please enter a number of years: ");
		int years = getInfo.nextInt();
		
		calculateInterest(prince, rates, years);
		
		
		
	}

}
