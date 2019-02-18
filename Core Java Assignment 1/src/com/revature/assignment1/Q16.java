package com.revature.assignment1;

public class Q16 {

	public static void main(String[] args) {
		
		int b = args.length-1;//taking in the length of the strings in command line
		
		for(int i=0;i<args.length;i++) {//for loop to simply display the command line args
			System.out.println(args[i]);
			b=b+args[i].length();
		}
		
		System.out.println("This is the number of characters: "+ b);//display to answer question of how many characters are in the command line
	}

}
