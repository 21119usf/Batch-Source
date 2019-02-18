package com.revature.hw1;

import java.util.Scanner;

public class Prob17Interest {

	//sc is the scanner class
	public static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Principal");
		System.out.println("=========");
		double principal=sc.nextDouble();
		
		
		System.out.println("Rate of Interest");
		System.out.println("================");
		double rate=sc.nextDouble();
		
		
		System.out.println("Number of Years");
		System.out.println("===============");
		double time=sc.nextDouble();
		
		//sc.nextline(); needed to clear buffer
		//sc.nextLine();
		
		double interest=principal*rate*time;
		System.out.println("Your interest is: ");
		System.out.println(interest);
	}

}
