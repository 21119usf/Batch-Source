package com.revature.assignment1;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);//scan from console
		System.out.println("Enter string: ");
		String s= in.nextLine();//input string into variable
		System.out.println(reverseMe(s));//display the result of the called method
		in.close();//close scanner 
	}
	
	//method to reverse string
	public static String reverseMe(String g) {
		
		int length = g.length();//var for length of string
		char arr[]= new char[length];//array created for each character of the string

		for(int i=0;i<length;i++) {//for loop to iterate through string array
			arr[i]=g.charAt(length - 1 - i);//using charAt method, no swapping, no temp var, input 
		}
		String reverse = new String(arr);//convert char array back into string
		
		return reverse;//return result
	}

}
