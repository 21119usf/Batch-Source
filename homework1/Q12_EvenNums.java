package com.revature.homework1;

public class Q12_EvenNums {

	public static void main(String[] args) {
		System.out.println("All even numbers from set 1 to 100");
		System.out.println("----------------------------------");
		int[] myArray = new int[100];
		for(int i=0; i<myArray.length;i++) {
			myArray[i]=i+1;
		}
		for(int n:myArray) {
			if(n%2==0) {
				System.out.println(n);
			}
		}
	}

}
