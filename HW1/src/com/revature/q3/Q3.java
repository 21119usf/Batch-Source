package com.revature.q3;

public class Q3 {
	public static void main(String[] args) {
		
		String reverse = "Frank!";
		
		for(int i = reverse.length() - 1; i >= 0 ; i--) { // printing the char array backwards by  length of array > 0 as a conditional
			System.out.print(reverse.charAt(i));
		}
		
	}
}
