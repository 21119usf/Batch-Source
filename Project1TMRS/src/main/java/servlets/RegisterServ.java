package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import daos.EmployeeDao;
import employeestuff.EmpInfo;

/**
 * Servlet implementation class RegisterServ
 */
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet....test");
		EmpInfo x =null;
		ObjectMapper mapper= new ObjectMapper();
		EmployeeDao b = new EmployeeDao();
		//String query= request.getQueryString();
		//System.out.println(query);
		
		
		
		String r = mapper.readValue(request.getParameter("name"), String.class);
		String r1 = mapper.readValue(request.getParameter("username"), String.class);
		String r2 = mapper.readValue(request.getParameter("password"), String.class);
		String r3 = mapper.readValue(request.getParameter("email"), String.class);
		
		//System.out.println(id);
		PrintWriter out = response.getWriter();
		String emplJSON;
		try {
			emplJSON = mapper.writeValueAsString(b.getEmpInfo(r, r1, r2, r3));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(emplJSON);
			System.out.println(emplJSON);
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost");
		EmpInfo x=null;
		ObjectMapper mapper= new ObjectMapper();
		x= mapper.readValue(request.getInputStream(),EmpInfo.class);
		System.out.println(x);
		EmployeeDao z= new EmployeeDao();
		try {
			z.insertEmpl(x);
			PrintWriter pw = response.getWriter();
			pw.write("<h3>Added Employee</h3>");
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
