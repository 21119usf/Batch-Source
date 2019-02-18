package first.half;

public class Fibonacci {
	
	public static void fibonacciNumbers(int count) {
		
		System.out.println("Fibonacci Numbers:");
		
		for(int i = 1; i <= count; i++) {
			System.out.print(nextFibonacci(i) + " ");
		}
		System.out.println("");
	}
	
	public static int nextFibonacci(int number) {
		
		if(number == 0)
			return 0;
		if(number == 1 || number == 2)
			return 1;
		
		return nextFibonacci(number - 2) + nextFibonacci(number - 1);
	}

}
