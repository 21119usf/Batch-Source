package com.revature.homework1;

// to get the floats from the the class "ClassWithFloats" from the package com.revature.homework1_11
import com.revature.homework1_11.ClassWithFloats;

public class Q11_PckgImportTest {
	
	public static void main(String [] args) {
		// print out the floats from the other class
		System.out.println("Float 1 is: " + ClassWithFloats.f1);
		System.out.println("Float 2 is: " + ClassWithFloats.f2);
	}

}
