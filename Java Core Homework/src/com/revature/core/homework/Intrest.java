package com.revature.core.homework;

import java.util.Scanner;

public class Intrest {
	// #17
	public static double calc(double i, double p, double t) {
		return i * p * t;
	}

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter intrest rate");
			double i = Double.parseDouble(sc.nextLine());
			System.out.println("Enter Principal ammount");
			double p = Double.parseDouble(sc.nextLine());
			System.out.println("Enter time in years");
			double t = Double.parseDouble(sc.nextLine());
			System.out.println("Intrest you will play " + calc(i, p, t));
			sc.close();
		} catch (NumberFormatException e) {
			System.out.println("You entered a invaild value please try again");
			Intrest.main(args);
		}
	}

}
