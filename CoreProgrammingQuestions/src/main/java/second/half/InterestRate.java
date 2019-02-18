package second.half;

import java.util.Scanner;

public class InterestRate {
	
	//no error checking
	public static void interestRate() {
		double principal, rate, time;
		Scanner x = new Scanner(System.in);
		System.out.println("Enter principal, rate, and time separated by spaces:");
		principal = x.nextDouble();
		rate = x.nextDouble();
		time = x.nextDouble();
		x.close();
		
		System.out.println("Result: " + principal * rate * time);
	}

}
