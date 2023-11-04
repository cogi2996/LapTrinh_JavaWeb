<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="1"
	style="width: 100%; min-height: 700px; overflow: hidden">
	<thead>
		<!-- <th>Author</th>
		<th>Books</th> -->

	</thead>
	<tbody>
		<tr>
			<td class="col-2">
				<h1>${user.username}</h1> <br>
				<h1>${user.fullname}</h1>
			</td>
			<td class="col-10" style="overflow: hidden;"><c:forEach
					items="${listFavor}" var="favor">
					
					<h1>${favor.videoId}</h1>
					<h1>${favor.likedDate}</h1> 
					<br />
				</c:forEach></td>
		</tr>

	</tbody>
</table>
	 
