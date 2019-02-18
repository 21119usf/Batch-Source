package com.revature.Q17;

import java.util.Scanner;

public class SimpleInterest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);			// Create Scanner on console input stream and accept input from user
		System.out.println("===================Simple Interest On Principle================");
		System.out.print("\nEnter principle: ");
		double p = sc.nextDouble();
		System.out.print("\nEnter interest rate as %: ");
		double i = sc.nextDouble();
		System.out.print("\nEnter time in years: ");
		double t = sc.nextDouble();
		System.out.print("\nIntrest earned: $"+String.format("%.2f", simpleInterest(p,i,t)));	//Call simple interest and print
		sc.close();																				//Close scanner
	}
	
	/*simpleInterest
	 * Input	: double, double, double
	 * Output	: double
	 * Alog		: simple math- amount_earned = (interest)/100 * principal * time
	 * 			  where interest is a percent,
	 * 			  principle is in dollars
	 * 			  time is in years
	 */
	public static double simpleInterest(double p, double i, double t) {
		return (i/100)*p*t;
	}
}
