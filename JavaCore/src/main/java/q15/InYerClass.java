// David Lavoie Revature Assignment 1 Q15
package q15;

public class InYerClass implements InYerFace {
	int a, b;
	
	public InYerClass() {
	}

	public int addition(int a, int b) {
		return a + b ;
	}

	public int subtraction(int a, int b) {
		return a - b;
	}

	public int multiplication(int a, int b) {
		return a * b;
	}

	public int division(int a, int b) {
		if (b==0) {
			throw new DivideByZeroException();
		}
		return a / b;
	}
}
