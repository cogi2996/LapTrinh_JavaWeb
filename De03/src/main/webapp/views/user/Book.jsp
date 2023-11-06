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

		<div class="row" style="border: 1px #000 solid">
			<div class="col-2">item.cover_image</div>
			<div class="col-10" style="border: 1px #000 solid">
				<div class="row" style="border-bottom: 1px #000 solid">

					Tiêu đề: <a
						href='<c:url value="/book?bookid=${book.bookid}"></c:url>'>${book.title}</a><br>
					Mã isbn: ${book.isbn} <br> Tác giả: ${book.author} <br>
					Publisher: ${book.publisher} <br>
					Publisher_date:${book.publish_date} <br>
					Quantity:${book.quantity} <br> Review (${book.review}) <br>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-2" style="border: 1px #000 solid">review</div>

			<div class="col-10" style="border: 1px #000 solid"></div>
		</div>

		<c:forEach var="item" items="${listUser}">
			<div class="row">
				<div class="col-2" style="border: 1px #000 solid">review:${item.fullname}

				</div>

				<div class="col-10" style="border: 1px #000 solid">${item.review_text}</div>
			</div>
		</c:forEach>
		<form action="<c:url value="/admin-addBook"></c:url>">

			<div class="form-group">
				<label for="inputTitle">email: </label> <input type="text"
					class="form-control" id="inputTitle" name="title"
					 placeholder="Nhập email">
			</div>
			<div class="form-group">
				<label for="inputTitle">review: </label> <input type="text"
					class="form-control" id="inputTitle" name="title"
					 placeholder="Nhập bình luận">
			</div>
			<button type="submit" class="btn btn-default">đăng</button>
			<button type="reset" class="btn btn-primary">Hủy</button>
		</form>


	</div>
</body>
</html>