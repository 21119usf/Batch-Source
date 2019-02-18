package com.revature.exceptions;

public class ToManyHatsException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToManyHatsException()
	{
		System.out.println("You are already wearing a hat");
	}
}

