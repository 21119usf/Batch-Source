package com.revature.Q1;

public class BubbleSort {

	public static void main(String[] args) {
		//Create array as per question spec
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		//Sort array
		bubbleSort(array);
		//Print array
		printArray(array);
	}
	
	
	/*bubbleSort
	 * Input		: int array
	 * Output		: void
	 * Algo			: Iterates through array comparing each element to the one in 
	 * 				  front of it and swaps if the former is larger. It will continue 
	 * 				  to iterate through the array until no swaps were made in the 
	 * 				  prior iteration
	 */
	public static void bubbleSort(int[] array) {
		int temp;
		boolean swapped = true;
		while(swapped) {
			swapped = false;
			for(int i = 0; i < array.length - 1; i++) {
				if(array[i] > array[i+1]) {
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					swapped = true;
				}
			}
		}
	}
	
	/*printArray
	 * Input		: int array
	 * Output		: void
	 * Algo			: Iterate through array once
	 * 			  	  and print each element
	 */
	public static void printArray(int[] array) {
		for(int x : array) {
			System.out.print(x+" ");
		}
	}
}
