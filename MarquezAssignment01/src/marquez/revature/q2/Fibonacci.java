package marquez.revature.q2;

public class Fibonacci 
{
	//fibonacci method 
	static int fibonacci(int number)
	{
		if(number <= 1)
			return number;
		return fibonacci(number-1) + fibonacci(number-2);
	}
	public static void main(String[] args) 
	{
		//loops and prints out the numbers from the fibonacchi sequence
		for(int i = 0; i < 25; i++)
		{
			System.out.println(fibonacci(i));
		}
	}

}
