package banking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//Import log4j classes.
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bankingViews.ViewStack;

public class Driver {
	
	private final static Set<String> USERTYPES = Collections.unmodifiableSet(
			new	HashSet<String>(Arrays.asList("Customer","Admin","New User")));
	
	private static final Logger logger = LogManager.getLogger(Driver.class);
	
	public static void main(String[] args) {
		// Initialize and welcome the user
		logger.trace("Entering Application");
		System.out.println("Welcome to Good Banker, home of the Good Banker, May I take your order?!");
		

		// Initialize ViewStack
		ViewStack viewStack = new ViewStack();
		viewStack.start();

		

		// Cleanly Close the application
		logger.trace("Closing Application");
		}
}
