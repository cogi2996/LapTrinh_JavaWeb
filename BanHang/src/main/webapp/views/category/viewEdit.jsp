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
<form action="update" method="post">
	<input type="hidden" name="NewCateID" value=${model.cateID}>
	name cate<input type="text" name ="NewCateName"  value=${model.cateName}> 
	img link <input type="text" name ="NewImages" value=${model.images}> 
	<input type="submit"value="Edit category">
</form>
</body>
</html>