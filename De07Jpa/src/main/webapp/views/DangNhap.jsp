<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value="/Login"></c:url>" method="post">

		<div class="form-group">
			<label for="inputTitle">username: </label> <input type="text"
				class="form-control" id="inputTitle" name="username"
				placeholder="Tên đăng nhập ">
		</div>
		<div class="form-group">
			<label for="inputTitle">pass: </label> <input type="password"
				class="form-control" id="inputTitle" name="password"
				placeholder="Nhập mật khẩu ">
		</div>
		<button type="submit" class="btn btn-default">Đăng Nhập</button>
	</form>

</body>
</html>