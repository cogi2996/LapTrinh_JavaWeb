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
		 <form action="<c:url value="/admin-updateAuthor"></c:url>" method="post" enctype="multipart/form-data">

            <input name="author_id" value="${author.author_id}" hidden="">
            <div class="form-group">
                <label for="inputAuthorName">Tên tác giả</label>
                <input type="text" class="form-control" id="inputAuthorName" name="author_name" value="${author.author_name}" placeholder="Nhập tên tác giả">
            </div>
            <div class="form-group">
                <label for="inputDateOfBirth">Ngày sinh</label>
                <input type="date" class="form-control" id="inputDateOfBirth" name="date_of_birth" value="${author.date_of_birth}" placeholder="Nhập ngày sinh">
            </div>

            <button type="submit" class="btn btn-default">Sửa</button>
            <button type="reset" class="btn btn-primary">Hủy</button>
        </form>


		</tbody>
		</table>
	</div>
</body>
</html>