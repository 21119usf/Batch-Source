package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimplementation.PowersDaoImplementation;
import com.revature.daoimplementation.SuperHeroDaoImplementation;

public class Driver {

	public static void main(String[] args) {
		SuperHeroDaoImplementation shdi = new SuperHeroDaoImplementation();
		PowersDaoImplementation pdi = new PowersDaoImplementation();
		try {
			//pdi.createPower("FLIGHT");
			shdi.createSuperHero("Saitama");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		/*
		try {
			System.out.println(shdi.getSuperHeroList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
	}
}
