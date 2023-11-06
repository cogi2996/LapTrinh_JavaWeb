<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
	<a href='<c:url value ="/admin-addUser"></c:url>'>Add New User</a>
	<table border="1" style="width: 100%;">
		<thead>
			<th>Username</th>
			<th>Full Name</th>
			<th>Email</th>
			<th>Active</th>
			<th>Actions</th>
		</thead>
		<tbody>
			<c:forEach var="user" items="${listUser}">
				<tr>
					
					<td><a href='<c:url value ="/likedVideo?username=${user.username}"></c:url>'>${user.username}</a></td>
					<td>${user.fullname}</td>
					<td>${user.email}</td>
					<td>${user.active ? 'Yes' : 'No'}</td>
					<td><a
						href='<c:url value = "/admin-UpdateUser?username=${user.username}"/>'>Update</a>
						<a
						href='<c:url value = "/admin-DeleteUser?username=${user.username}"/>'>Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="col-md-8 col-sm-8">
		<ul class="pagination pull-right">
			<c:if test="${tag>1}">
				<li><a
					href="${pageContext.request.contextPath}/admin-listUser?index=${tag-1}">&laquo;</a></li>
			</c:if>
			<c:forEach begin="1" end="${endP}" var="i">
				<li class='${tag==i?"active":"" }'><a
					href="${pageContext.request.contextPath}/admin-listUser?index=${i}">${i}</a></li>
			</c:forEach>
			<c:if test="${tag<endP}">
				<li><a
					href="${pageContext.request.contextPath}/admin-listUser?index=${tag+1}">&raquo;</a></li>
			</c:if>
		</ul>
	</div>

</body>
</html>
