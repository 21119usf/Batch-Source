package q15;

public class DivideByZeroException 
	extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1456607897106355364L;

	DivideByZeroException() {
		System.out.println("You degenerate!");
	}
}
