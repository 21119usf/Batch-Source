package com.revature.homework;

public class Q13 {
	
	public static void main(String[] args) {
		
		for (int i=1; i<5; i += 1)
		{
		    for (int j=0; j<i; j++)
		    {
		    	System.out.print(((j+i)%2)+" ");
		    }
		    System.out.println("");
		}
	}
}
