<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
BookBean bb=(BookBean)request.getAttribute("bbean");
RegisterBean rb=(RegisterBean)session.getAttribute("rbean");
out.println("This page belongs to "+rb.getFname()+"<br>");
out.println("Book Code: "+bb.getCode()+"<br>");
out.println("Book Name: "+bb.getName()+"<br>");
out.println("Book author:  "+bb.getAuthor()+"<br>");
out.println("Book Price:  "+bb.getPrice()+"<br>");
%>
<form action="purchase"method="post">
<input type="hidden" name="bcode" value=<%=bb.getCode() %>>
RequiredQty:<input type="text" name="rqty"><br>
<input type="submit" value="Buy Book">
</form>
</body>
</html>