package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Employee;
import beans.LoginInfo;
import beans.Reimbursement;
import imp.ReadIMP;

public class HomeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -725707861666507866L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
//		String nextHTML = "/Login.html";
//		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextHTML);
//		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		//System.out.println("test");
		ReadIMP read = new ReadIMP();
		ObjectMapper mapper = new ObjectMapper();
		LoginInfo info = mapper.readValue(req.getInputStream(), LoginInfo.class);
		HttpSession session = req.getSession();
		Employee employee = null;
		ArrayList<Reimbursement> list = null;
		PrintWriter out = resp.getWriter();
		
		try 
		{
			if(read.checkLogin(info.getUsername(), info.getPassword()) != null)
			{
				//System.out.println("help");
				employee = read.checkLogin(info.getUsername(), info.getPassword());
				session.setAttribute("username", employee.getUsername());
				session.setAttribute("id", employee.getId());
				session.setAttribute("supervisor", employee.getSupervisor());
				
				String message = mapper.writeValueAsString("Success");
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				out.print(message);
				out.flush();
			}
			else
			{
				//System.out.println("me");
				String message = mapper.writeValueAsString("Invalid Login");
				resp.setContentType("application/json");
				resp.setCharacterEncoding("UTF-8");
				out.print(message);
				out.flush();
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
}
