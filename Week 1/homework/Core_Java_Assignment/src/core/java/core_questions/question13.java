package core.java.core_questions;

public class question13 {
	//function to find prime number
	private static boolean isPrime(int n) {
		if(n <= 1)
			return false; 
		
		for(int i = 2; i < n; i++) {
			if(n % i == 0)
				return false;
		}
		return true; 
	}

	public static void main(String[] args) {
		int num = 7; 
		int bit = 0; 
		//pattern was that if row number was prime, then
		//that row starts with 1, otherwise with 0
		for(int i = 1; i <= num; i++) {
			for(int j = 0; j < i; j++) {
				if(isPrime(i)) {
					System.out.print("" + bit + " ");
					//XOR bit manipulation
					bit ^= 1; 
				}else {
					System.out.print("" + bit + " ");
					bit ^= 1; 
				}
			}
			System.out.println();
		}
	}
}
