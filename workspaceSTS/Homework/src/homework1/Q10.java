package homework1;
//DONE
public class Q10 {
	//Find the minimum of two numbers using ternary operators.
	public static int min(int a, int b) {
		return (a < b) ? a : b;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {86, 99, 27, 72, 13, 1,  28, 52, 49, 30};
		int[] arr2 = {66, 78, 11, 46, 36, 95, 81, 10, 12, 55};
		
		for (int index = 0; index < 10; index++)
			System.out.print(min(arr1[index], arr2[index]) + " ");
	}
}
