<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<a href='<c:url value="/admin-addUser"></c:url>'>Add New User</a>
<table border="1" style="width: 100%;">
	<thead>
		<th>User ID</th>
		<th>Email</th>
		<th>Fullname</th>
		<th>Phone</th>
		<th>Signup Date</th>
		<th>Last Login</th>
	</thead>
	<tbody>
		<c:forEach var="user" items="${listUser}">
			<tr>
				<td>${user.id}</td>
				<td>${user.email}</td>
				<td>${user.fullname}</td>
				<td>${user.phone}</td>
				<td>${user.signup_date}</td>
				<td>${user.last_login}</td>
				<td><a
					href='<c:url value="/admin-updateUser?id=${user.id}"></c:url>'>Edit</a></td>
				<td><a
					href='<c:url value="/admin-deleteUser?id=${user.id}"></c:url>'>Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
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
</table>

