// David Lavoie Revature Assignment 1 Q14
package q14;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Switch {
	/**
	 * n determines whether we:
	 * 		print the square_root of a number (case 1)
	 * 		print today's date (case 2)
	 * 		split the string "I am learning Core Java" and print the split string (case 3)
	 * @param n
	 */
	public static void mySwitch(int n) {
		switch(n) {
		case 1:
			System.out.println("Enter number");
			Scanner scan = new Scanner(System.in);
			double square = scan.nextDouble();
			double root = Math.sqrt(square);
			System.out.println(root + " is the square root of " + square);
			scan.close();
			break;
		case 2:
			LocalDate today = LocalDate.now();
			System.out.println("Today: " + today);
			break;
		case 3:
			String fu = "I am learning Core Java";
			ArrayList<String> bar = new ArrayList<String>();
			for(String x: fu.split(" ")) {
				bar.add(x);
				System.out.println(x);
			}
			
		}
	}
	
	public static void main(String[] args) {
		mySwitch(1);
		mySwitch(2);
		mySwitch(3);

	}

}
