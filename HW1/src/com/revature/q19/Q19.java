package com.revature.q19;

import java.util.ArrayList;

public class Q19 {

	public static void main(String[] args) {
		
		ArrayList<Integer> intArrayList = new ArrayList<Integer>();
		
		int sumeven = 0;
		int sumOdd = 0;
		
		for(int i = 0; i < 10; i++) {
			intArrayList.add(i+1); //populating array
			System.out.print(intArrayList.get(i) + " ");
			
			if(intArrayList.get(i)%2 == 0) {
				sumeven = sumeven + intArrayList.get(i); //adding even numbers
			} else {
				sumOdd = sumOdd + intArrayList.get(i); //adding odd numbers
			}
		}
		
		System.out.println("\n");
		
		System.out.println("Sum of even numbers " + sumeven);
		System.out.println("Sum of Odd numbers " + sumOdd);
		
		//removing primes
		for(int i = 0; i < 5; i++) {
			if(isPrime(intArrayList.get(i))) {
				intArrayList.remove(i);
			}
		}
		
		System.out.println(intArrayList.toString()); // print array after all the primes have been removed
		

	}
	
	private static boolean isPrime(int num) {
		//checking for 2
		if(num == 2) {
			return true;
		}
		
		//check n is a multiple of 2
	    if (num % 2 == 0) { 
	    	return false;
	    }
	    
	    //check the odds
	    for(int i = 3; i * i <= num; i += 2) {
	        if(num % i == 0)
	            return false;
	    }
	    return true;
	}

}
