
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="1"
	style="width: 100%; min-height: 700px; overflow: hidden">
	<thead>
		<th>Author</th>
		<th>Books</th>

	</thead>
	<tbody>
		<tr>
			<td class="col-2">
			<c:forEach items="${listAuthor}" var="author">
					<a href="<c:url value="/authorBook?id=${author.author_id}"/>">${author.author_id}-${author.author_name}</a>
					<br />
				</c:forEach></td>
				
			<td class="col-10" style="overflow: hidden;"><c:forEach
					items="${listBook}" var="book" varStatus="loopStatus">
					Bookid${loopStatus.index+1}: ${book.bookid}
					<br />
				</c:forEach>
				</td>
		</tr>

	</tbody>
</table>
