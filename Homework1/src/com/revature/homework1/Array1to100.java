package com.revature.homework1;

import java.util.ArrayList;

public class Array1to100 {
	
	public static boolean prime(int n) {//method test an input as long as its above 1 and test
										//to see if the number is prime, if it is we return the value of true
	if(n <=1) {
		return false;
		}
	for(int i = 2; i <= Math.sqrt(n);i++) {
		if(n%i == 0) {
			return false;
		}
	}
	return true;
	}
	
	
	public static void primeList(int a) {// create an array list that will be populated with the prime 
										//we loop through the numbers 1-100 and add prime numbers to the arraylist
		
	
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i <=a;i++) {
			if(prime(i)) {
				list.add(i);
			}
		}
		System.out.println(list);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	primeList(100);
	}

}
