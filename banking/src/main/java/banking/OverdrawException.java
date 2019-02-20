package banking;

public class OverdrawException 
	extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6425860036046135188L;

	public OverdrawException() {
		System.out.println("Not enough funds");
	}
}
