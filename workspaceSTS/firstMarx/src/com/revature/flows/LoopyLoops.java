package com.revature.flows;

public class LoopyLoops {
	/* If statement- For decision making, provides multiple paths of execution
	 * 
	 * if (<conditional>) {
	 * 		<What to do if true>
	 * }
	 * else if (<second conditional>){
	 * 		<What to do if 2nd conditional is true>
	 * }
	 * else {
	 * 		<What to do if false>
	 * }
	 */
	
	/* Switch Cases
	 * Provides multiple paths of execution based on some value
	 * the "switch" is based on an integer numeric, a string,
	 * a char, a boolean, or enum.
	 */
	
	static String color;
	public static void whatColor(String color) {
		switch(color) {
		case "green":
			System.out.println("Green");
			break;
		case "purple":
			System.out.println("Purple");
			break;
		case "crimson":
			System.out.println("Crimson");
			break;
		default:
			System.out.println("Good job");
		}
	}
	
	/* For Loops
	 * 
	 * for (a;b;c) {do something}
	 * a- is variable declaration (counter)
	 * b- is the condition that controls how far the loop will go
	 * c- is the incrementor/decrementor
	 */
	public static void forLoopFunness(int p) {
		for (int i=p; i>0; i--) {
			System.out.println(i);
		}
	}
	
	/* Enhanced For Loop
	 * for (x:<Array or Collection>) {do things)
	 * good for moving through collections,arrays and other iterables
	 * more CPU efficient
	 * no issues with index out of bounds0 not size dependent
	 * good for access elements in one collection
	 * bad for adding and removing
	 */
	static int[] myArray= {11,21,43,55,62,77,90,4};
	public static void forEachFun(int[] a) {
		for (int i: a) {
			System.out.println(i);
		}
	}
	
	/* While Loops
	 * while(<condition>) {<do something>}
	 * 
	 * Do While Loops
	 * do {<do something>} while (<condition>)
	 */
	public static void wileyWhile(int i) {
		while (i++ < 10) {
			System.out.println("boring");
		}
	}
	
	public static void doWileyWhile(int i) {
		do {
			System.out.println("not so boring");
		}while (++i < 10);
	}
	
	public static void main(String[] args) {
		//whatColor("purple");
		//forLoopFunness(30);
		//forEachFun(myArray);
		//wileyWhile(1);
		doWileyWhile(11);
	}

}
