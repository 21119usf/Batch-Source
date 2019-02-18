package com.revature.Q16;

public class CommandArgs {

	public static void main(String[] args) {
		try {
			System.out.println(args[0].length());	//Prints number of chars in string from command line input
		}catch(ArrayIndexOutOfBoundsException e) {	//Catch in case there is no command line arguments
			System.out.println("Error no command line argrument supplied!!");
		}
	}

}
