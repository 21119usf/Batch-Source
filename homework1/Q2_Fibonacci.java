package com.revature.homework1;
import java.util.Scanner;

public class Q2_Fibonacci {

	//Finonacci Method
	public static void Fibonacci(int x) {
		int fI = 0; 		// Fibonacci f(N)
		int fJ = 1; 		// Fibonacci f(N+1)
		int fK = fJ+fI;		// Fibonacci f(N+1)+f(N)
		int n = 2;			// iterator
		System.out.println("Fibonacii Squence:");
		
		switch(x) {
		case 1:				// Print only F0
			System.out.println("F0 -->" + fI);
			break;
		case 2:				// Print f0 and f1
			System.out.println("F0 -->" + fI);
			System.out.println("F1 -->" + fJ);
			break;
		default:			// Print complete Fibonacci sequence
			System.out.println("F0 --> " + fI);
			System.out.println("F1 --> " + fJ);
			while(n<x) {
				System.out.println("F" + n + " --> " + fK);
				fI=fJ;		// update f0 to f1
				fJ=fK;		// update f1 to f2
				fK=fJ+fI;	// set new Fibonacci number
				n++;
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner myScanner = new Scanner(System.in);	//Ask user for number of Fibonacci numbers.
		System.out.println("Enter the number of Fibonacci numbers you wish to find: ");
		int fibNum = myScanner.nextInt();
		myScanner.close();
		Fibonacci(fibNum);
	}

}
