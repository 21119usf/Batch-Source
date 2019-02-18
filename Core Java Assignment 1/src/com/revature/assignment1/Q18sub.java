package com.revature.assignment1;

public class Q18sub extends Q18Super{

	public Q18sub() {
	}
	//method to check for uppercase
	public void checkForUppercase(String a) {
		System.out.println("\nChecking for upper case letters: ");
		for(int i=0;i<a.length();i++) {//for loop iterating through length of string
			System.out.print(Character.isUpperCase(a.charAt(i))+" ");	//using isUpperCase method to check each char
		}
		System.out.println("\n");
		super.checkForUppercase(a);
	}
	//method to convert to lowercase
	@Override
	public void convertToLower(String b) {
		System.out.println("Converting all characters to lowercase: ");
		char[] f = new char[b.length()];//array to place characters
		for(int i=0;i<b.length();i++) {//iterating through characters in string
			f[i]=Character.toLowerCase(b.charAt(i));	//checking each char with the toLowerCase method
		}
		System.out.println(f);//display the arr all lower case
		super.convertToLower(b);
	}

	@Override
	public void convertToInt(String c) {//method to convert to int
		System.out.println("\nConverting String to an integer value: ");
		char d;//variable for temp storage of char
		String nums = "";//empty string to be used to store number string
		for(int i=0;i<c.length();i++) {//iterate through strings length
			d= c.charAt(i);//check each char
			 if (Character.isDigit(d)) {//if statement to check if char is a digit
                 nums = nums + d;//increment nums string w/ digit if it was found
           }
		}
		int n=Integer.parseInt(nums);  //parse nums string to int value
		System.out.println(n+10);//add 10 to int value
		super.convertToInt(c);
	}
	
	

}
