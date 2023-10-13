<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
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
					<td><a href='<c:url value = "/findprobycate?cateid=${item.cateID}"/>'>${item.cateName}</a></td>
					<td>${item.images}</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>