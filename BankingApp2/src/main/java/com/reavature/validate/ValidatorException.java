package com.reavature.validate;
/*
 * Custom exception used for notifying user of validation mistakes
 */
public class ValidatorException extends Exception {
	private static final long serialVersionUID = -953293934116344400L;
	
	public ValidatorException(String msg) {
		super(msg);
	}

}
