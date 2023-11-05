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
		<form action="<c:url value="/admin-updateUser"></c:url>" method="post" enctype="multipart/form-data">
		
			<input name="id" value="${user.id}" hidden="">
			<div class="form-group">
				<label for="inputEmail">Email</label> <input type="email"
					class="form-control" id="inputEmail" name="email"
					value="${user.email}" placeholder="Nhập email ">
			</div>
			<div class="form-group">
				<label for="inputFullname">Họ và tên</label> <input type="text"
					class="form-control" id="inputFullname" name="fullname"
					value="${user.fullname}" placeholder="Nhập họ và tên ">
			</div>
			<div class="form-group">
				<label for="inputPhone">Số điện thoại</label> <input type="number"
					class="form-control" id="inputPhone" value="${user.phone}"
					name="phone" placeholder="Nhập số điện thoại ">
			</div>
			<div class="form-group">
				<label for="inputPasswd">Mật khẩu</label> <input type="password"
					class="form-control" id="inputPasswd" value="${user.passwd}"
					name="passwd" placeholder="Nhập mật khẩu ">
			</div>
			<div class="form-group">
				<label for="inputSignupDate">Ngày đăng ký</label> <input
					type="date" class="form-control" id="inputSignupDate"
					value="${user.signup_date}" name="signup_date"
					placeholder="Nhập ngày đăng ký ">
			</div>
			<div class="form-group">
				<label for="inputLastLogin">Lần đăng nhập gần nhất</label> <input
					type="date" class="form-control" id="inputLastLogin"
					value="${user.last_login}" name="last_login"
					placeholder="Nhập ngày đăng nhập gần nhất ">
			</div>
			<div class="form-group">
				<label for="inputIsAdmin">Là admin</label> <input type="checkbox"
					class="form-control" id="inputIsAdmin" name="is_admin"
					value="${user.is_admin}" placeholder="Chọn nếu là admin ">
			</div>

			<button type="submit" class="btn btn-default">Sửa</button>
			<button type="reset" class="btn btn-primary">Hủy</button>
		</form>


		</tbody>
		</table>
	</div>
</body>
</html>