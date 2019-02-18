package com.revature.core.java.assignment.floats;

public class SomeFloats 
{
	private float firstFloat;
	
	private float secondFloat;
	
	/*
	 * The constructor for this class. Initializes new float.
	 */
	public SomeFloats(float a, float b)
	{
		this.firstFloat = a;
		this.secondFloat = b;
	}

	public float getFirstFloat() {
		return firstFloat;
	}

	public void setFirstFloat(float firstFloat) {
		this.firstFloat = firstFloat;
	}

	public float getSecondFloat() {
		return secondFloat;
	}

	public void setSecondFloat(float secondFloat) {
		this.secondFloat = secondFloat;
	}
}
