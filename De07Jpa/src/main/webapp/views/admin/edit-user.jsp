<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
</head>
<body>
	<div class="container">
		<form action="<c:url value="/admin-UpdateUser" />" method="post"
			enctype="multipart/form-data">

			<input name="username" value="${user.username}" hidden="">
			<div class="form-group">
				<label for="inputFullName">Full Name</label> <input type="text"
					class="form-control" id="inputFullName" name="fullname"
					value="${user.fullname}" placeholder="Enter full name">
			</div>
			<div class="form-group">
				<label for="inputEmail">Email</label> <input type="email"
					class="form-control" id="inputEmail" name="email"
					value="${user.email}" placeholder="Enter email address">
			</div>
			<div class="form-group">
				<label for="inputPhone">Phone</label> <input type="text"
					class="form-control" id="inputPhone" name="phone"
					value="${user.phone}" placeholder="Enter phone number">
			</div>
			<div class="form-group">
				<label for="inputPassword">Password</label> <input type="password"
					class="form-control" id="inputPassword" name="password"
					placeholder="Enter new password">
			</div>
			<div class="form-group">
				<label for="inputAdmin">Admin</label> <select class="form-control"
					id="inputAdmin" name="admin">
					<option value="1" ${user.admin ? 'selected' : ''}>Yes</option>
					<option value="0" ${!user.admin ? 'selected' : ''}>No</option>
				</select>
			</div>
			<div class="form-group">
				<label for="inputActive">Active</label> <select class="form-control"
					id="inputActive" name="active">
					<option value="1" ${user.active ? 'selected' : ''}>Yes</option>
					<option value="0" ${!user.active ? 'selected' : ''}>No</option>
				</select>
			</div>
			<div class="form-group">
				<label for="inputImage">Profile Image</label> <input type="file"
					class="form-control" id="inputImage" name="image"> <img
					src="<c:url value='${user.images}'/>" alt="User Image" height="100"
					width="100" />
			</div>

			<button type="submit" class="btn btn-default">Update</button>
			<button type="reset" class="btn btn-primary">Cancel</button>
		</form>
		</tbody>
		</table>
	</div>
</body>
</html>
