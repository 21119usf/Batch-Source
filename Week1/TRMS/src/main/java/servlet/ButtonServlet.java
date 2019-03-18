package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import beans.ButtonChoice;
import imp.UpdateIMP;

/**
 * Servlet implementation class ButtonServlet
 */
public class ButtonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ButtonServlet() {
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
		ObjectMapper ob = new ObjectMapper();
		HttpSession session = request.getSession();
		ButtonChoice bc = ob.readValue(request.getInputStream(), ButtonChoice.class);
		if(bc.getbtn().equals("approve")) {
			UpdateIMP ui = new UpdateIMP();
			try {
				ui.Approve(bc.getId(), Integer.parseInt(session.getAttribute("supervisor").toString()));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}if(bc.getbtn().equals("deny")) {
			UpdateIMP ui = new UpdateIMP();
			try {
				ui.Deny(bc.getId(), Integer.parseInt(session.getAttribute("supervisor").toString()));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}if(bc.getbtn().equals("edit")) {
			
		}if(bc.getbtn().equals("accept")) {
			
		}
		System.out.println(bc);
		
		doGet(request, response);
	}

}
