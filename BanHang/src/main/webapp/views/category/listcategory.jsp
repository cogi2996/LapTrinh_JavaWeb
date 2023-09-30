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
	<c:if test="${message!=null}">
		<span>${message}</span>
	</c:if>
	<c:if test="${error!=null}">
		<span>${error}</span>
	</c:if>
	<table border="1" style="width: 100%">
		<thead>
			<th>ID</th>
			<th>Name</th>
			<th>Icon</th>
			<th>Action</th>
		</thead>
		<tbody>
			<c:forEach var="item" items="${listcate}">
				<tr>
					<td>${item.cateID}</td>
					<td>${item.cateName}</td>
					<td>${item.images}</td>
					<td><a href ="update?id=${item.cateID}">Update</a> ||<a href ="delete?id=${item.cateID}"> Delete</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</body>
</html>
