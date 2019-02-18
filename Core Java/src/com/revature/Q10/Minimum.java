package com.revature.Q10;

import java.util.Scanner;

public class Minimum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);					//Create scanner on console input stream
		System.out.println("Enter a number: ");					//Get user input for a & b
		int a = in.nextInt();
		System.out.println("Enter another number: ");
		int b = in.nextInt();
		System.out.println("Minumun of 2 numbers: "+min(a,b)); 	//Print result of min function
		in.close();												//Close scanner
	}
	/*min
	 * Input	: int, int
	 * Output	: int
	 * Algo		: return min of 2 numbers using ternary operator
	 * 			  conditional ? statement to return if true : statement to return if false
	 */
	public static int min(int a, int b) {
		return (a < b ? a : b);
	}
}
