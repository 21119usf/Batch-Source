package com.revature.flows;

public class LoopyLoops {
	/*
	 * If statement
	 * for decision making
	 * provides multiple paths of execution
	 * 
	 * if(<conditional>){
	 * <what to do if true>
	 * }
	 * else if(<second conditional>){
	 * <what to do if 2nd conditional is true>
	 * }
	 * else{
	 * <what to do if false>
	 * }
	 * ####Switch Cases####
	 * provides multiple paths of execution based on some value
	 * the "switch" is based on an integer numeric, a string, a char, a boolean, or enum
	 */
	static String color;
	public static void whatColor(String color) {
		switch (color) {
		case "green":
			System.out.println("green");
			break;
		case "purple":
			System.out.println("purple");
			break;
		case "crimson":
			System.out.println("crimson");
			break;
		default:
			System.out.println("Good Job stupid");
			break;
		}
	}
		/* For Loops
		 * for (a;b;c){Do something}
		 * a is variable declaration (counter)
		 * b is the condition that controls how far the loop will go
		 * c is the incrementer/decrementer
		 * 
		 */
		public static void forLoopFunness (int p) {
			for (int i=p;i>0;i--) {
				System.out.println(i);
				if (i==10) {
					//break or continue
					break;
//					continue;
				}
			}
			
		}
		
	/*
	 * Enhanced for loop aka for each
	 * for (x:<array for collection>){do thing}
	 * good for moving through collections, arrays and other iterables
	 * more CPU efficient
	 * no issue with index out of bounds- not size dependent
	 * good for access elements in one collection
	 * bad for adding and removing
	 */
		static int [] myArray= {11,21,43,55,62,77,90,4};
		public static void forEachFun(int [] a) {
			for(int i:a) {
				System.out.println(i);
			}
		}
		 /*
		  * While Loops
		  * while(<condition>){<do something>}
		  * 
		  * do while
		  * do {<do thing>} while (<condition>}
		  */
		public static void wileyWhile(int i) {
			while (i++<10) {
				System.out.println("boring");
				//i++; < unecessary if you add ++ to the while loop
			}
		}
		public static void doWileyWhile (int i) {
			do {
			System.out.println("not so boring");
			i++;
			}
			while(i<10);
		}
	public static void main(String[] args) {
//		whatColor("purple");
//		forLoopFunness(30);
//		forEachFun(myArray);
//		wileyWhile(1);
//		wileyWhile(11);
		doWileyWhile(22);
	}
/*
 * Conditionals
 * Logical Operators
 * < > <= >= != ==
 * ###### OR ######
 * a|b - bit wise
 * a||b - short sircuit OR If a is true, return true w/o b
 * ###### AND ######
 * a&b - 
 * a&&b - checks both and evaluates true iff both are true
 * #### EQUALS #####
 * ==
 * compare values of primitives
 * compare the reference for objects. NOT THE CONTENTS
 * != is good for checking nulls
 * .equals()
 * method inherited Object
 * all reference types have it
 * looking at content
 * 
 */
}
