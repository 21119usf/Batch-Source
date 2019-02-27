package com.revature.utilities;


public class OutputUtility {
	public static String printBorder(int length) {
		StringBuilder boarderBuilder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			boarderBuilder.append("*");
		}
		return boarderBuilder.toString();
	}
	
	public static String repeat(String entry, int length) {
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < length; i ++) {
			out.append(entry);
		}
		return out.toString();
	}
	
	public static void printHeader(String headerMessage) {
		// top border
		System.out.println(OutputUtility.printBorder(headerMessage.length() + 4));
		// top padding
		System.out.println("* " + OutputUtility.repeat(" ", headerMessage.length()) + " *");
		// welcome message
		System.out.println("* " + headerMessage + " *");
		// bottom padding
		System.out.println("* " + OutputUtility.repeat(" ", headerMessage.length()) + " *");
		// bottom border
		System.out.println(OutputUtility.printBorder(headerMessage.length() + 4));
	}
}
