package banking;

public class NegativeInputException 
	extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3344295013758563030L;

	public NegativeInputException() {
		System.out.println("Sorry can't input negative amounts, nice try though");
	}
}
