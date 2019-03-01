// David Lavoie Revature Assignment 1 Q17
package q17;

import java.util.Scanner;

public class SimpleInterest {
	
	double interest;
	
	//Constructor
	SimpleInterest(double Principal, double rate, double time) {
		this.interest = Principal * rate * time; 
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the simple interest calculator!");
		System.out.println("What was the Principal on the loan?");
		double p = in.nextDouble();
		System.out.println("What was the rate of interest?");
		double r = in.nextDouble();
		System.out.println("How long did you have the loan?");
		double t = in.nextDouble();
		SimpleInterest myinterest = new SimpleInterest(p,r,t);
		System.out.println("You paid " + myinterest.interest + " in interest for the loan.");
		in.close();
		
	}
}
