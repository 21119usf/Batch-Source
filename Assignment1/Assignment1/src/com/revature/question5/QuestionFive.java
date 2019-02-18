package com.revature.question5;

import java.util.Scanner;

public class QuestionFive {

	public static void main(String[] args) {
		boolean followedDirections=false;
		Scanner input = new Scanner(System.in);
		System.out.println("What is the meaning of life?");	//inputting String
		String str = input.nextLine();
		int strlength = str.length();
		while (followedDirections==false) {
		System.out.println("Enter a number between 1 and " 	//inputting a number up to as long as the string
		+ strlength);
		Scanner num = new Scanner(System.in);
		int idx = input.nextInt();
		
		if (idx < 1 || idx > strlength) {

			System.out.println("that is NOT a number between 1 and " + strlength);	//in case the user tries something funny
			continue;
			
		}
		else {
			char[] location = new char[idx];
			for (int i = 0; i < idx-1; i++) {					//setting up a character array to make a substring
					location[i] = str.charAt(i);
			}
			String strshort = new String(location);				//substring of the original str string
			
			System.out.println(strshort);						//returning substring

			followedDirections=true;
		}
		}
		
	}

}
