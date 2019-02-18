package com.revature.insert;

import java.util.ArrayList;

public class Insert {
	
/*Modules:
 * 
 * create array
 * create array display
 * create even method
 * create odd method
 * find prime
 * 
 */
	
//create the array
public static ArrayList<Integer> createList(int n){
	ArrayList<Integer> arr = new ArrayList<Integer>();
	for(int i = 1; i<=n ; i++) {
		arr.add(i);
		
	}
	return arr;
}
public static void displayArray(ArrayList<Integer> arr) {
	for(int i : arr) {
		System.out.print(i + " ");
		
	}
	System.out.println();
}
public static int addEvens(ArrayList<Integer> arr) {
	int sum = 0;
	for(int i : arr) {
		if(i%2 == 0) {
			sum += i;
		}
	}
	return sum;
}
public static int addOdds(ArrayList<Integer> arr) {
	int sum = 0;
	for(int i : arr) {
		// not equaled too
		if(i%2 != 0) {
			sum +=i;
		}
	}
	return sum;
}
public static boolean isPrime(int n) {
	boolean check = true;
	for(int i=2; i<=n/2; i++) {
		if(n%i == 0) {
			check = false;
			break;
		}
	}
	return check;
}
public static int separatePrimes(ArrayList<Integer> arr) {
	for(int i=0; i<arr.size(); i++) {
		if(isPrime(arr.get(i))) {
			arr.remove(i);
		}
	}
	displayArray(arr);
	int sum = 0;
	for(int i : arr) {
		sum += i;
	}
	return sum;
}


	public static void main(String[] args) {
		int n = 10;
		ArrayList<Integer> arr = createList(n);
		displayArray(arr);
		System.out.println("Even: "+addEvens(arr));
		System.out.println("Odds: "+addOdds(arr));
		System.out.println("Primes: "+separatePrimes(arr));

	}

}

