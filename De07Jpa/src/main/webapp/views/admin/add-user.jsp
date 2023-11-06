<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
	<div class="container">
	
		<form action="<c:url value="/admin-addUser" />" method="post" enctype="multipart/form-data">
			
			<div class="form-group">
				<label for="inputUsername">Username</label> 
				<input type="text" class="form-control" id="inputUsername" name="username" placeholder="Enter username">
			</div>
			<div class="form-group">
				<label for="inputPassword">Password</label>
				<input type="password" class="form-control" id="inputPassword" name="password" placeholder="Enter password">
			</div>
			<div class="form-group">
				<label for="inputFullName">Full Name</label> 
				<input type="text" class="form-control" id="inputFullName" name="fullname" placeholder="Enter full name">
			</div>
			<div class="form-group">
				<label for="inputEmail">Email</label>
				<input type="email" class="form-control" id="inputEmail" name="email" placeholder="Enter email address">
			</div>
			<div class="form-group">
				<label for="inputPhone">Phone</label>
				<input type="text" class="form-control" id="inputPhone" name="phone" placeholder="Enter phone number">
			</div>
			<div class="form-group">
				<label for="inputAdmin">Admin</label>
				<select class="form-control" id="inputAdmin" name="admin">
					<option value="0">No</option>
					<option value="1">Yes</option>
				</select>
			</div>
			<div class="form-group">
				<label for="inputActive">Active</label>
				<select class="form-control" id="inputActive" name="active">
					<option value="0">No</option>
					<option value="1">Yes</option>
				</select>
			</div>
			<div class="form-group">
				<label for="inputImage">Profile Image</label> 
				<input type="file" class="form-control" name="image" id="inputImage" />
			</div>

			<button type="submit" class="btn btn-default">Add</button>
			<button type="reset" class="btn btn-primary">Cancel</button>
		</form>
		</tbody>
		</table>
	</div>
</body>
</html>
