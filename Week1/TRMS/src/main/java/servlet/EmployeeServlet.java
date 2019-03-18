package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import imp.LoadIMP;

public class EmployeeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2312984127082052382L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String nextHTML = "/ReimbursementForm.html";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextHTML);
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession();
		double ammount = Double.parseDouble(req.getParameter("ammountReq"));
		int eventType = Integer.parseInt(req.getParameter("reqType"));
		int gradeFormat = Integer.parseInt(req.getParameter("gradeFormat"));
		String reason = req.getParameter("reimbursementReason");
		String location = req.getParameter("location");
		LoadIMP li = new LoadIMP();
		try {
			li.makeReimbursement(Integer.parseInt(session.getAttribute("id").toString()), ammount, location, gradeFormat, eventType, reason, Integer.parseInt(session.getAttribute("supervisor").toString()));
			String nextHTML = "/MainEmployeeMenu.html";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextHTML);
			dispatcher.forward(req, resp);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
