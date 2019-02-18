package com.revature.AccessFloats;
import com.revature.Floats.*;
/*
 * this class accesses someFloatVars class in another package and prints them to the console
 */
public class AccessFloats {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SomeFloatVars firstFloat = new SomeFloatVars();
		
		System.out.println(firstFloat.getF1());
		System.out.println(firstFloat.getF2());
	}

}
