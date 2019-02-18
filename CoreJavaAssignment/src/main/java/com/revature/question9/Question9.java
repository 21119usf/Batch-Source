package com.revature.question9;

import java.util.ArrayList;

public class Question9 {
	
	//Create an ArrayList which stores numbers from 1 to 100 
	//and prints out all the prime numbers to the console.
	
	static ArrayList<Integer> numbers = new ArrayList<>();
	public static final int p1 = 2;
	public static final int p2 = 3;
	public static final int p3 = 5;
	public static final int p4 = 7;
	
	public static void create(){
		for(int i = 1; i <= 100; i++) {
			numbers.add(i);
		}	
	}
	
	public static void prime(){
		for(int a: numbers) {
			if(a == 2 || a == 3 || a == 5 || a == 7) {
				System.out.print(a + " ");
			}else if(a == 1){
				continue;
			}else {
				if(a%p1 != 0) {
					if(a%p2 != 0) {
						if(a%p3 != 0) {
							if(a%p4 != 0) {
								System.out.print(a + " ");
							}
						}
					}
				}
			}
			
			
			
		}
	}


	public static void main(String[] args) {
		create();
		System.out.println("Prime numbers: ");
		prime();
		
	}
	
}
