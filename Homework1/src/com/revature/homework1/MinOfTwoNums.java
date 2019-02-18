package com.revature.homework1;
/*
 * This class shows us the minimum of two numbers using the ternary operator. it test parameters
 * entered in the findMin method. the minimum number is then output.
 */
public class MinOfTwoNums {
	static int min;
	public static int findMin(int a, int b) {
		 min = (a < b) ? a : b;			//if a is less than b, we print out a other wise we print out b
		return min;
	}
	
	public static void showMin(int x) {
		System.out.println(x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showMin(findMin(5,10));
		showMin(findMin(10,9));
		showMin(findMin(-5,5));
	}

}
