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
	<table border="1" style="width: 100%">
		<thead>
			<th>book-id</th>
			<th>Title</th>
			<th>Price</th>
			<th>Img</th>

		</thead>
		<tbody>
			<c:forEach var="item" items="${listbook}">
				<tr>
					<td>${item.bookid}</td>
					<td><a
						href='<c:url value = "/admin-findByBookID?bookid=${item.bookid}"/>'>${item.title}</a></td>
					<td>${item.price}</td>
					<td>${item.cover_image}</td>
					<td><a
						href='<c:url value = "/admin-UpdateByBookID?bookid=${item.bookid}"/>'>cập nhật</a></td>
					<td><a
						href='<c:url value = "/admin-DeleteByBookID?bookid=${item.bookid}"/>'>xoá</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>