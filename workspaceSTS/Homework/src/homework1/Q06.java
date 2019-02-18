package homework1;
//DONE
import java.util.Scanner;

public class Q06 {
	//Write a program to determine if an integer is even without using the modulus operator (%)
	public static String isEven(int x) {
		//Check the last bit to see if it is '1', '1' indicates odd, '0' indicates even
		if ((x & 1) == 1)
			return "Odd";
		return "Even";
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please input a number to check if it is even: ");
		int N = input.nextInt();
		System.out.print(N + " is " + isEven(N));
		input.close();
	}
}
