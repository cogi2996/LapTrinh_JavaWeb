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
	<c:if test="${not empty message}">${message}</c:if>
	<c:if test="${not empty error}">${error}</c:if>
	<a href= "<c:url value ="/admin-insertpro"/>">add product</a>
<br>
	<c:forEach var="item" items="${listPro}">
		<span> <a href="<c:url value='update?id=${item.getProID()}'/>">${item.getProID()}</a>
			- ${item.getProName()} - ${item.getProPrice()}
		</span>
		<br>
	</c:forEach>

</body>
</html>