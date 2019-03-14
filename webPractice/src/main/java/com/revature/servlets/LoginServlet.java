package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Dao.LoginDaoImpl;
import com.revature.beans.User;
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	static int searchID;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("MainLogin.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usr = request.getParameter("username");
		String pswd = request.getParameter("password");
		String loginoption = request.getParameter("loginoption");
		//Cookie cookie = new Cookie("username",usr);
		//boolean userexists = false;
		List<Cookie> cookies = new ArrayList<Cookie>();
//		for(int i=0;i<cookies.size();i++) {
//			if(cookies.get(i).getValue().equals(usr)) {
//				System.out.println(cookies.get(i).getValue());
//				userexists = true;
//			}
//		}
//		
		User user = new User(usr, pswd);
		boolean status = false;
		LoginDaoImpl login = new LoginDaoImpl();
		switch(loginoption) {
		case"Student":
				try {
					status = (boolean)login.studentLogin(user).get(0);
					int s = (Integer)login.studentLogin(user).get(1);
					searchID=s;
					//Cookie cookie = new Cookie("searchId",s);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(status==true) {
					request.getRequestDispatcher("StudentFundshtml.html").forward(request, response);
					break;
				}
				else {
					response.setContentType("text/html"); //we are writing to the html directly
					PrintWriter pw = response.getWriter();// this is why we are using response
					
					pw.write("<h1>You didnt login</h1>");
					pw.close();
					break;
				}
		
			case"Employee":
				try {
					status = login.employeeLogin(user);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(status) {
					request.getRequestDispatcher("Employee.html").forward(request, response);
					break;
				}
				else {
					response.setContentType("text/html"); //we are writing to the html directly
					PrintWriter pw = response.getWriter();// this is why we are using response
					
					pw.write("<h1>You didnt login</h1>");
					
					pw.close();
					break;
				}
				
			case "BenCo":
				try {
					status = login.BencoLogin(user);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(status) {
					request.getRequestDispatcher("BencoAcct.html").forward(request, response);
					break;
				}
				else {
					response.setContentType("text/html"); //we are writing to the html directly
					PrintWriter pw = response.getWriter();// this is why we are using response
					
					pw.write("<h1>You didnt login</h1>");
					
					pw.close();
					break;
				}
				
	
		}
	}
	public static int getSearchId() {
		return searchID;
	}
}
