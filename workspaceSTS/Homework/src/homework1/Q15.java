package homework1;
//DONE
import OtherPackage.Mathematics;

public class Q15 {
	//Write a program that defines an interface having the following methods:
	//addition, subtraction, multiplication, and division.
	//Create a class that implements this interface and provides appropriate
	//functionality to carry out the required operations.
	//Hard code two operands in a test class having a main method that calls
	//the implementing class.
	
	public static class Calculator implements Mathematics {

		@Override
		public int Addition(int a, int b) {
			return a + b;
		}

		@Override
		public int Subtraction(int a, int b) {
			return a - b;
		}

		@Override
		public int Multiplication(int a, int b) {
			return a * b;
		}

		@Override
		public double Division(int a, int b) {
			return (double)a/b;
		}
	}
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		System.out.println("The sum of 7 and 11 is " + calculator.Addition(7, 11));
		System.out.println("The difference of 4 and 5 is " + calculator.Subtraction(4, 5));
		System.out.println("The product of 1 and 7 is " + calculator.Multiplication(1, 7));
		System.out.println("The division of 2 and 3 is " + calculator.Division(2, 3));
	}
}
