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
		super();
		// TODO Auto-generated constructor stub
	}
	public Mouse(int weight) {
		this(54, weight);
	}
	public Mouse(int numWhiskers, int weight) {
		this(17, numWhiskers, weight);
	}
	public Mouse(int numTeeth, int numWhiskers, int weight) {
		this.numTeeth = numTeeth;
		this.numWhiskers = numWhiskers;
		this.weight = weight;
	}
	public static void main(String[] args) {
		Mouse m = new Mouse(15,3);
		System.out.println(m);
	}
}
