package com.revature.example;

public class LoopExample {
/*
 * doWhilex
 * whilex
 * forx
 * if
 * switchx
 */
	
	static int[] myArray = {1,0,5,6,3,2,3,7,9,8}; //10 elements
	
	public static void main(String[] args) {
		
		//do-while
		int index = 0;
		do {
			System.out.println(myArray[index]);
		} while (index-->0);
		
		
		//for loop
		for(int i = 0; i < 10; i++) {
			if (i == 5)                //if statement
				continue;
			System.out.print(myArray[i] + " ");
		}
		
		
		//While loop
		System.out.println();
		index = 0;
		while (myArray[index] != 5) {
			System.out.print(myArray[index++] + " ");
		}
		
		System.out.println();
		
		
		//Switch 
		switch(index) {
		case 0:
			System.out.print(myArray[index++] + " ");
		case 1:
			System.out.print(myArray[index++] + " ");
		case 2:
			System.out.print(myArray[index++] + " ");
		case 3:
			System.out.print(myArray[index++] + " ");
		case 4:
			System.out.print(myArray[index++] + " ");
		case 5:
			System.out.print(myArray[index++] + " ");
		case 6:
			System.out.print(myArray[index++] + " ");
		case 7:
			System.out.print(myArray[index++] + " ");
		case 8:
			System.out.print(myArray[index++] + " ");
		case 9:
			System.out.print(myArray[index++] + " ");
		default:
			System.out.print("Good Job");
		}
	}
}
