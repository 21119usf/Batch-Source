package com.revature.scan;

import java.util.Scanner;

public class ScanFun {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		String contents;
		System.out.println("What would you like to print?");
		contents = sc.nextLine();
		System.out.println(contents);
		System.out.println("What else?");
		int c2 = sc.nextInt();
		sc.nextLine();				//this nextLine is used to clear the buffer after using nextInt
		System.out.println(c2);
		System.out.println("Again?");
		String c3 = sc.nextLine();
		System.out.println(c3);
		
		String results = contents+ c2 + c3;
		System.out.println(results);
	}
}
