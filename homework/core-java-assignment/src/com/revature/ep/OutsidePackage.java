//Q11. Write a program that would access two float-variables from a class that exists in
//another package. Note, you will need to create two packages to demonstrate the
//solution.

package com.revature.ep;

public class OutsidePackage {

	private float float1;
	private float float2;
	
	// constructor
	public OutsidePackage() {
		float1 = 1.1f;
		float2 = 2.2f;
	}
	
	// get float value 1
	public float getFloat1() {
		return float1;
	}
	
	// get float value 2
	public float getFloat2() {
		return float2;
	}
}
