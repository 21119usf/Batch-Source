package core.java.core_questions;

import core.java.extra_classes_interfaces.Float_variables;

//extend class containing the two float variables
public class question11 extends Float_variables {
	
	question11(float n1, float n2){
		//first float variable from class Float_variables
		variableFromAnotherPackage1 = n1;
		//second float variable from class Float_variables
		variableFromAnotherPackage2 = n2;
	}
	
	public static void main(String[] args) {
		float f1 = 11;
		float f2 = 12; 
		
		question11 fv = new question11(f1, f2);
		
		System.out.println("First float number: " + fv.variableFromAnotherPackage1);
		System.out.println("Second float number: " + fv.variableFromAnotherPackage2);	
	}
}
