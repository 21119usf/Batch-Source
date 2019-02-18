package com.revature.singleton;

public class Singleton {
/*
 * Singleton design patter
 * ensure a class has only one instance and provides
 * a global access to it
 * 
 */
	//private static property of the self class
	private static Singleton instance;
	//private constructor
	//because we only want one, don't want anything else be able to call that constructor
	private Singleton() {
		//logic
	}
	//static method to get the unique instance- if it does not exist
	//we will create it
	public static synchronized Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
		
	}
	public void doSomething() {
		//what the object should do/be
	}
}
