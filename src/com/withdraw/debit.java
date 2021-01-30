package com.withdraw;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class debit
 */
@WebServlet("/debit")
public class debit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public debit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();		
		String amount=request.getParameter("amnt");
		int iamount=Integer.parseInt(amount);

		String acnt=request.getParameter("ac");
		int acno=Integer.parseInt(acnt);

		 

		String type="Debit";
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
		            int totbal=0;
		           while(rs.next())
		           {
		                                                int s1=rs.getInt("amnt");
		                                                if(s1>=500)
		                                                {
		                                                totbal=s1-iamount;
		                                                out.println("<html>\n"+ "<body>\n" + "<h3 align = \"center\"><br><br><br><br><br>");
		                                                out.println("Amount is Debited successfully");
		                                                out.println("Your balance is : "+totbal + "<br><br>");
		                                                out.println("Date : "+dor);

		                                                out.println("</h3>\n" + "<a href = welcome.jsp><h3 align=center>Go Back</h3></a>\n"+"</body></html>" );
		                                                }
		                                                else{
		                                                out.println("Your balance is less than 500,You can't debit the amount");
		                                                totbal=s1;
		                                                }
		                                    }
		                                    PreparedStatement pstmt = con.prepareStatement("update registration set amnt=? where acc="+acno);
		                                                                                    pstmt.setDouble(1,totbal);
		                                                int i = pstmt.executeUpdate();
		                       
		                       
		                       
		                        PreparedStatement pstmt1 = con.prepareStatement("insert into month values(?,?,?,?,?)");
		                                    pstmt1.setString(1,dor);
		                                    pstmt1.setDouble(2,totbal);
		                                    pstmt1.setInt(3,acno);
		                                    pstmt1.setString(4,type);
		                                    pstmt1.setInt(5,iamount);
		                        int i1 = pstmt1.executeUpdate();
		                       
		                        }
		        catch(Exception e){

		        }
		        }
}
