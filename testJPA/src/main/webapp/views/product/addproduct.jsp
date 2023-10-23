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
	<form action="admin-insertpro" method="post" enctype="multipart/form-data">
	<label>Nhập product name :</label>
	<input type="text" name = "proName">
	<br>
	<label > Nhập desc:</label>
	<textarea name="proDes" cols = 5 class ="form-control" style="width: 100%;"> </textarea>
	<br>
	
	<label>Nhập price: </label>
	<input type="text" name = "proPrice">
	<label>Nhập link hinh: </label>
	<input type="file" name = "imageLink"><br>
	<label for="category">Category:</label>
		<select name="cateID">
			<c:forEach var = "item" items = "${listcate}">
				<option value= "${item.getCateID()}">${item.cateName}</option>			
			</c:forEach>
		</select>
	<label>Nhập stoke: </label>
	<input type="text" name= "amount">
	<input type ="submit" value= "Insert product">
	</form>
</body>
</html>