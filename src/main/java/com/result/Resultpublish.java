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
import java.sql.ResultSet;

/**
 * Servlet implementation class Resultpublish
 */
public class Resultpublish extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		 public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
		 {
		   res.setContentType("text/html");
		   PrintWriter out=res.getWriter();
		   String str=req.getParameter("reg");

		    int reg=Integer.parseInt(str);
		    out.println("<html><body bgcolor=cyan text=black>");
		    out.println("<center><h1>Anna University</h1><br><h2>April 2021 Result</h2></center><br><br>");
		    try
		    {
		      Class.forName("com.mysql.jdbc.Driver");
		   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","vishnu");
		      PreparedStatement stmt=conn.prepareStatement("select * from Result where rno=?");
		      stmt.setInt(1,reg);
		      ResultSet rs=stmt.executeQuery();
		      if(rs.next())
		      {
		        out.println("Register No          :"+rs.getInt("rno")+"<br><br>");
		        out.println("Name                     :"+rs.getString("uname")+"<br><br><br><br>");
		        out.println("<center>");
		        out.println("<table border=3>");
		        out.println("<tr><th>SUBJECT CODE</th><th>Marks</th></tr>");
		  out.println("<tr><td>Mark1</td><td>"+rs.getInt("m1")+"</td></tr>");
		        out.println("<tr><td>Mark2</td><td>"+rs.getInt("m2")+"</td></tr>");
		        out.println("<tr><td>Mark3</td><td>"+rs.getInt("m3")+"</td></tr>");
		        out.println("<tr><td>Total</td><td>"+rs.getInt("tot")+"</td></tr>");
		out.println("<tr><td>Average</td><td>"+rs.getFloat("aveg")+"</td></tr>");
		out.println("<tr><td>Result </td><td>"+rs.getString("verdict")+"</td></tr>");
		        out.println("</table></center>");
		      }
		      else
		      {
		        out.println("<center><h2>Please check your register no</h2></center>");
		      }
		      stmt.close();
		      conn.close();
		    }
		    catch(Exception e)
		    {
		      out.println("Error"+e);
		    }
		    out.println("</body></html>");
		 }
		}
