package com.revature.classtypes;

public class Shark extends FIsh implements Hunt{

	@Override
	public void findPrey() {
		System.out.println("I ate fishes!");
		
	}

	@Override
	public void breathe() {
		System.out.println("I breate underwater, meeeeegh");
		
	}

	@Override
	public void swim() {
		System.out.println("I'm swim in water and im terrifying.");
		
	}

}
