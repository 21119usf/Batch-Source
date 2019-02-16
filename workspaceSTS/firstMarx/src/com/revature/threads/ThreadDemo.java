package com.revature.threads;

public class ThreadDemo {
	
	/*
	 * 2 ways to spin up a thread
	 * 1- extend Thread and overwrite Run()
	 * 2- Implement the Runnable interface and overwrite Run()
	 */

	public static void main(String[] args) {
		Thread extendedThread = new ExtendThread();
		Thread implementedThread = new Thread(new ImplementRunnable());
		
		implementedThread.setPriority(10);
		extendedThread.start();
		implementedThread.start();
		
		for (int i = 0; i < 100; i++)
			System.out.println("Hey-Driver");
	}

}
