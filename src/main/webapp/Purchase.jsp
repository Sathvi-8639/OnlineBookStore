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
BookBean bb=(BookBean)request.getAttribute("bbean");
String msg=(String)request.getAttribute("msg");
out.println("This page belongs to "+rb.getFname()+"<br>");
int rqty=Integer.parseInt(request.getParameter("rqty"));
out.println("Amount Paid: "+rqty*bb.getPrice()+"<br>");
out.println(msg+"<br>");

%>
<a href="logout">LogOut</a>
</body>
</html>