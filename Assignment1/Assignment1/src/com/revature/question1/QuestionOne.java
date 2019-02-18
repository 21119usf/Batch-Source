package com.revature.question1;

public class QuestionOne {
	//Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
	static int[] arr = new int[]{1,0,5,6,3,2,3,7,9,8,4};	//declaring the array, in a slightly pirate way
	static int arrlength = arr.length;						//setting the length of the array as an int
	
	//method for the Display Algorithm
	public static void displayAlg(int[] arr, int arrlength) {
		for (int k = 0; k < arrlength; k++) {		//print order after each sort
			if (k == 0) {
				System.out.print("arr = {" + arr[k] + ", ");//to not clog up the console, I have each iteration on one line
				}											//Sets it up as an array to make it look more complete
			else if (k < arrlength-1) {
			System.out.print(arr[k]+", ");			
			}
			else {
				System.out.println(arr[k] + "}");			//to end the iteration display and not have a comma at the end
			}
		}
	}
	
	//method for the core bubble sort algorithm
	public static void bubbleCore(int[] arr, int arrlength) {
		for (int j = 0; j < arrlength-1; j++) {		//j is used to find the specific number in the array
			if (arr[j] > arr[j+1]) {				//the actual sorter is this if statement, only needed if the number to the right is bigger
				int temp = arr[j];					//temp is just a place to store the arr[j] value so it isn't lost when overwritten
				arr[j] = arr[j+1];						
				arr[j+1] = temp;
			}	
		}
	}
	//Main method
	public static void main(String[] args) {
		System.out.println("========== Original Order ==========");
		displayAlg(arr, arrlength);
		//Actual Bubble Sort
		for(int i = 1; i <= arrlength-1; i++) {				//'i' represents the iteration number, which will only need a maximum of n-1
		
		//core bubble sort algorithm
				bubbleCore(arr,arrlength);							
		//Displaying the results of each iteration
				if (i == arrlength-1) {						//Special case when finished sorting
					System.out.println("=========== Final Order ============");
				}
				else {										//Labeling the iterations
				System.out.println("=========== Iteration " + i + " ============");	
				}
				
				//Same display loop method as above, but now used for each iteration
				displayAlg(arr,arrlength);
		}
		//End of Bubble Sort	
	}	//End of main

}//End of class
