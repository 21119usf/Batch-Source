package homework1;

public class Q12 {
	//Write a program to store numbers from 1 to 100 in an array.
	//Print out all the even numbers from the array. Use the enhanced
	//FOR loop for printing out the numbers.
	public static boolean isEven(int num) {
		if (num%2 == 0)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[100];
		for (int i = 0; i < 100; i++) {
			nums[i] = i+1;
		}
		
		System.out.print("Numbers 1-100: ");
		for (int x: nums)
			System.out.print(x + " ");
		System.out.print("\nEvens: ");
		for (int x: nums) {
			if (isEven(x))
				System.out.print(x + " ");
		}
	}
}
