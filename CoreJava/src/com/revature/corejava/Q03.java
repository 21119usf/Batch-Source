package com.revature.corejava;

// Class to reverse a string
public class Q03 {
	private String str;
	
	// Default constructor
	Q03() {
		this.str = "Default string";
	}
	
	// Constructor to customize str
	Q03(String s) {
		this.str = s;
	}
	
	// Reverses str
	public void reverseStr() {
		for (int i=0; i<this.str.length(); i++) {
			this.str = this.str.substring(1, this.str.length() - i)
				+ this.str.substring(0, 1)
				+ this.str.substring(this.str.length() - i, this.str.length());
		}
	}
	
	// Print str
	public void printStr() {
		System.out.println(this.str);
	}
	
	// Main
	public static void main(String[] args) {
		// Default
		Q03 q0 = new Q03();
		q0.printStr();
		q0.reverseStr();
		q0.printStr();
		
		// Custom
		Q03 q1 = new Q03("This is a custom string");
		q1.printStr();
		q1.reverseStr();
		q1.printStr();
	}
}
