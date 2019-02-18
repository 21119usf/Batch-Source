package com.revature.homework1;

public class BubbleSort {
	
	public static void printArray(int[] array) { //method that takes in an int array as a parameter
		for(int i = 0; i < array.length;i++) {// we then iterate through the array and print out 
			System.out.println(array[i]);	// each element at the current index in the array
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] myArray= {1,0,5,6,3,2,3,7,9,8,4}; // establishes int array with values
		
		
		
		/*
		 * we iterate through a loop while we remain below the length of the actual array and begin
		 * at index i so we know we will compare every value again after we iterate through the nested loop,
		 * we then iterate through a nested for loop to begin comparing the numbers side by side 
		 * starting at index a. if the number at index a is greater than the number at index a+1 then we swap the values.
		 */
		for(int i = 0; i < myArray.length - 1;i++) { 
			for(int a = 0; a< myArray.length-i-1; a++) {
				if(myArray[a] > myArray[a+1]) {
					int temp = myArray[a];
					myArray[a] = myArray[a+1];
					myArray[a+1] = temp;
				}
			}
			
			
		}
		printArray(myArray); //method call to print array
		

	}

}
