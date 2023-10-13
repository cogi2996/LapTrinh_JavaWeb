<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="home.css" />
</head>
<body>
	Current user: ${sessionScope.username}
	<button class="action-button btn-createPost">Create post</button>
	<div class="post-create-container hidden">
		<div class="post-title">
			<label for="title">Title:</label> <input type="text" id="title"
				name="title" />
		</div>
		<div class="post-content-create">
			<label for="content">Content:</label>
			<textarea id="content" name="content" rows="10" cols="50"></textarea>
		</div>
		<button class="action-button">Đăng</button>
	</div>
	<script type="module" src="home.js"></script>
</body>
</html>