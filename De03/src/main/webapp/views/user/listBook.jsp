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
	<div class="container" style="border: 1px #000 solid">
		<c:forEach var="item" items="${listBook}">
			<div class="row">
				<div class="col-2">item.cover_image</div>
				<div class="col-10" style="border: 1px #000 solid">
					<div class="row" style="border-bottom: 1px #000 solid">

						Tiêu đề: <a
							href='<c:url value="/book?bookid=${item.bookid}"></c:url>'>${item.title}</a><br>
						Mã isbn: ${item.title} <br> Tác giả: ${item.author} <br>
						Publisher: ${item.publisher} <br>
						Publisher_date:${item.publish_date} <br>
						Quantity:${item.quantity} <br> Review (${item.review}) <br>
					</div>
				</div>
			</div>

		</c:forEach>


	</div>

</body>
</html>