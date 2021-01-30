<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import= " java.sql.*" %>

<%
out.println("<a href = welcome.jsp><h3 >Go Back</h3></a>" );

        out.println("<h2 align=center>*Mini Statement*</h2><br><br>");
		out.println("<table border ='1' width='100%' >");
  try
  {
      Class.forName("com.mysql.jdbc.Driver");
  	  String sql = "select * from month";
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "1234");
         
      Statement st = con.createStatement();
      ResultSet rs=st.executeQuery(sql);
      
      out.println( "<tr><th>DATE</th> <th>TOTAL BALANCE</th><th>ACCOUNT NO.</th><th>STATUS</th><th>AMOUNT</th></tr>");

 
      while(rs.next())
      {
              String a = rs.getString("dor");
              Double b = rs.getDouble("totbal");
              int c =rs.getInt("acno");
              String d=rs.getString("typed");
             int e =rs.getInt("iamount");
           out.println("<tr><th>"+a+"</th><th>"+b+"</th><th>"+c+"</th><th>"+d+"</th><th>"+e+"</th></tr>");   
          }

  st.close();
  con.close();
  rs.close();

  }

  catch(Exception e){
     e.printStackTrace();
  }
	%>
  

</body>
</html>