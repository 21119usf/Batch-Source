package com.revature.exception;

import java.util.Scanner;

public class BestFootballTeam {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("What school has the best Footall team?");
		try {
			String input = in.nextLine(); 
			if(!input.equals("Alabama")) {
				throw new InvalidTeamException(input+ " is not the best team, try again");
			}
			else {
				System.out.println("Roll Tide!");
			}
		} catch(InvalidTeamException e) {
			System.out.println(e.getMessage());
			main(args);
		}
	}

}
