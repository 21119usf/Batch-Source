package com.revature.q17;

import java.util.Scanner;

public class Q17 {

	public static void main(String[] args) {
		
		//prompt user for Principle
		Scanner principleInput = new Scanner(System.in);
		System.out.println("What is the principle? ");
		double principle = principleInput.nextDouble();
		
		//Prompt user for rate of interest
		Scanner rateInput = new Scanner(System.in);
		System.out.println("What is the rate? ");
		double rate = rateInput.nextDouble();
		
		//prompt user for time
		Scanner timeInput = new Scanner(System.in);
		System.out.println("How many years? ");
		int time = timeInput.nextInt();
		
		//calculate Interest   Interest = Principal* Rate* Time
		double interest =  principle * rate * time;
		String sInterest = String.format("$%,.2f", interest);//converting the number to have currency format
		
		System.out.println("The interest " + sInterest );
		
		
		principleInput.close();
		rateInput.close();
		timeInput.close();

	}

}
