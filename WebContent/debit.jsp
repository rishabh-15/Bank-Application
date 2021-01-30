<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    section{
        
        width:100%;
        margin:3px;
        text-align:center;
    }
    </style>
</head>
<body>
<section>
<h1> *Debit Amount* </h1>
<br><br><br><form action="debit" method ="post">
<body bgcolor="#ccccdd">
Enter the Account NO : <input type="text" autocomplete="off" name="ac"><br><br>
Enter the Amount :<input type="text" autocomplete="off" name="amnt"><br><br>
<input type="submit" value="Debit"></section>
</body>
</html>