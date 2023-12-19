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
ArrayList<BookBean> al=(ArrayList<BookBean>)session.getAttribute("alist");
RegisterBean rb=(RegisterBean)session.getAttribute("rbean");
out.println("This page belongs to "+rb.getFname()+"<br>");
if(al.size()==0){
	out.println("Books are not available......");
	
}else{
	Iterator<BookBean> it=al.iterator();
	while(it.hasNext()){
		BookBean bb=it.next();
		out.println(bb.getCode()+"&nbsp&nbsp"+bb.getName()+"&nbsp&nbsp"+
					bb.getAuthor()+"&nbsp&nbsp"+bb.getPrice()+"&nbsp&nbsp"+bb.getQty()
					+"<a href='buy?bcode="+bb.getCode()+"'>buy</a><br>");
	}
}

%>
<a href="logout">LogOut</a>
</body>
</html>