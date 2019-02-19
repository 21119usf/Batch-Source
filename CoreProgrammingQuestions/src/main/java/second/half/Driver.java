package second.half;

/* Noel Gonzalez */
public class Driver {

	//This class prints human readable results to the console, but does not contain implementation of answers
	//This is the second half of the assignment
	public static void main(String[] args) {
		
		//Q11
		System.out.println("The floats from the other package are:");
		GetFloatsFromOtherPackage.getFloatsFromOtherPackage();
		
		//Q12
		System.out.println("Even Numbers between 1 and 100:");
		EvenNumbers even = new EvenNumbers(1, 100);
		even.printEvenNumbers();
		
		//Q13
		System.out.println("Triangle:");
		int[][] x =  {{0}, {1, 0}, {1,0,1}, {0,1,0,1}};
		Triangles.printTriangleFromArray(x);
		
		//Q14
		System.out.println("Switch cases:");
		Switch.SwitchCase("root");
		Switch.SwitchCase("date");
		Switch.SwitchCase("string");
		
		//Q15
		System.out.println("Math Interface:");
		System.out.println("10 + 5 + 5 = " + (int) MathImplementation.getIntance().add(10, 5, 5));
		System.out.println("10 * 5 * 5 = " + (int) MathImplementation.getIntance().multiply(10, 5, 5));
		
		//Q16 - has its own separate driver for command line arguments
		System.out.println("Q16 has own driver");
		
		//Q17
		System.out.println("Simple Interest (no error checking) :");
		InterestRate.interestRate();
		
		//Q18
		System.out.println("SubClass Implementation:");
		System.out.println(SubClass.getInstance().toUpperCase("make this uppercase"));
		System.out.println("Is there an uppercase here? " + SubClass.getInstance().CheckUpperCase("Is there an uppercase here?"));
		System.out.println("50 to int + 10: " + SubClass.getInstance().toInt("50"));
		
		//Q19
		System.out.println("ArrayList of integers:");
		ArrayListOfInts.doStuff();
		
		//Q20
		System.out.println("====================================");
		System.out.println("IO:");
		IO.printFromFile();
		
	}

}
