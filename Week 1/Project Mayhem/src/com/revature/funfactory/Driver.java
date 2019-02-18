package com.revature.funfactory;

public class Driver {
	private static HondaFactory hf = new HondaFactory();
	public static void main(String[] args) {
		Car c1 = hf.getCar("crv", "white");
		Car c2 = hf.getCar("civic", "yellow");
		
		Car c3 = hf.getCar("potato", "clear");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

	}

}
