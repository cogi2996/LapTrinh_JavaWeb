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
	<div class="container">
	
		<form action="<c:url value="/admin-addBook"></c:url>"
			method="post" enctype="multipart/form-data">
			
			<div class="form-group">
				<label for="inputTitle">Tựa sách</label> 
				<input type="text"
					class="form-control" id="inputTitle" name="title"
					value="${book.title}" placeholder="Nhập tựa sách ">
			</div>
			<div class="form-group">
				<label for="inputDescription">Mô tả sách </label> <input type="text"
					class="form-control" id="inputDescription" name="description"
					value="${book.description}" placeholder="Nhập mô tả sách ">
			</div>
			<div class="form-group">
				<label for="inputIsbn">Mã số định danh</label> <input type="number"
					class="form-control" id="inputIsbn" value="${book.isbn}"
					name="isbn" placeholder="Nhập mã số định danh ">
			</div>
			<div class="form-group">
				<label for="inputPublisher">Nhà sản xuất </label> <input type="text"
					class="form-control" id="inputPublisher" value="${book.publisher}"
					name="publisher" placeholder="Nhập nhà sản xuất sách ">
			</div>
			<div class="form-group">
				<label for="inputPrice">Giá </label> <input type="number"
					class="form-control" id="inputPrice" value="${book.price}"
					name="price" placeholder="Nhập giá sách ">
			</div>
			<div class="form-group">
				<label for="inputQuantity">Số lượng </label> <input type="number"
					class="form-control" id="inputQuantity" value="${book.quantity}"
					name="quantity" placeholder="Nhập số lượng sách ">
			</div>
			<div class="form-group">
				<label for="inputDatePublish">Ngày xuất bản </label> <input
					type="date" class="form-control" id="inputDatePublish"
					value="${book.publish_date}" name="publish_date"
					placeholder="Nhập ngày xuất bản sách ">
			</div>
			<div class="form-group">
				<label for="inputImage">Hình minh hoạt</label> <input type="file"
					class="form-control" name="image" id="inputImage"
					value="${book.cover_image}" />
			</div>

			<button type="submit" class="btn btn-default">Thêm</button>
			<button type="reset" class="btn btn-primary">Hủy</button>
		</form>
		</tbody>
		</table>
	</div>
</body>
</html>