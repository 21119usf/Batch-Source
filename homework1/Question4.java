package homework1;

public class Question4 {
	static int factorialCalc (int x)
	{
		//Stops the recursive function
		if ( x == 0)
			return 1;
		//Uses recursion to calculate factorial
		return x*factorialCalc(x-1);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

			System.out.println(factorialCalc(5));
	}

}
