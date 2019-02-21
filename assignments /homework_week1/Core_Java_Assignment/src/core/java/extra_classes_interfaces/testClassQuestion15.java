package core.java.extra_classes_interfaces;
import core.java.core_questions.question15;


public class testClassQuestion15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 12; 
		int num2 = 144; 
		
		question15 q = new question15();
		
		System.out.println("Addition: " + q.addtion(num1, num2));
		System.out.println("\nSubstraction: " + q.substraction(num1, num2)); 
		System.out.println("\nMultiplication: " + q.multiplication( num1, num2)); 
		
		try {
		System.out.println("\nDivision: " + q.division(num2, num1));
		}catch(zeroValueException e) {
			e.printStackTrace();
		}
	}
}
