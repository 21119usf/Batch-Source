package com.revature.chaining;

public class Mouse {
	private int numTeeth;
	private int numWhiskers;
	private int weight;
	@Override
	public String toString() {
		return "Mouse [numTeeth=" + numTeeth + ", numWhiskers=" + numWhiskers + ", weight=" + weight + "]";
	}
	public Mouse() {
		this(6,6,3);
		// TODO Auto-generated constructor stub
	}
	
	public Mouse(int numTeeth, int numWhiskers, int weight) {
		this.numTeeth = numTeeth;
		this.numWhiskers = numWhiskers;
		this.weight = weight;
	}
	
}
