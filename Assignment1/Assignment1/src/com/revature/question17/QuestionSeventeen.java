package com.revature.question17;

import java.util.Scanner;

//Q17. Write a program that calculates the simple interest on the 
//principal, rate of interest and number of years provided by the user. 
//Enter principal, rate and time through the console using the Scanner class.
//Interest = Principal* Rate* Time


public class QuestionSeventeen {

	public static void main(String[] args) {
		//initializing scanner
		Scanner input = new Scanner(System.in);
		
		//input various parameters, in int and double
		System.out.println("Enter the principle amount: ");
		int p = input.nextInt();
		System.out.println("Enter the interest rate, in percent: ");
		double r = input.nextDouble()/100;
		System.out.println("Enter the number of years: ");
		int t = input.nextInt();
		//actual interest formula
		double interest = p * r * t;
		//continously compounded interest formula, for fun; not included because not asked for
		/*double E = 2.71818;
		double expo = r*t;
		double compint = p * Math.pow(E, expo);*/
		
		//outputting result
		System.out.println("The interest earned after " + t + " years is " + interest);

	}

}
