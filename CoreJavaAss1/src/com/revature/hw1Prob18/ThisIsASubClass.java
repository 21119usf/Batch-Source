package com.revature.hw1Prob18;

import java.util.Scanner;

//it is also concrete
public class ThisIsASubClass extends ThisIsASuperClass{
	public static Scanner sc= new Scanner(System.in);
	static String s = "Tom Soya";
	static String contents = "";
	
	@Override
	public void checkUppercase() {
		
		boolean hasUppercase = !s.equals(s.toLowerCase());
		System.out.println(hasUppercase);
		
	}
	@Override
	public void convertLowToUp() {
		// TODO Auto-generated method stub
		String allUppercase = s.toUpperCase();
		System.out.println(allUppercase);
	}
	@Override
	public void convertStringToInt() {
		// TODO Auto-generated method stub
		System.out.println("Enter the number you wish to add 10 to");
		contents=sc.nextLine();
		int stringtonumber = Integer.parseInt(contents);	
		int tenadded = stringtonumber + 10;
		System.out.println(tenadded);
		//should print out 61 since 51+10
	}
	
	
	
	
}
