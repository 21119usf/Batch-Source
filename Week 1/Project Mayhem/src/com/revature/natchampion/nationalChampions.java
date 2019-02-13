package com.revature.natchampion;

import java.util.Scanner;

import com.revature.exceptions.NatChampException;

public class nationalChampions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String name;
			Scanner input = new Scanner (System.in);
			System.out.println("Please input the name of the 2017 NCAA Football National Champion");
			name = input.nextLine();
			ncaa (name);
			
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void ncaa (String a) throws NatChampException{
		if (a.equals("Alabama")) {
			throw new NatChampException ();
		}
		else if (a.equals("Crimson Tide")) {
			throw new NatChampException ();
		}
		else {
			System.out.println("You are correct, sir.");
		}
	}

}
