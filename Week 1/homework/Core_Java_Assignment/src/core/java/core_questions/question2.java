//current package 
package core.java.core_questions;
//our class for question2
public class question2 {
	question2(){
		super();
	}
	//static method to implement the Fibonacci function
	public static int Fibonacci(int n) {
		if(n == 0 || n == 1)
			return n; 
		return Fibonacci(n - 1) + Fibonacci(n -2 ); 
	} 
	//our main method 
	public static void main(String[] args) {
		//this for loop will get the Fib number of the first 25 integers
		for(int i = 0; i <= 25; i++) {
			System.out.println("Fib of " + i + " --> " + Fibonacci(i));
		}
	}
}
