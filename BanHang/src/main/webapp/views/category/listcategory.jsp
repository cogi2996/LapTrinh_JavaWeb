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
	<c:forEach var="item" items="${listcate}">
          <span><a href="findOne?id=${item.cateID}">${item.cateID}</a> - ${item.cateName}  - ${item.images}</span>
        <br>
        
    </c:forEach>
</body>
</html>
