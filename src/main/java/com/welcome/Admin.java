package com.welcome;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Admin
 */
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
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
		response.setContentType("text/html");
		System.out.println("servlet called");
		PrintWriter op = response.getWriter();
	
		try
		{
		String n1=request.getParameter("username");
		 String n2=request.getParameter("password");
		if(n1.equals("vishnu") && n2.equals("palar"))
		{
			op.println("<body bgcolor=purple text=cyan >");
			op.println("<h1 align=center >Welcome to 'SERVLET' programme</h1>");
		
		}
		else
		{
			op.println("Invalid username or pasword !...");
			
		}
		}
		catch(Exception e)
		{
			op.println("invalid number"+e);
		}
		op.println("</body>");
        op.flush();
        op.close();
	}

}
