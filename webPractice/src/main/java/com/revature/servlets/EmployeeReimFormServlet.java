package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Dao.FormsDaoImpl;
import com.revature.beans.ReimbursementForm;

/**
 * Servlet implementation class EmployeeReimFormServlet
 */
public class EmployeeReimFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeReimFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String eID = request.getParameter("employeeID");
		String sID = request.getParameter("studentID");
		String cost = request.getParameter("cost");
		String grade = request.getParameter("grade");
		String eventType = request.getParameter("eventType");
		String comments = request.getParameter("comments");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		
		ReimbursementForm reimbursementform = new ReimbursementForm(fname, lname, eID, cost, grade, eventType, 
				comments, month, day, year, street, city, state);
		
		FormsDaoImpl submitForm = new FormsDaoImpl();

		try {
			submitForm.submitEmployeeForm(reimbursementform, Integer.parseInt(sID));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write("<h2 class id=\"submitMessage\"> Submittion Successful</h2>");
	}
	

}
