package com.revature.hw1;
import static com.revature.hw1extended.Prob11floatvariables.var2;
import static com.revature.hw1extended.Prob11floatvariables.var1;

public class Prob11UseFloats {
	static double var3 = 0;

public static void main(String[] args) {
	
		var3 = var1+var2;
		//var1 and var2 imported from Prob11floatvariables which is an outside package
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
}}