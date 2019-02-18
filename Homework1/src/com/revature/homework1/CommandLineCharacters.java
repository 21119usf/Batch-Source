package com.revature.homework1;
/*
 * This program reads arguments from the command line and for that we stored strings in our run 
 * configurations under arguments. to show the character length, we loop through the amount of arguments
 * and access the length of each argument and print out its length
 */

public class CommandLineCharacters {
	CommandLineCharacters(){
		super();
	}
	
	public static void showCharacterLength(String[] args) {
		for(int i=0;i<args.length;i++) {
			System.out.println(args[i] + " has " + args[i].length() + " characters");}
	}



public static void main(String[] args) {

	CommandLineCharacters heyGuys = new CommandLineCharacters();
	heyGuys.showCharacterLength(args);


}


}

