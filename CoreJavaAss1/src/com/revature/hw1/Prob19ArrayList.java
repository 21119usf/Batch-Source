package com.revature.hw1;

import java.util.ArrayList;

public class Prob19ArrayList {

	public static void main(String[] args) {
		
		
		//ArrayList<Integer> numberList = new ArrayList<Integer>();
		//arrayList
//		for(int i = 1; i <= num; i++) {
//			numberList.add(i);
//		}
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		int[] numbers = new int[] {1,2,3,4,5,6,7,8,9,10};
		int[] notPrimeNumbers = new int[7];
		
		for (int i = 0; i < numbers.length; i++) 
		{
			System.out.print(numbers[i] +" ");
		}
		System.out.println();
		
		int evenSum = 0;
		for (int i = 0; i < numbers.length; i++) 
		{
			if (numbers[i]%2 == 0)
				evenSum = numbers[i]+evenSum; 
						
			
		}
		System.out.println("===evens added===");
		System.out.println(evenSum);
		
		//add the odds!!!
		int oddSum = 0;
		for (int i = 0; i < numbers.length; i++) 
		{
			if (numbers[i]%2 == 1)
				oddSum = numbers[i]+oddSum; 
						
			
		}
		System.out.println("===odds added===");
		System.out.println(oddSum);
		 
	        
	    System.out.println("Prime numbers below");
	    System.out.println("=========================");
	    	int x = 0;
	        for(int i = 1; i <= 10; i++) {
	            numberList.add(i);
	            //prints out what is true
	            if (isPrime(i)) {
	            	continue;
	            }
	            else {
		            	notPrimeNumbers[x]=i;
		                System.out.println(notPrimeNumbers[x]);
		                x++;
		             }
	        }

	    }


		//checks for prime number
	//================================================
	    private static boolean isPrime(int x) {
	        //checking for 2
	        if(x == 2) {
	            return true;
	        }

	        //check x is a multiple of 2
	        if (x % 2 == 0) { 
	            return false;
	        }

	        //check the odds
	        for(int i = 3; i * i <= x; i += 2) {
	            if(x % i == 0)
	                return false;
	        }
	        return true;
	    }
		
		
	}


