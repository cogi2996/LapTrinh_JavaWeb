<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Author</title>
</head>
<body>
	<div class="container">

		<form action="<c:url value="/admin-addAuthor"></c:url>" method="post">

			<div class="form-group">
				<label for="inputAuthorName">Tên tác giả</label> <input type="text"
					class="form-control" id="inputAuthorName" name="author_name"
					value="${author.author_name}" placeholder="Nhập tên tác giả">
			</div>

			<div class="form-group">
				<label for="inputDateOfBirth">Ngày sinh</label> <input type="date"
					class="form-control" id="inputDateOfBirth" name="date_of_birth"
					value="${author.date_of_birth}"
					placeholder="Nhập ngày sinh của tác giả">
			</div>

			<button type="submit" class="btn btn-default">Thêm</button>
			<button type="reset" class="btn btn-primary">Hủy</button>
		</form>
		</tbody>
		</table>
	</div>
</body>
</html>
