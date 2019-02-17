// Q1. Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4

package com.revature.cja;

public class BubbleSort {
	
	// unsorted array
	private int[] bubbleSortArray = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
	
	// bubble sort method
	public void bubbleSort() {
        for (int i = 0; i < bubbleSortArray.length - 1; i++) {
            for (int j = 0; j < bubbleSortArray.length - i - 1; j++) {
                if (bubbleSortArray[j] > bubbleSortArray[j + 1]) {
                    int temp = bubbleSortArray[j];
                    bubbleSortArray[j] = bubbleSortArray[j + 1];
                    bubbleSortArray[j + 1] = temp;
                }
            }
        }
	}
	
	// get array method
	public int[] getArr() {
		return bubbleSortArray;
	}
}
