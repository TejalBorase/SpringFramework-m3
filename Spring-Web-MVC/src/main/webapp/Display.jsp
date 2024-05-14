<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<h1>Original String = <%= request.getAttribute("original")%></h1>
			<h1>String without Duplicates = <%= request.getAttribute("duplicatesRemove")%></h1>
</body>
</html>