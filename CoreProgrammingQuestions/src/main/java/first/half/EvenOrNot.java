package first.half;

public class EvenOrNot {
	
	public static boolean isEven(int number) {
		
		//is there a 1 as the lowest bit in this number's binary form? If so then it is not even
		if(Integer.lowestOneBit(number) == 1) { 
			return false;
		}
		return true;
	}

}
