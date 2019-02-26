package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.SuperHero;
import com.revature.dao.SuperHeroDao;
import com.revature.util.ConnFactory;

public class SuperHeroDaoImpl implements SuperHeroDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	@Override
	public void createSuperHero(String heroName) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "{ call INSERTSUPERHERO(?)"; //NO ending curly brace '}'
		CallableStatement call = conn.prepareCall(sql);
		call.setString(1, heroName);
		call.execute();
	}
	
	@Override
	public List<SuperHero> getSuperHeroList() throws SQLException {
		List<SuperHero> superHeroList = new ArrayList<SuperHero>();
		Connection conn = cf.getConnection(); //establish connection to the database
		Statement stmt = conn.createStatement();	//prepare a statement to send to the database
		ResultSet rs = stmt.executeQuery("SELECT * FROM SUPERHERO"); //get the table of info, on the result
		SuperHero s = null;											//of the entered query
		while (rs.next()) {	//Acts similar to a iterator, where you can go through each of the heroes
			//get the first index of the table SQL is NOT ZERO based, start at 1
			s = new SuperHero(rs.getInt(1), rs.getString(2)); //first arg is the first column,
			superHeroList.add(s);												//second arg is the 2nd column
		}
		return superHeroList;
	}
	
	public void updateSuperHeroName(String oldName, String newName) throws SQLException {
		Connection conn = cf.getConnection(); //establish connection to the database
		String sql = "UPDATE SUPERHERO SET HERONAME = ? "
						+ "WHERE HERONAME = ?";	//prepare a statement to send to the database
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, oldName);
		ps.setString(2, newName);
		ps.executeUpdate();
	}
}
