package com.revature.homework1;
import java.util.Scanner;

public class Q5_Substring {
	
	//subString method
	public static StringBuilder subString(String str, int idx) {
		int i = 0;
		// make the string mutable
		StringBuilder sub = new StringBuilder("");
		while(i<=idx-1) {
			sub.append(str.charAt(i)); // add indexes  0 to idx-1 to new String
			i++;
		}
		return sub;
	}
	
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Enter the string to cut: ");
		String s = myScanner.nextLine();
		System.out.println("Enter the integer to cut the string to: ");
		int n = myScanner.nextInt();
		myScanner.close();
		StringBuilder mySubString = subString(s,n);
		System.out.println("You String was: " + s + "\nYour Inclusive range was [0," + n + "]");
		System.out.println("Your substring is: " + mySubString);

	}

}
