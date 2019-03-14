package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Dao.CheckStatusDaoImpl;

/**
 * Servlet implementation class CheckStatus
 */
public class CheckStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckStatusServlet() {
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
		// TODO Auto-generated method stub
		//String sId = request.getParameter("name");
		//int studentID= Integer.parseInt(sId);
		//System.out.println(sId);
		CheckStatusDaoImpl check = new CheckStatusDaoImpl();
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String status = "";
		double loan = 0;
		try {
			status = check.checkStatus(LoginServlet.getSearchId());
			loan = check.getLoan(LoginServlet.getSearchId());
			switch(status) {
				case "Approved":
					pw.write("<h2>Congradulations! Your Account has been Approved for the following amount: " + loan);
					pw.close();
					break;
				case "Pending":
					pw.write("<h2>Your Reimbursement is still pending...");
					pw.close();
					break;
			}
			if(status.isEmpty()) {
				pw.write("<h2>There is no Reimbursement Associated with this account.<h2>");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
