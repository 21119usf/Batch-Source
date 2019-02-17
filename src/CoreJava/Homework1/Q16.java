package com.revature.homework;

public class Q16 {
	public static void main (String ... args) {
		
		String s = ("Hello " + args[0]);
		char[] c = s.toCharArray();
		int sz = c.length;
		int i = 0, j = 0, counter = 0;
		
		for (i=0; i<sz; i++) {
			counter = 0;
			for (j = 0; j < sz; j++) {
				
				if (j<i && c[i] == c[j]) {
					break;
				}
				
				if (c[j] == c[i]) {
					counter++;
				}
			} //end of j loop
			System.out.println("The character " +c[i]+" is present "+counter+" times");
		} //end of i loop
	}
}
