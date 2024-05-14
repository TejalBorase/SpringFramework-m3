<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Demo Output</h1>
	<%--to access data which transferred by controller --%>
	<%
		String name =(String)request.getAttribute("name");
		int number = (Integer)request.getAttribute("number");
	%>
	
	<h1><%= number%></h1>
	<h1><%= name%></h1>
</body>
</html>










