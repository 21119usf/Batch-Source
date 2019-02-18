package com.revature.reverse;

import java.util.*;
import java.io.*;
import java.lang.*;

public class ReverseString {
	public static void main(String [] args) {
		System.out.println("Input a word: ");
		/*
		 * Scanner in(created name) = 
		 * new Scanner()(the action of input) 
		 * System.in (where it is looking for the input)
		 */
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		char[] crissCross = str.toCharArray();
		for(int i = crissCross.length - 1; i>=0; i--) {
			System.out.print(crissCross[i]);
		}
		
		
	}

}
