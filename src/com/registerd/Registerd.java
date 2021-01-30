package com.registerd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registerd")
public class Registerd extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

String uname = request.getParameter("uname");
   String fname = request.getParameter("fname");
   String edate = request.getParameter("edate");
   String gnd = request.getParameter("gnd");
   String dmail = request.getParameter("dmail");
   String pin = request.getParameter("pin");
   String acc = request.getParameter("acc");
   String amnt = request.getParameter("amnt");
   String addr = request.getParameter("addr");


   if(uname.isEmpty()|| fname.isEmpty() || edate.isEmpty() || gnd.isEmpty() || dmail.isEmpty() || pin.isEmpty() || acc.isEmpty() || amnt.isEmpty() || addr.isEmpty())
   {
	   RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
       out.println("<font color=blue>Please fill all the Fileds<font>");
       rd.include(request, response);  
	}
	else {
		
		try{
    Connection connection = null;
     
     PreparedStatement pstatement = null;

     Class.forName("com.mysql.jdbc.Driver");

     

              connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1234");

              String queryString = "INSERT INTO Registration(uname, fname , edate , gnd, dmail, pin , acc, amnt , addr ) VALUES (?,?,?,?,?,?,?, ?, ?)";
              	     
              pstatement = connection.prepareStatement(queryString);
              pstatement.setString(1, uname);
			  pstatement.setString(2, fname);
			  pstatement.setString(3, edate);
			  pstatement.setString(4, gnd);
			  pstatement.setString(5, dmail);
			  pstatement.setString(6, pin);
			  pstatement.setString(7, acc);
			  pstatement.setString(8, amnt);
			  pstatement.setString(9, addr);
			  
			  
			  pstatement.executeUpdate();
              pstatement.close();
              connection.close();   
            } 
            catch (Exception ex) {
            out.println(ex);
   
               }

	  
            RequestDispatcher rd = request.getRequestDispatcher("RegisOut.jsp");
            rd.forward(request, response);  
		
		
	}

}
}
