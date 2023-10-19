<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/BanHang_jpaa/category/insert" method="get">
    <label for="CategoryID">Category ID:</label> 
    <input type="text" id="CategoryID" name="CategoryID"> 
    <br> 
    <label for="CategoryName">Category Name:</label> 
    <input type="text" id="CategoryName" name="CategoryName"> 
    <br> 
    <label for="icon">Icon:</label> 
    <input type="text" id="icon" name="icon">
    <br>
    <input type="submit" value="Create Category">
</form>

</body>
</html>