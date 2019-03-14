package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Dao.FormsDaoImpl;
import com.revature.beans.Employee;
import com.revature.beans.ReimbursementForm;
import com.revature.beans.Student;
import com.revature.beans.User;

/**
 * Servlet implementation class GetFormsServlet
 */
public class GetFormsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFormsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId = request.getParameter("name");
		String checkRequester=request.getParameter("requester");
		User user = new User(studentId);
		FormsDaoImpl getForms = new FormsDaoImpl();
		try {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			
			if(checkRequester.equals("BenCo")) {
				List<Object> form= getForms.getReimbursementInfo(user.getUserID());
				ReimbursementForm rForm = (ReimbursementForm)form.get(0);
				Employee employee = (Employee)form.get(1);
				Student student  = (Student)form.get(2);
				pw.write("<div class=\"row col-sm-10 offset-1 text-center\">"
						+"<table class=\"table table-hover table-bordered table-dark w-auto\">"
						+ "<thead>"
							+"<tr>"
								+ "<th>Firstname</th>"
								+ "<th>Lastname</th>"
								+ "<th>Emplpoyee ID</th>"
							+ "</tr>"
						+ "</thead>"
						+ "<tbody>"
							+"<tr class=\"bg-info\">"
								+ "<td>"+employee.getFname()+"</td>"
								+ "<td>"+employee.getLname()+"</td>"
								+ "<td>20</td>"
							+"</tr>"
						+"</tbody>"
						+ "</table>"
						+ "<table class=\"table table-hover table-bordered table-dark w-auto\">"
						+ "<thead>"
							+"<tr>"
								+ "<th>Firstname</th>"
								+ "<th>Lastname</th>"
								+ "<th>Student ID</th>"
								+ "<th>Letter Grade</th>"
								+ "<th>Grade</th>"
							+ "</tr>"
						+ "</thead>"
						+ "<tbody>"
							+"<tr class=\"bg-info\">"
								+ "<td>"+student.getFname()+"</td>"
								+ "<td>"+student.getLname()+"</td>"
								+ "<td>"+student.getStudentID()+"</td>"
								+ "<td>"+rForm.getLetterGrade()+"</td>"
								+ "<td>"+rForm.getGrade()+"</td>"

							+"</tr>"
						+"</tbody>"
						+ "</table>"
						+"<table class=\"table table-hover table-bordered table-dark w-auto\">"
								+ "<thead>"
								+"<tr>"
									+ "<th>Date</th>"
									+ "<th>Time</th>"
									+ "<th>Cost</th>"
									+ "<th>Event Type</th>"
									+ "<th>Work-Related Justification</th>"
									+ "<th>Grading Format</th>"
									+ "<th>Letter Grade</th>"
									+ "<th>Grade</th>"
								+ "</tr>"
							+ "</thead>"
							+ "<tbody>"
								+"<tr class=\"bg-info\">"
									+ "<td>"+rForm.getDate()+"</td>"
									+ "<td>"+rForm.getTime()+"</td>"
									+ "<td>"+rForm.getCost()+"</td>"
									+ "<td>"+rForm.getEventType()+"</td>"
									+ "<td>"+rForm.getJustification()+"</td>"
									+ "<td>"+rForm.getGrade_format()+"</td>"
									+ "<td>"+rForm.getLetterGrade()+"</td>"
									+ "<td>"+rForm.getGrade()+"</td>"
								+"</tr>"
							+"</tbody>"
							+ "</table>"
							+ "</div>");
				pw.close();
			}
			
			if(checkRequester.equals("Employee")) {
				ReimbursementForm form = getForms.getStudentForm(user.getUserID());
				pw.write("<div class=\"row col-sm-10 offset-1 text-center\">"
						+ "<table class=\"table table-hover table-bordered table-dark\">"
						+ "<thead>"
							+"<tr>"
								+ "<th>Firstname</th>"
								+ "<th>Lastname</th>"
								+ "<th>Street</th>"
								+ "<th>City</th>"
								+ "<th>State</th>"
								+ "<th>Zip Code</th>"
								+ "<th>Phone #</th>"
								+ "<th>Email</th>"
								+ "<th>Student ID</th>"
							+ "</tr>"
						+ "</thead>"
						+ "<tbody>"
							+"<tr class=\"bg-info\">"
								+ "<td>"+form.getFname()+"</td>"
								+ "<td>"+form.getLname()+"</td>"
								+ "<td>"+form.getStreet()+"</td>"
								+ "<td>"+form.getCity()+"</td>"
								+ "<td>"+form.getState()+"</td>"
								+ "<td>"+form.getZipCode()+"</td>"
								+ "<td>"+form.getPhoneNumber()+"</td>"
								+ "<td>"+form.getEmail()+"</td>"
								+ "<td>"+form.getsID()+"</td>"
							+"</tr>"
						+"</tbody>"
						+"</table>"
						+"</div>");
				pw.close();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		}
		
		
	}

