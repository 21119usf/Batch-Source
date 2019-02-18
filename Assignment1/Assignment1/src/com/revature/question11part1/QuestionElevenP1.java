package com.revature.question11part1;
import com.revature.question11part2.QuestionElevenP2;

//Q11. Write a program that would access two float-variables from 
//a class that exists in another package. Note, you will need to 
//create two packages to demonstrate the solution.	
public class QuestionElevenP1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float eunum = QuestionElevenP2.var1;
			System.out.println("Euler's number is " + eunum + " to 5 decimal places");
		float pi = QuestionElevenP2.var2;
			System.out.println("Pi is " + pi + " to 5 decimal places");
	}

}
