<%@page import="java.util.List"%>
<%@page import="com.jsp.SpringWebMVC.controller.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
			String msg = (String)request.getAttribute("message");
			Product product = (Product)request.getAttribute("productObj");
			List<Product> list = (List)request.getAttribute("listOfProduct");
		%>
			<h1><%= msg%></h1>
			<h1><%= product%></h1>
			<table>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Quantity</td>
				<td>Price</td>
				<td>DELETE</td>
			</tr>
		<%
			for(Product p : list){
		%>
			<tr>
				<td><%= p.getId()%></td>
				<td><%= p.getName()%></td>
				<td><%= p.getQuantity()%></td>
				<td><%= p.getPrice()%></td>
				<td>
					<a href="/assignment/deleteProduct/<%= p.getId()%>">
						<button>DELETE</button>
					</a>
				</td>
			</tr>
		<%
			}
		%>
		</table>
		<style>
			table,td{
				border: 3px solid black;
				font-size:30px;
				padding:10px;
			}
		</style>
			
</body>
</html>









