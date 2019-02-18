package com.revature.Floats;
/*
 * class to establish some private floats and a default constructor to give us default values
 */
public class SomeFloatVars {
	private float f1;
	private float f2;
	
	public SomeFloatVars() {
		this.f1 = 10f;
		this.f2 = 20f;
	}
	
	public float getF1 () {
		return f1;
	}
	public void setF1(float x) {
		this.f1 = x;
	}
	
	public void setF2(float a) {
		this.f2 = a;
	}
	
	public float getF2 () {
		return f2;
	}
	

}
