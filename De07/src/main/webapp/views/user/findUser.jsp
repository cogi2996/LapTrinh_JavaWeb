<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<form action="<c:url value="/findUser"></c:url>" method="post">
		<div class="form-group">
			<label for="inputUsername">Tìm kiếm</label> <input type="text"
				class="form-control" id="inputUsername" name="inputFind"
				placeholder="fullname or email">
		</div>
		<button type="submit" class="btn btn-default">Tìm kiếm</button>
	</form>
	<div>
		<c:forEach items="${listUser}" var="user">
				<span>${user}</span>
				<br>
		</c:forEach>
	</div>

</div>
