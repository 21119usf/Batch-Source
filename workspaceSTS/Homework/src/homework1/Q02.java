package homework1;
//DONE
public class Q02 {
	//Write a program to display the first 25 Fibonacci numbers beginning at 0.
	
	public static void printFibs(int nthFib) {
		int prev = 0;
		int curr = 1;
		int next;
		
		//print out the first 2 numbers manually
		if (nthFib > 0)
			System.out.println("1\t" + prev);
		if (nthFib > 1)
			System.out.println("2\t" + curr);
		
		//print out the rest of the sequence
		for (int count = 2; count < nthFib; count++) {
			next = prev + curr;
			prev = curr;
			curr = next;
			System.out.println((count+1) + "\t" + curr);
		}
	}
	public static void main(String[] args) {
		printFibs(25);
	}
}
