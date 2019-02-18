package com.revature.threadz;

public class ThreadDemo {
	/*
	 * 2 ways to spin up a thread
	 * 1- extend thread and overwrite run()
	 * 2- implement the Runnable interface and overwrite run()
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread extendThread = new ExtendThread();
		Thread implementThread = new Thread(new ImplementRunnable());
		implementThread.setPriority(10);
		
		extendThread.start();
		implementThread.start();
		for (int i = 0; i <100; i++) {
			System.out.println("Hey-Driver");
		}
		if (extendThread.isAlive()) {
			System.out.println("Extend is Alive!");
		}
		
	}

}
