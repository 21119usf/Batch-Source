package com.revature.bubble;

public class BubbleSort {
	
// main
	public static void main(String[] args) {
		//the initial array 
		int arr[] = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("This is the original sequence: ");
		//
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		BubbleSort(arr);
	}

public static void BubbleSort(int[] arr) {
	int temp;
	for(int i = arr.length - 1; i > 0; i--) {
		for(int j=0; j < i; j++) {
			if(arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}
	
	}
	System.out.println("The new sorted sequence: ");
	for(int i = 0; i < arr.length; i++) {
		System.out.print(arr[i] + ",");
		
	}
	System.out.println();
}
}	
