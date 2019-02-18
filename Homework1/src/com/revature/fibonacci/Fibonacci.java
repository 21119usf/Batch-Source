package com.revature.fibonacci;

public class Fibonacci {
	public static void main(String[] args) {
		int stop = 25;
		System.out.println("This is the first " + stop + " of the Fibonacci sequence");
		fib(stop);
		
	}
	public static void fib(int stop) {
		int fib1 = 0;
		System.out.print(fib1 + " ");
		int fib2 = 1;
		System.out.print(fib2 + " ");
		int temp;
		// (i = 0 (initializer); i < stop (conditional); i++ (incrementor)) {
		for(int i = 0; i < stop; i++) {
			temp = fib1;
			fib1 = fib2;
			fib2 = fib2 + temp;
			System.out.print(fib2 + " ");
			
			
		
			
		}
				
	}
	
	
	

}
