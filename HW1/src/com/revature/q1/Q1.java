package com.revature.q1;

import java.util.Arrays;

public class Q1 {
	public static void main(String[] args) {
		//original array
		int[] originalArray = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println(Arrays.toString(originalArray));
		
		
		//sorted array call the sorting method
		bubbleSort(originalArray);
	}

	public static void bubbleSort(int[] origArr) {

		for(int i = 0; i < origArr.length; i++) {// makes sure to go repeat the iterations for double check the after initial swaps 
			for(int j = 0; j < origArr.length - 1; j++) {// swapping loop
				
				// is the current number greater than the next number if so swap the two numbers
				if(origArr[j] > origArr[j + 1]) {
					//swap origArr[j] and  origArr[j +1] order
					int temp = origArr[j];
					origArr[j] = origArr[j + 1];
					origArr[j +1] = temp;
				}
			}
		}
      //print sorted array
      System.out.println(Arrays.toString(origArr));
	}

}
