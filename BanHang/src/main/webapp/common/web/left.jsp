<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1" style="width: 100%">
		<thead>
			<th>ID</th>
			<th>Name</th>
			<th>Icon</th>
		
		</thead>
		<tbody>
			<c:forEach var="item" items="${listcate}">
				<tr>
					<td>${item.cateID}</td>
					<td>${item.cateName}</td>
					<td>${item.images}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>