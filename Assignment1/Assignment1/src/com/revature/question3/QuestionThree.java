package com.revature.question3;

import java.util.Scanner;

public class QuestionThree {
		//if you won't accept converting the string to a character array before converting back to the reverse
	public static void isTemp(String name, int namelength) {
		char reverse;								//the 'reverse' as a character
		System.out.println("Your name, reversed:");
		for (int i = namelength-1; i >= 0; i--) {
			reverse = name.charAt(i);				//simply prints out each letter in succession
			System.out.print(reverse);
		}
	}
	//if you WILL accept converting the string to a character array aka not considering it a temp variable
	public static void notTemp(String name, int namelength) {
		char[] location = new char[namelength];
		for (int i = 0; i < namelength; i++) {
				location[i] = name.charAt(namelength-i-1);
		}
		String reverse = new String(location);
		System.out.println("Your name, reversed as a string:");
		System.out.println(reverse);
	}
	
	public static void inputQues(String ques, String name, int namelength) {
		
		if (ques.equals("Y")) {
			isTemp(name, namelength);		//constructs the "char array IS a temporary variable" method
		}
		else if (ques.equals("N")){
			notTemp(name, namelength);		//constructs the "char array IS NOT a temporary variable" method
		}
		else {
			System.out.println("Just input Y or N");
		}
	}
	
	//main method
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What is your name?");	//inputting name as a String
		String name = input.nextLine();
		int namelength = name.length();				//obtaining the length of name for the loops in the methods above
		System.out.println("Is a char array considered a temporary variable? (Y or N)");
		Scanner questf = new Scanner(System.in);	//covering all the bases
		String ques = input.nextLine();
		inputQues(ques, name, namelength);			//constructing the input Question method
		
		}
		
	}


