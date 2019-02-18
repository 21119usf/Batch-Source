package com.revature.Q11b;

import com.revature.Q11a.PackageFloat;

public class PackageAccessor {

	public static void main(String[] args) {
		System.out.println(f1());		//print the result of f1()
		System.out.println(f2());		//print the result of f1()
	}
	
	/*f1 and f2
	 * Input	: none
	 * Output	: float
	 * Algo		: these methods are just to give us something to test in Junit
	 * 			  The first line calls the static function in PackageFloat to assign
	 * 			  values to its own float static variables. The second line returns them
	 */
	public static float f1() {
		PackageFloat.floatInit();
		return PackageFloat.float1;		
	}
	
	public static float f2() {
		PackageFloat.floatInit();
		return PackageFloat.float2;
	}

}
