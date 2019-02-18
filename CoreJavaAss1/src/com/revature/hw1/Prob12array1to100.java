package com.revature.hw1;

public class Prob12array1to100 {

	
	
	
	public static void main(String[] args) 
	{
		//established array length to 100 spaces
	    int[] numbers = new int[100];
		for (int i = 0; i < numbers.length; i++) 
		{
			//array stores 1 to 100
			numbers [i] = i+1;
		}
		
		for (int i: numbers) 
		{
		    //tests to see if it is even and prints out even numbers
		    if (numbers[i]%2 == 0) 
		    {
			System.out.println(numbers[i]);
			}
		    //not sure where the indexoutofbounds exception is coming from
		    
		}
		
	}
	
		
	
	
	
	
	
	}


		
		
		
		
		
	


