package com.revature.homework1;

import java.util.ArrayList;
/*
 * This program takes in an int amount to know how many numbers we want to test are even. in this case
 * 100. we then loop through an array to add the amount of numbers to it specified by the "user"
 * We then use an enhance for loop to iterate through the array and if the number at the index divided by
 * two has a remainder of zero, we know it is even and print it to the console.
 */
public class EvenNumsEnhanceFor {
	static int theCount = 1;
	public static void findtheEvens(int x){
		//ArrayList<Integer> fullList = new ArrayList<Integer>();
		int[] arrayFull = new int[x];
		
		for(int i = 0;i < arrayFull.length;i++) {
			arrayFull[i] = theCount;
			//System.out.println(arrayFull[i]);
			theCount++;
		}
		for(int element : arrayFull) {
			if(element % 2==0) {
				System.out.println(element);
			}
		}		
		}
	
	
	
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findtheEvens(100);
	}

}
