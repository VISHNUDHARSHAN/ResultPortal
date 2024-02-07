package com.welcome;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class login
 */
public class Logindb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
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
		System.out.println("servle called");
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		try
		{
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vishnu?" +
		                "user=root&password=vishnu");
		
		 PreparedStatement stmt=conn.prepareStatement("select * from Application where username=? and pass=?");
		   stmt.setString(1,uname);
		   stmt.setString(2,pass);
	 	  ResultSet rs=stmt.executeQuery();
	 	  if(rs.next())
	 	  {
		//out.println("<body bgcolor=aqua text=red >");
		 //out.println("<center><h1>login successfully </h1></center>");
		 response.sendRedirect("Resultview.html");
		}
	 	  else
	 	  {
	 		 response.sendRedirect("Relogin.html");
	 	  }
		}
		catch(Exception e)
		{
			out.println("Exception "+e);
		}
		 out.flush();
	      out.close();
	}
	}
