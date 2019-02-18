package com.revature.Q6;

import java.util.Scanner;

public class EvenSteven {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);			//create scanner on console input stream
		System.out.println("Enter a number: ");			//accept user input for n (the number we wish to know if even)
		int n = sc.nextInt();
		System.out.println(n+" is even: "+checkEven(n));//check if n is even and print
		sc.close();										//be responsible and close input stream
	}
	
	
	/*checkEven
	 * Input	: int
	 * Output	: boolean
	 * Algo		: Using bitwise comparator we check n AND 1
	 * 			  If n is even its binary representation must have
	 * 			  a zero (or false) in its least significant digit (2^0)
	 * 			  When we AND n with 1 (..00001) all other digits will be
	 * 			  zeroed out and we will either get 1 or 0 (if n's lsd is 0 or 1 resp.)
	 * 			  Iff 1 n is even and true will be returned(..001) else vice versa
	 */
	public static boolean checkEven(int n) {
		return (n&1) == 0;
	}
}
