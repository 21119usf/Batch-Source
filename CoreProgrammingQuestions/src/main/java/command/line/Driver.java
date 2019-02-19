package command.line;


//Q16
public class Driver {

	public static void main(String[] args) {
		
		if(args.length > 0)
			System.out.println("Length of string input: " + args[0].length());
		else
			System.out.println("No argument entered");

	}

}
