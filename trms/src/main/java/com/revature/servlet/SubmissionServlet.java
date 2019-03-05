package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daoimpl.FormDaoImpl;

public class SubmissionServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1630794454522168601L;

	public SubmissionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher("form.html");
		System.out.println("Inside of doGet");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		ObjectMapper mapper= new ObjectMapper();
		FormDaoImpl fdi = new FormDaoImpl();
		String fullName = mapper.readValue(request.getParameter("fullName"), String.class);
		String date = mapper.readValue(request.getParameter("date"), String.class);
		String startTime = mapper.readValue(request.getParameter("startTime"), String.class);
		String endTime = mapper.readValue(request.getParameter("endTime"), String.class);
		String location = mapper.readValue(request.getParameter("location"), String.class);
		String description = mapper.readValue(request.getParameter("description"), String.class);
		Double cost = Double.parseDouble(mapper.readValue(request.getParameter("cost"), String.class));
		String gradingFormat = mapper.readValue(request.getParameter("gradingFormat"), String.class);
		String eventType = mapper.readValue(request.getParameter("type"), String.class);
		String supervisor = mapper.readValue(request.getParameter("supervisor"), String.class);
		String benCo = mapper.readValue(request.getParameter("benCo"), String.class);
		
		fdi.submitForm(fullName, date, startTime, endTime, location, description, cost, gradingFormat, eventType, supervisor, benCo);
		System.out.println("Inside of doPost");
	}
}
