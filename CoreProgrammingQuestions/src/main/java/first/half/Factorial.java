package first.half;

public class Factorial {
	
	public static int factorialOf(int x) {
		if(x == 1)
			return 1;
		return x * factorialOf(x - 1);
	}

}
