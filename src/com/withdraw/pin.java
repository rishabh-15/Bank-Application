package com.withdraw;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pin
 */
@WebServlet("/pin")
public class pin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();		
		
		String acnt=request.getParameter("ac");
		int acno=Integer.parseInt(acnt);
		


		String nee =request.getParameter("pn");
		int neew =Integer.parseInt(nee);
		
		
		Calendar calendar = new GregorianCalendar();
        System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
        System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
        System.out.println("DATE: " + calendar.get(Calendar.DATE));
        String dor =String.valueOf(calendar.get(Calendar.DATE))+"/"+String.valueOf(calendar.get(Calendar.MONTH))+"/"+String.valueOf(calendar.get(Calendar.YEAR));
       

		try{

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1234");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from registration where acc="+acno);
            
            PreparedStatement pstmt = con.prepareStatement("update registration set pin=? where acc="+acno);
            pstmt.setDouble(1,neew);
            pstmt.executeUpdate();
            out.println("<html>\n"+ "<body>\n" + "<h4 align = \"center\"><br><br><br><br><br>");
            out.println("PIN No. Updated is Updated successfully !" +"<br>");
            out.println("Your New Pin no. is : "+neew + "<br><br>");
            out.println("Date : "+dor);

            out.println("</h3>\n" +"<a href = welcome.jsp><h3 align=center>Go Back</h3></a>\n"+"</body></html>" );
            pstmt.close();
		  }
		  catch (Exception se)
		  {
		  }
		}
	}


