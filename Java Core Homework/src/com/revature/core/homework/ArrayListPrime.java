package com.revature.core.homework;

import java.util.ArrayList;
// #9
public class ArrayListPrime {
	public static ArrayList<Integer> primeList(int num) {
		// ArrayList to populate all numbers 1 to n
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		// ArrayList to populate primeNumbers
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		// populating numbers 1 to n
		for (int i = 1; i <= num; i ++) {
			numberList.add(i);
		}
		// populating primes between 1 to n
		for (int x : numberList) {
			if (ArrayListPrime.isPrime(x)) {
				primeList.add(x);
			}
		}
		return primeList;
	}
	
	// checks if n is prime
	public static boolean isPrime(int n) {
		// i = 2 because we know any number is divisible by one
	    for(int i = 2; i < n; i ++) {
	    	// A prime is only divisible evenly by itself one 
	        if(n % i ==0) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static void main(String[] args) {
		for (int x : primeList(100)) {
			System.out.println(x);
		}
	}
}
