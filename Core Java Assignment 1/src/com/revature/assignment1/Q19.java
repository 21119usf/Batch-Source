package com.revature.assignment1;

import java.util.ArrayList;

public class Q19 {

	public static void main(String[] args) {
		ArrayList<Integer> intList  = new ArrayList<Integer>();//arrayList
		
		for(int i = 1;i<11;i++) {//loop to insert numbers 1 -  10 into arraylist
			intList.add(i);//insert number
		}
		int j=0;
		for(int i = 0;i<10;i+=2) {//loop to get even numbers
			j=j+intList.get(i);//adding sum of all even numbers
		}
		System.out.println("Sum of even is "+j);
		int k=0;
		for(int i = 1;i<10;i+=2) {//method to get odd numbers
			k=k+intList.get(i);//adding sum of all odd numbers
		}
		System.out.println("Sum of odd is "+k);
		int sum=0;
		boolean primeNum=true;
		
		for(int m=2;m<intList.size();m++) {//for loop for iterator to check each  number
			
			for(int i=2;i<=m/2;i++) {//for loop to check for prime

				if(m%i==0) {
					//not prime
					primeNum=false;
					break;
				}else
					sum=sum+m;
			}

		}
		System.out.println("Sum of prime is "+sum);//display result
	}
}
