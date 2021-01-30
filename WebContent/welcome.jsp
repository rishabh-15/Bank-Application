<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<Style>

body{
background:#ccccdd;
color:black;
} 

    section{
        text-decoration:underline;
        width:100%;
        margin:3px;
        text-align:center;
    }

</style>
<title>Insert title here</title>
</head>
<body><h2 align="center"> ** Bank Application **</h2></br></br></br>
<%
response.setHeader("cache-control","no-cache , no-store, must-revalidate");
if(session.getAttribute("username")==null)
    {
        response.sendRedirect("login.jsp"); 
    }   
%>
    <section>  Welcome user  ${uname} !<b></br></br></br></br>
  <%  String acno=(String)session.getAttribute("sess");
                                    System.out.println(acno);
                                    %>

<a  href="debit.jsp"><h3 align="left">Debit the Amount</h3></a>
<a href="credit.jsp"><h3 align="Right">Credit the Amount</h3></a><br><br>
<a href="mon.jsp"><h3 align="left">Monthly Record</h3></a><br><br>
<a href="pinc.jsp"><h3 align="Right">Change PIN</h3></a><br><br>
      <form action = "Logout">
      <input type ="submit" value = "logout"></form>
      </section>



</body>
</html>