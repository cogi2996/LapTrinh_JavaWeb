<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>



<form action="edit" method="get">
	<input type="hidden" name="id" value=${model.cateID}>
	<input type="text" name ="NewCateName"  value=${model.cateName}> name cate
	<input type="text" name ="NewImages" value=${model.images}> img link 
	<input type="submit"value="Edit category">
</form>
<body>

</body>
</html>