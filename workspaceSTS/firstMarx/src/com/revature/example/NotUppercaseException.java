package com.revature.example;

public class NotUppercaseException extends RuntimeException{
	public NotUppercaseException() {
		System.out.println("NOT ALL LETTERS WERE UPPERCASE!!! FIX THAT!!!");
	}
}
