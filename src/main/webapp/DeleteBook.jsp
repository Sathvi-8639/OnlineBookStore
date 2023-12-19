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
AdminBean ab=(AdminBean)session.getAttribute("abean");
String msg=(String)request.getAttribute("msg");
out.println("This pages belongs to: "+ab.getFname()+"<br>");
out.println(msg);

%>
<a href="Book.html">Add Book&nbsp;&nbsp;&nbsp;</a>
<a href="view1">View All Books&nbsp;&nbsp;&nbsp;</a>
<a href="logout">LogOut&nbsp;&nbsp;&nbsp;</a>
</body>
</html>