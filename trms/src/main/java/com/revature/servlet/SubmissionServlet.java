package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Form;
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
		System.out.println("Inside of doGet");
		RequestDispatcher rd = request.getRequestDispatcher("form.html");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		System.out.println("Inside of doPost");
		System.out.println(request.getReader().readLine());
		ObjectMapper om = new ObjectMapper();
		request.getRequestDispatcher("form.html").forward(request, response);
		Form root = om.readValue(request.getReader().readLine(), Form.class);
		root.toString();
		
//		fdi.submitForm(fullName, date, startTime, endTime, location, description, cost, gradingFormat, eventType, supervisor, benCo);
		
	}
}
