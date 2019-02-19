package first.half;

public class ReverseString {
	
	public static String reverseString(String input) {
		
		if(input.length() == 0)
			return input;
		
		return reverseString(input.substring(1, input.length())) + input.charAt(0);

	}

}
