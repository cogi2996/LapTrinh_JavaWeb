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

		<form action="<c:url value="/admin-addUser"></c:url>" method="post"
			enctype="multipart/form-data">

			<div class="form-group">
				<label for="inputUsername">Tên người dùng</label> <input type="text"
					class="form-control" id="inputUsername" name="Username"
					value="${user.getUsername()}" placeholder="Nhập tên người dùng">
			</div>
			<div class="form-group">
				<label for="inputPassword">Mật khẩu</label> <input type="password"
					class="form-control" id="inputPassword" name="Password"
					value="${user.getPassword()}" placeholder="Nhập mật khẩu">
			</div>
			<div class="form-group">
				<label for="inputPhone">Số điện thoại</label> <input type="text"
					class="form-control" id="inputPhone" name="Phone"
					value="${user.getPhone()}" placeholder="Nhập số điện thoại">
			</div>
			<div class="form-group">
				<label for="inputFullname">Họ và tên</label> <input type="text"
					class="form-control" id="inputFullname" name="Fullname"
					value="${user.getFullname()}" placeholder="Nhập họ và tên">
			</div>
			<div class="form-group">
				<label for="inputEmail">Email</label> <input type="text"
					class="form-control" id="inputEmail" name="Email"
					value="${user.getEmail()}" placeholder="Nhập địa chỉ email">
			</div>
			<div class="form-group">
				<label for="inputImage">Hình đại diện</label> <input type="file"
					class="form-control" name="imageLink" id="inputImage"
					value="${user.getImages()}" />
			</div>

			<button type="submit" class="btn btn-default">Thêm</button>
			<button type="reset" class="btn btn-primary">Hủy</button>
		</form>
		</tbody>
		</table>
	</div>
</body>
</html>