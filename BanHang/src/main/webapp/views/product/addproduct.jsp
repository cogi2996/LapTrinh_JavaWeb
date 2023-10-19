<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file = "/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="admin-insertpro" method="post" enctype="multipart/form-data">
	<label>Nhập category ID</label>
	<input type="text" name = "proNamek">
	<label>Nhập category Name</label>
	<input type="text" name = "cateName">
	<label>Nhập category images</label>
	<input type="text" name = "images">
	<input type ="submit" value= "Insert category">
	</form>
</body>
</html>