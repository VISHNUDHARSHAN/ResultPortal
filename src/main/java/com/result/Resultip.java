package com.result;

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
public class Resultip extends HttpServlet {
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
		String rno=request.getParameter("rollno");
		String name=request.getParameter("uname");
		String mark1=request.getParameter("m1");
		String mark2=request.getParameter("m2");
		String mark3=request.getParameter("m3");
		int irno=Integer.parseInt(rno);
		int im1=Integer.parseInt(mark1);
		int im2=Integer.parseInt(mark2);
		int im3=Integer.parseInt(mark3);	
		int total=im1+im2+im3;
		float avg=(float)total/3;
		String res;
		if(im1>=40 && im2>=40 && im3>=40) {
			res="pass";
		}
		else {
			res="fail";
		}
		
		PrintWriter out = response.getWriter();
		try
		{
			//System.out.println("trying.....");
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?" +
		                "user=root&password=vishnu");
		
		 PreparedStatement stmt=conn.prepareStatement("insert into Result values(?,?,?,?,?,?,?,?)");
		   stmt.setInt(1,irno);
		   stmt.setString(2,name);
		   stmt.setInt(3,im1);
		   stmt.setInt(4,im2);
		   stmt.setInt(5,im3);
		   stmt.setInt(6,total);
		   stmt.setFloat(7,avg);
		   stmt.setString(8,res);
	   
	 	  stmt.executeUpdate();
	            
  	
		out.println("<body bgcolor=aqua text=blue >");
		 out.println("<center><h1>RECORD HAS BEEN INSERTED SUCCESSFULLY.... </h1></center>");
		out.println("<br><center><a href=Resultip.html>RESULT INPUT</a></center>");
		out.println("<br><center><a href=Resultview.html>RESULT VIEW</a></center>");
		}
		catch(Exception e)
		{
			out.println("Exception "+e);
		}
		 out.flush();
	      out.close();
	}

}
