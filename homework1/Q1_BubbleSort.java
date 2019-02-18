package com.revature.homework1;
//Terrence Thomas
// Performs Bubble Sort on the passed in Integer Array

public class Q1_BubbleSort {

	//Bubblesort Method
	public static Integer[] bubbleSort(Integer[] array) {
		//Loop through each element
		for(int i=0; i<array.length-1; i++) {
			//compare each element to its adjacent right
			for(int n=0; n<array.length-i-1; n++) {
				// check that it is smaller
				if(array[n]>array[n+1]) {
					int temp = array[n]; 	// hold the larger value
					array[n]=array[n+1];	// swap values
					array[n+1]=temp;		// update adjacent right to larger value
				}
			}
		}
		return array;
	}
	
	public static void main (String [] args) {
		Integer[] myArray = {1,0,5,6,3,2,3,7,9,8,4};
		Integer[] sortedArray = bubbleSort(myArray);
		for(int i=0; i<myArray.length; i++) {
			System.out.print(sortedArray[i]);	
		}
	}
}