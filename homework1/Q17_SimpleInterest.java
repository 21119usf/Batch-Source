package com.revature.homework1;

import java.util.Scanner;

public class Q17_SimpleInterest {

	public static void main(String[] args) {

	Scanner myScanner = new Scanner(System.in);
	System.out.println("Enter Principal: ");
	double pVal = myScanner.nextDouble();
	System.out.println("Enter Interest rate: ");
	double rVal = myScanner.nextDouble();
	System.out.println("Enter Time: ");
	double tVal = myScanner.nextDouble();
	myScanner.close();
	
	double simpleInterest = pVal*(1+(rVal*tVal));
	System.out.println("Simple Interest = " + simpleInterest);
	}

}
