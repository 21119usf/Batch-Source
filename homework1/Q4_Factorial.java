package com.revature.homework1;
import java.util.Scanner;

public class Q4_Factorial {

	//Factorial Method
	public static int Factorial(int n) {
		int i = 0;			// iterator
		int fact = 1;		// to hold factorial
		while(i<n) {
			fact*= (n-i);	// factorial sequence
			i++;
		}
		return fact;

	}
	
	public static void main (String [] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Enter an integer to find it's factorial: ");
		int factorNum = myScanner.nextInt();
		myScanner.close();
		int factorial  = Factorial(factorNum); // assign the returned value to factorial for printing
		System.out.println(factorNum + "! = " + factorial);
	}
}
