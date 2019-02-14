package com.revature.corejava;

import java.util.ArrayList;

// Q19 solution
public class Q19 {
	// Generate ArrayList<Integer> from 1 to n
	public static ArrayList<Integer> generateList(int n) {
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
	
	// Adds all even numbers in ArrayList<Integer>
	public static int addEvens(ArrayList<Integer> al) {
		int sum = 0;
		for (int i : al) {
			if (i%2 == 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	// Adds all odd numbers in ArrayList<Integer>
	public static int addOdds(ArrayList<Integer> al) {
		int sum = 0;
		for (int i : al) {
			if (i%2 != 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	// Removes prime numbers from ArrayList<Integer> and adds remaining ints
	public static int removePrimesThenAdd(ArrayList<Integer> al) {
		// Remove primes
		for (int i=0; i<al.size(); i++) {
			if (isPrime(al.get(i))) {
				al.remove(i);
			}
		}
		displayList(al);
		
		// Sum the rest
		int sum = 0;
		for (int i : al) {
			sum += i;
		}
		return sum;
	}
	
	// Display ArrayList<Integer>
	public static void displayList(ArrayList<Integer> al) {
		for (int i : al) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	// Main
	public static void main(String[] args) {
		int n = 10;
		ArrayList<Integer> al = generateList(n);
		displayList(al);
		System.out.println(addEvens(al));
		System.out.println(addOdds(al));
		System.out.println(removePrimesThenAdd(al));
	}
}
