package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.Reimbursement;
import imp.ReadIMP;

/**
 * Servlet implementation class GetReimbursements
 */
public class GetReimbursements extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReimbursements() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ReadIMP read = new ReadIMP();
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = request.getSession();
		
		ArrayList<Reimbursement> list = null;
		
		try 
		{
			list = read.getMyReimbursement(Integer.parseInt(session.getAttribute("id").toString()));
		} 
		catch (NumberFormatException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		
		String employeeJSON = mapper.writeValueAsString(list);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(employeeJSON);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
