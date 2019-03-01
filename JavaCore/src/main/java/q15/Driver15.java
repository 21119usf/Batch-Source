package q15;

import java.util.Scanner;

public class Driver15 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Integer 1: ");
		int a = in.nextInt();
		System.out.print("Integer 2: ");
		int b = in.nextInt();
		InYerClass inc = new InYerClass();
		System.out.println(a + " + " + b + " = " + inc.addition(a,b));
		System.out.println(a + " - " + b + " = " + inc.subtraction(a,b));
		System.out.println(a + " * " + b + " = " + inc.multiplication(a,b));
		System.out.println(a + " / " + b + " = " + inc.division(a,b));
		in.close();
	}
}
