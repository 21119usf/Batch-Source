package com.revature.assignment1;
import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);//create new scanner class to read from console
		System.out.println("Please Enter String :");//prompt to enter string
		String s = in.next();//take input of string
		System.out.println("Please Enter Integer between 1 and "+s.length()+":");//prompt for int
		int i = in.nextInt();//input of int stored in i

		getSubString(s, i);//called to get substring
		in.close();
	}
	//substring method
	static void getSubString(String str, int idx) {
		//for loop basically going from element 0 through the given integer and displaying the word using charAt string method
	for(int i = 0;i<idx-1;i++) {
		System.out.print(str.charAt(i));
	}
		
	}

}
