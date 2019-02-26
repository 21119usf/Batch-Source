package com.revature.driver;

import java.sql.SQLException;
import java.sql.Savepoint;

import com.revature.daoimpl.PowersDaoImpl;
import com.revature.daoimpl.SuperHeroDaoImpl;

public class Driver {

	public static void main(String[] args) {
		SuperHeroDaoImpl shdi = new SuperHeroDaoImpl();
		PowersDaoImpl pdi = new PowersDaoImpl();
		/*try {
			System.out.println(shdi.getSuperHeroList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		try {
			//pdi.createPower("FLIGHT");
			
			shdi.createSuperHero("Onepunchman");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
