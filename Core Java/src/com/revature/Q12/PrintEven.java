package com.revature.Q12;

public class PrintEven {
	public static final int ARR_SIZE = 100;
	
	public static void main(String[] args) {
		int[] arr = createArray(); 	//create array of size 100 and
									//populate with integers from 1 to 100
		printEven(arr);				//Print evens
	}
	/*printEven
	 * Input	: int[]
	 * Output	: void
	 * Algo		: iterate through array with enhanced for loop
	 * 			  check each int if even using modulo, If even print
	 * 			  and add to evens array to allow for Junit testing
	 */
	public static int[] printEven(int[] arr) {
		int[] evens = new int[50];
		int evensCounter = 0;
		for(int i: arr) {
			if(i%2 == 0) {
				System.out.print(i +" ");
				evens[evensCounter++]=i;
				
			}
		}
		return evens;
		
	}
	/*createArray
	 * Input	: none
	 * Output	: int[]
	 * Algo		: iterate through array placing int i+1 at idx i (0 based)
	 */
	public static int[] createArray() {
		int[] arr = new int[ARR_SIZE];
		for(int i = 0; i < ARR_SIZE; i++) {
			arr[i] = i+1;
		}
		return arr;
	}
}
