<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<style>

    section{
        
        width:100%;
        margin:3px;
        text-align:center;
    }
    body{
background:orange;
color:black;
} 
 h1 {
 style=color:black;
 text-align:center;
 }

 </style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Registerd">

<h1>**REGISTRATION**</h1> <br><br>


<section>
Name:<input type="text" autocomplete="off" name="uname">
<br><br>
Father name:<input type="text" autocomplete="off" name="fname">
<br><br>
Date of Birth :<input type="date" name="edate">
<br><br>
Gender :<input type="radio" name="gnd" value="Male">Male
<input type="radio" name="gnd" value="female">Female
<input type="radio" name="gnd" value="Other">Other
<br><br>
Email Id : <input type="email" autocomplete="off" name="dmail">
<br><br>
PIN Number : <input type="text" autocomplete="off" name="pin">
<br><br>
Account No. : <input type="text" autocomplete="off" name="acc">
<br><br>
Amount Deposit : <input type="text" autocomplete="off" name="amnt">
<br><br>
Address: <textarea rows = "5" cols = "20" name = "addr">
</textarea>
<br><br>
<input type="submit" value="Registerd"><br><br>



</section>

</form>
</body>
</html>