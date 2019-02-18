package com.revature.Q4;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);					//Create new scanner object specific to system.in input stream
		System.out.println("Enter a number to factorialize: ");	//Get user input
		int n = sc.nextInt();
		int nFactorial = factorial(n);							//Find n! and print
		System.out.println(n+"! = "+nFactorial);
		sc.close();   											//close input stream
	}
	
	/*factorial
	 * Input	: int
	 * Output	: int
	 * Algo		: iterate n number of times each time i is
	 * 			  increased by 1 and gets multiplied by result
	 * 			  and saved back into result, thus result = (n-1)*(n-2)...2*1 
	 */
	public static int factorial(int n) {
		int result = 1;
		for(int i=1; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}
