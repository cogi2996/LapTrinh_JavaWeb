<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	request.setCharacterEncoding("UTF-8");
	String name  = request.getParameter("username");
		out.print(name);
		session.setAttribute("user", name);
		
		session.setMaxInactiveInterval(5);
		
	%>
	<a href ="second.jsp">second jsp page</a>
	
</body>
</html>