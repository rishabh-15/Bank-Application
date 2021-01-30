<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<Style>
body{
background:gray;
color:white;
} </Style>
</head>
<body>
<%   
 
 if(session.getAttribute("username")==null)
 {
	 response.sendRedirect("login.jsp");
 } 
 %>
  <h1 align ="center">* Learn Python * </h1>
  <iframe width="560" height="315" src="https://www.youtube.com/embed/WGJJIrtnfpk" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</body>
</html>