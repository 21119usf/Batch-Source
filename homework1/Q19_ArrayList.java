package com.revature.homework1;

import java.util.ArrayList;

public class Q19_ArrayList {
	public int evenSum(ArrayList<Integer> list) {
		int sum = 0;
		for(int i=0; i<list.size();i++) {
			if(list.get(i)%2==0) {
				sum+=list.get(i);
			}
		}
		return sum;
	}
		
	public int oddSum(ArrayList<Integer> list) {
		int sum = 0;
		for(int i=0; i<list.size();i++) {
			if(list.get(i)%2!=0) {
				sum+=list.get(i);
			}
		}
			return sum;
	}
	
	
	public ArrayList<Integer> removePrimes(ArrayList<Integer> list){
		//ArrayList<Integer> noPrimes = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>(FindPrimeNumbers.primeNumbers(list));
		for(int i=0; i<list.size();i++) {
			for(int n=0; n<primes.size();n++) {
				if(list.get(i)==primes.get(n)) {
					list.remove(list.get(i));
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args){
		Q19_ArrayList lt = new Q19_ArrayList();
		FindPrimeNumbers myPrimes = new FindPrimeNumbers();
		ArrayList<Integer> myList = new ArrayList<Integer>();
		for(int i=1; i<=10;i++) {
			myList.add(i);
		}
		System.out.print("Original List: " + myList);
		//myList.forEach(Integer-> System.out.print(Integer+ " "));
		System.out.println();
		System.out.println("Sum of Evens is: " + lt.evenSum(myList));
		System.out.println("Sum of Odds is: " + lt.oddSum(myList));
		System.out.println("Primes are: " + myPrimes.primeNumbers(myList)); 
		System.out.println("New list without Primes: " + lt.removePrimes(myList));
		
	}
}
