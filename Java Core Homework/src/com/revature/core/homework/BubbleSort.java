package com.revature.core.homework;
// #1
public class BubbleSort {
	
	public static int[] sort(int[] arr) {
		// loop through array
	    for (int i = 0; i < arr.length; i++) {
	    	// loop through comparisons to current array element
	        for (int j = 0; j < arr.length - i - 1; j++) {
	        	// if array element has a higher value then the one next to it swap their positions
	          if (arr[j] > arr[j + 1]) {
	            int temp = arr[j];
	            arr[j] = arr[j + 1];
	            arr[j + 1] = temp;
	          }
	        }
	    }
	    return arr;
	}

	public static void main(String[] args) {
		for (int x : sort(new int[] {1,0,5,6,3,2,3,7,9,8,4})) {
			System.out.println(x);
		}
	}

}
