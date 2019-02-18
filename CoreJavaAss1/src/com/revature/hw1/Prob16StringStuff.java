package com.revature.hw1;

public class Prob16StringStuff {

	//to run this, right click, run as configuration, argument tab, program arguments box, type something like a
	//long run on sentence with no spaces and you should achieve a nice temporary high score.
	public static void main(String[] args) {

        char[] array = args[0].toCharArray();

        int size = array.length;

        System.out.println("CommandLine Argue is: " + args[0] + " and the length is " + size);

    }
}

