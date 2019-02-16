package homework1;
//DONE
public class Q01 {
	//Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
	public static void BubbleSort(int[] myArray) {
		int temp = 0;
		for (int i = 10; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (myArray[j] > myArray[j+1]) {
					temp = myArray[j];
					myArray[j] = myArray[j+1];
					myArray[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] myArray = {1,0,5,6,3,2,3,7,9,8,4}; //ll elements
		System.out.print("Before: ");
		for (int x : myArray)
			System.out.print(x + " ");
		System.out.println();
		BubbleSort(myArray);
		System.out.print("After:  ");
		for (int x : myArray)
			System.out.print(x + " ");
	}
}
