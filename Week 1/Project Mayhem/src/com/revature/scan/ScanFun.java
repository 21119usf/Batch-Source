package com.revature.scan;

import java.util.Scanner;

public class ScanFun {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		String contents;
		System.out.println("What would you like to print?");
		contents = sc.nextLine();
		//System.out.println(contents);
		System.out.println("What else?");
		int c2 = sc.nextInt();
		//System.out.println(c2);
		sc.nextLine();
		System.out.println("again?");
		String c3 = sc.nextLine();
		//System.out.println(c3);

		c2 = c2*c2;
		String results = contents + c2 + c3;
		System.out.println(results);
		
	}

}
