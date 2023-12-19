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
AdminBean ab=(AdminBean)session.getAttribute("abean");
ArrayList<BookBean> al=(ArrayList<BookBean>)session.getAttribute("alist");
out.println("This page belongs to "+ab.getFname()+"<br>");
if(al.size()==0){
	out.println("Books are not Available");	
}
else{
	Iterator<BookBean> it=al.iterator();
	while(it.hasNext()){
		BookBean bb=it.next();
		out.println(bb.getCode()+"&nbsp"+bb.getName()+"&nbsp"+bb.getAuthor()+"&nbsp"+
		bb.getPrice()+"&nbsp"+bb.getQty()+"&nbsp&nbsp"+"<a href='edit?bcode="+bb.getCode()+"'>edit</a>"+"&nbsp&nbsp"+
		"<a href='delete?bcode="+bb.getCode()+"'>delete</a><br>");
		
	}
}
%>
<a href="logout">LogOut&nbsp;&nbsp;&nbsp;</a>
</body>
</html>