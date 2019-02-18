package com.revature.hw1;

public class Prob2FibSequence {

	public static void main(String[] args) {
		int fib1 = 0;
		int fib2 = 1;
		int fib3 = 0;
		
	 System.out.println("Fibbonachi first 25 numbers");  
     for(int i=0; i < 25; i++){
    	 System.out.print(fib1 + " ");
    	 fib3 = fib1+fib2;
    	 fib1 = fib2;
    	 fib2 = fib3;
               
     }  }
}
