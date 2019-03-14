package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Dao.FormsDaoImpl;
import com.revature.Dao.LoginDaoImpl;
import com.revature.beans.ReimbursementForm;

/**
 * Servlet implementation class StudentSubmitServlet
 */
public class StudentSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSubmitServlet() {
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
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String phonenumber = request.getParameter("phoneNumber");
		String email = request.getParameter("email");
		String studentid = request.getParameter("studentID");
		
		ReimbursementForm reimbursementform = new ReimbursementForm( fname,  lname, street,  city,  state,
				zipcode,  phonenumber,  email,  studentid);
		
		FormsDaoImpl submitForm = new FormsDaoImpl();

		try {
			submitForm.submitStudentForm(reimbursementform);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("StudentSentRequest.html").forward(request, response);
		
	}
}
