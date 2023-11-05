<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container" style="border: 1px #000 solid">
	<div class="row">
		<div class="col-2">
			${user.username}
			${user.fullname}
		</div>
		<div class="col-10" style="border: 1px #000 solid">
			<c:forEach items="${listFavor}" var="favor">
				<div class="row" style="border-bottom: 1px #000 solid">
					video id: ${favor.videoId}
					<br>
					LikeDate: ${favor.likedDate}
				</div>
			</c:forEach>
		</div>
	</div>
</div>
