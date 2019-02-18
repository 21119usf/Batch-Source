package core.java.core_questions;
import core.java.extra_classes_interfaces.*;

public class question15 implements Operators {
	@Override
	public int addtion(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int substraction(int a, int b) {
		// TODO Auto-generated method stub
		return a > b ? a - b : b - a;
	}

	@Override
	public int multiplication(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	@Override
	public double division(int a, int b) {
		// TODO Auto-generated method stub
	return	a/b;
	}
}
