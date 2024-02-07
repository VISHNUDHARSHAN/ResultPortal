package com.welcome;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class DBconnect
 */
public class DBconnect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	//System.out.println("trying.....");
		response.setContentType("text/html");
		System.out.println("servle called");
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		String mail=request.getParameter("email");
		String phone=request.getParameter("phone");
		String coun=request.getParameter("country");
	
		
		PrintWriter out = response.getWriter();
		try
		{
			//System.out.println("trying.....");
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vishnu?" +
		                "user=root&password=vishnu");
		
		 PreparedStatement stmt=conn.prepareStatement("insert into Application  values(?,?,?,?,?)");
		   stmt.setString(1,uname);
		   stmt.setString(2,pass);
		   stmt.setString(3,mail);
		   stmt.setString(4,phone);
		   stmt.setString(5,coun);
	   
	 	  stmt.executeUpdate();
	            
  	
		out.println("<body bgcolor=aqua text=blue >");
		 out.println("<center><h1>Account has been created Sucessfully </h1></center>");
		out.println("<br><center><a href=Loginwithdb.html>Login</a></center>");
		}
		catch(Exception e)
		{
			out.println("Exception "+e);
		}
		 out.flush();
	      out.close();
	}

}
