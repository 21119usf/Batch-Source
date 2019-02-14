package com.revature.corejava;

import java.util.Scanner;

public class Q17 {
	private double P;
	private double t;
	private double r;
	
	public void setPrinciple(double P) {
		this.P = P;
	}
	public void setTime(double t) {
		this.t = t;
	}
	public void setRate(double r) {
		this.r = r;
	}
	
	public double computeInterest() {
		return this.P * this.t * this.r;
	}
	
	// Main
	public static void main(String[] args) {
		Q17 q0 = new Q17();
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter principle: ");
		q0.setPrinciple(sc.nextDouble());
		System.out.print("Enter rate: ");
		q0.setRate(sc.nextDouble());
		System.out.print("Enter time: ");
		q0.setTime(sc.nextDouble());
		System.out.println("Interest:  " + q0.computeInterest());
		sc.close();
	}
}
