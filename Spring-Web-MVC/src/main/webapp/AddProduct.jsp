<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<center>
			<h1>Add Product</h1>
			<form action="showProduct">
				<input type="number" placeholder="Enter Id" required
				name="id">
				<br><br>
				<input type="text" placeholder="Enter Product Name" required
				name="name">
				<br><br>
				<label>Select Quantity</label><br>
				<select name="quantity">
					<option>-SELECT-</option>
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="30">30</option>
				</select>
				<br><br>
				<input type="text" placeholder="Enter Price" required
				name="price">
				<br><br>
				<input type="submit" value="ADD">
				<br><br>
			</form>
		</center>
</body>
</html>