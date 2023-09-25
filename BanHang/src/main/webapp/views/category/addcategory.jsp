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
	<form action="addcate" method="post">
	<label>Nhập category ID</label>
	<input type="text" name = "cateID">
	<label>Nhập category Name</label>
	<input type="text" name = "cateName">
	<label>Nhập category images</label>
	<input type="text" name = "images">
	<input type ="submit" value= "Insert category">
	</form>
</body>
</html>