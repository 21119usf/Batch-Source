package com.revature.assignment1;

import java.util.ArrayList;

public class Q9 {

	public static void main(String[] args) {
		
		ArrayList<Integer> arr = new ArrayList<Integer>();//arraylist for integer objects
		for(int i=1;i<=100;i++) {//enhanced for to add valueof each number
			arr.add(i);
		}
		displayPrime(arr);//call to method to display prime number
	}

	public static void displayPrime(ArrayList<Integer> a) {//method to display prime
		
		//here using nested for starting at 2 since that is the smallest prrime
		for(int i = 2;i<=a.size()-1;i++) {
			for(int j = 1;j<=i;j++) {//iterate through
				if(i==a.get(j)) {
					System.out.println(a.get(j));
				}
				if(i%a.get(j)==0) {//if that number leaves a remainder then break inner for loop iteration
					break;
				}
			}

		}
	}
}
