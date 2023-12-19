<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
RegisterBean rb=(RegisterBean)session.getAttribute("rbean");
out.println("This page belongs to "+rb.getFname()+"<br>");
%>
<a href="viewbook">View All Books&nbsp;&nbsp;</a>
<a href="logout">LogOut</a>
</body>
</html>