
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="1"
	style="width: 100%; min-height: 700px; overflow: hidden">
	<thead>
		<th>sort by avg(rating) - DESC</th>

	</thead>
	<tbody>
		<tr>
			
			<td class="col-10" style="overflow: hidden;"><c:forEach
					items="${books}" var="book">
					

					<a href="<c:url value="/book?id=${book.bookid}"/>">${book.title} - rating(${book.rating}*)</a> 
					<br />
					<br />
					<br />
				</c:forEach>
				 <br /></td>
		</tr>

	</tbody>
</table>
