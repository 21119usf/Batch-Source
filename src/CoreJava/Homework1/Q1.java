package com.revature.homework;

public class Q1 {
	
	public static void main(String[] args) {
		int number[] = {1,0,5,6,3,2,3,7,9,8,4};
		
		int temp;
		boolean fixed=false;
		
		while(fixed==false) {
			
			fixed=true;
		
		for(int i=0; i<number.length-1; i++) {
			
			if(number[i] > number[i+1]) {
				//swap
				temp = number[i+1];
				number[i+1]=number[i];
				number[i]=temp;
				fixed=false;
			}
		}
	    }
		for (int i=0; i<number.length; i++) {
			System.out.println(number[i]);
		}
	}
}