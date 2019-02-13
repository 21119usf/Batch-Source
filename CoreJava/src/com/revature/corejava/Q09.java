package com.revature.corejava;

import java.util.ArrayList;

public class Q09 {
	// Creates an array from 1 to n
	public static ArrayList<Integer> createNumArray(int n) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i=1; i<=n; i++) {
			al.add(i);
		}
		return al;
	}
	
	// Check if n is prime
	public static boolean isPrime(int n) {
		boolean flag = true;
		for (int i=2; i<=n/2; i++) {
			if (n%i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	// Returns prime numbers in int array
	public static ArrayList<Integer> getPrimes(ArrayList<Integer> al) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		
		for (int i=0; i<al.size(); i++) {
			if (isPrime(al.get(i))) {
				primes.add(al.get(i));
			}
		}
		return primes;
	}
	
	// Main
	public static void main(String[] args) {
		ArrayList<Integer> al = createNumArray(100);
		ArrayList<Integer> primes = getPrimes(al);
		System.out.println(primes);
	}
}
