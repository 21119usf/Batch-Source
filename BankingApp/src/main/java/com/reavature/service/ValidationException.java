package com.reavature.service;

public class ValidationException extends Exception{

	private static final long serialVersionUID = -5238733771358748922L;
	
	public ValidationException(String msg) {
		super(msg);
	}
}
