package com.revature.assignment1;
import com.revature.assignment1forquestion11.*;//import outside package

public class Q11a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Q11b move = new Q11b();//Q11b object is created 
		
		System.out.println("Sum to demo floats from another package is "+(findSum(move.b, move.a)));//call to find sum
	}																								//values in a class in anotherpackage
	
	public static float findSum(float c, float d) {//using floats, find the sum of floats from another package
		return c+d;
	}

}
