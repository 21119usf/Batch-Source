package com.revature.corejava;

// Class to sort an array using bubble sort
public class Q01 {
	private int[] arr;
	
	// Default constructor
	Q01() {
		this.arr = new int[]{1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
	}
	
	// Constructor to assign input to array
	Q01(int[] inputArr) {
		this.arr = inputArr;
	}
	
	// Print array
	public void printArray() {
		for (int i:this.arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	// Sort array
	public void bubbleSort() {
		for (int i=0; i<this.arr.length-1; i++) {
			for (int j=0; j<this.arr.length-i-1; j++) {
				if (this.arr[j] > this.arr[j+1]) {
					int tmp = this.arr[j];
					this.arr[j] = this.arr[j+1];
					this.arr[j+1] = tmp;
				}
			}
		}
	}
	
	// Main
	public static void main(String[] args) {
		// Default
		Q01 q0 = new Q01();
		q0.printArray();
		q0.bubbleSort();
		q0.printArray();
		
		// Custom input
		int[] array = {0, 5, 10, 15, 20, 25, 45, 40, 30, 35};
		Q01 q1 = new Q01(array);
		q1.printArray();
		q1.bubbleSort();
		q1.printArray();
	}
}
