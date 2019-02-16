package com.revature.core.homework;

import java.time.LocalDate;
// #14
public class SwitchMadness {
	public static void CaseMadness(String casePick) {
		switch(casePick) {
			case "Case 1":
				System.out.println("Square root of 8");
				System.out.println(Math.sqrt(8));
				break;
			case "Case 2":
				System.out.println(LocalDate.now());
				break;
			case "Case 3":
				String thing =  "I am learning Core Java";
				String[] splitThing = thing.split(" ");
				System.out.println(splitThing);
				break;
		}
	}
	
	public static void main(String[] args) {
		SwitchMadness.CaseMadness("Case 2");
	}
}
