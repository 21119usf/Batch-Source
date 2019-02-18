package com.revature.exceptions;

public class NotWearingAHatException extends RuntimeException 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotWearingAHatException()
	{
		System.out.println("You don't have a hat to take off!");
	}
}
