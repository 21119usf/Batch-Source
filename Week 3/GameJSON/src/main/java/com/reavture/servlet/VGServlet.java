package com.reavture.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reavture.beans.VideoGame;
import com.revature.dao.VGDaoImpl;

/**
 * Servlet implementation class VGServlet
 */
public class VGServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get info about vg
		System.out.println("in doGet");
		VideoGame vg=null;
		ObjectMapper mapper= new ObjectMapper();
		VGDaoImpl vgdi= new VGDaoImpl();
		//String query= request.getQueryString();
		//System.out.println(query);
		int id = mapper.readValue(request.getParameter("vgid"), Integer.class);
		//System.out.println(id);
		PrintWriter out = response.getWriter();
		String vgJSON;
		try {
			vgJSON = mapper.writeValueAsString(vgdi.getVGbyID(id));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(vgJSON);
			System.out.println(vgJSON);
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.flush();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost");
		VideoGame vg=null;
		ObjectMapper mapper= new ObjectMapper();
		//convert JSON to Java Object
		//YOU NEED A DEFAULT CONSTRUCTOR IN YOUR JAVA OBJECT CLASS IN ORDER TO USE THIS!!!
		vg= mapper.readValue(request.getInputStream(),VideoGame.class);
		//System.out.println(vg);
		VGDaoImpl vgdi= new VGDaoImpl();
		try {
			vgdi.insertVG(vg);
			PrintWriter pw = response.getWriter();
			pw.write("<h3>Added Video Game</h3>");
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
