package com.revature.design;

public class SIngleton {
	/*
	 * Singleton Design Pattern
	 * ensure a class has only one instance and provides
	 * a global access to it
	 */
	//private static property of the self class
	private static SIngleton instance;
	//private constructor
	private SIngleton() {
		//logic here
	}
	//Static method to get the unique instance- if it does not exist
	//we will create it
	public static synchronized SIngleton getInstance() {
		if(instance==null) {
			instance= new SIngleton();
		}
		return instance;
	
	}
	public void doSomething() {
		//what the object should do
	}
}
