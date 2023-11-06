<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container" style="border: 1px #000 solid">
		<div class="row">
			<div class="col-2">UserName: ${user.username}<br> FullName:
				${user.fullname}</div>
			<div class="col-10" style="border: 1px #000 solid">
				<div class="row" style="border-bottom: 1px #000 solid">
					<c:forEach var="item" items="${listVideo}">
						VideoID: ${item.videoId}
						<br>
						VideoDate:${item.likedDate}
					</c:forEach>

				</div>
			</div>
		</div>
	</div>

</body>
</html>