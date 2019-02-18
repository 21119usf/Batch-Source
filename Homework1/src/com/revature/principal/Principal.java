package com.revature.principal;

import java.util.Scanner;

//set the variables
public class Principal {
	private double p;
	private double t;
	private double r;
	
	//generate the setters and getters
	public double getP() {
		return p;
	}

	public void setP(double p) {
		this.p = p;
	}

	public double getT() {
		return t;
	}

	public void setT(double t) {
		this.t = t;
	}

	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}
	//calculation for interest
	public double Interest() {
		return this.p * this.t * this.r;
	}



	public static void main(String[] args) {
		Principal principal = new Principal();
		
		Scanner scan = new Scanner(System.in);
		//input in the principal
		System.out.println("Enter Principal: "); 
		principal.setP(scan.nextDouble());
		//input the rate
		System.out.println("Enter Rate: ");
		principal.setR(scan.nextDouble());
		//input the time
		System.out.println("Enter Time: ");
		//display the calculation for interest
		principal.setT(scan.nextDouble());
		System.out.println("Interest: "+ principal.Interest());
		
		//
		scan.close();

	}

}
