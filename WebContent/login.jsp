<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
    section{
        text-decoration:underline;
        width:100%;
        margin:3px;
        text-align:center;
    }
    body{
background:black;
color:white;

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h1 align="center">* Bank Application  *</h1><br/>

   <form action ="Login" method="post">
   <section> Enter username :<input type ="text" autocomplete="off" name="uname"> <br/> <br/>
    Enter Account No.  :<input type ="password" name="acc"> <br/> <br/>
    <input type="submit" value="login"> <br/> <a href ="Register.jsp"><h4> Registration </h4> </a><br/>
    </form> 

    
    <%
if(null!=request.getAttribute("errorMessage"))
{
    
    out.println("<p> Invalid username or Account No. !! </p>");
    
}

 %>        
 </section>
</body>
</html>