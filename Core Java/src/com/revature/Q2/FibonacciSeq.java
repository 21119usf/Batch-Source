package com.revature.Q2;

public class FibonacciSeq {
	//array to hold first 25 fibonacci numbers
	public static int[] fib25 = new int[25];

	public static void main(String[] args) {
		fibonacci();	//populate fib25 array with first 25 fibonacci numbers
		printFib25();	//print static fib25 array
	}
	
	/*fibonacci
	 * Input		: none
	 * Output		: void
	 * Algo			: First hard code the first 2 fibonacci numbers
	 * 			 	  to the static array because we cannot find the third
	 * 				  without them since fib_i = f_(i-1) + fib_(i-2). Then
	 * 				  iterate through the remaining 23 indexes and store the
	 * 				  sum of the prior 2 elements
	 */
	public static void fibonacci() {
		fib25[0] = 0;
		fib25[1] = 1;
		for(int i=2; i< fib25.length; i++) {
			fib25[i] = fib25[i-1] + fib25[i-2];
		}
	}
	
	/*printFib25
	 * Input		: none
	 * Output		: void
	 * Algo			: Iterate through array printing each element
	 */
	public static void printFib25() {
		System.out.println("The first 25 fibonacci numbers:");
		for(int x:fib25)System.out.print(x+" ");
	}

}
