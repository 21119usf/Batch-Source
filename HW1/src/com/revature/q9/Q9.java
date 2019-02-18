package com.revature.q9;

import java.util.ArrayList;

public class Q9 {

	public static void main(String[] args) {
		
		ArrayList<Integer> hundred = new ArrayList<Integer>();
		
		for(int i = 1; i <= 100; i++) {
			hundred.add(i);
			//System.out.println(hundred);
			if(isPrime(i)) {
				System.out.println(i + " is prime");
			}
		}

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
