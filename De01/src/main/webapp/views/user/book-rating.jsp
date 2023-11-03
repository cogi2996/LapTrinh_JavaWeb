
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
					<c:choose>
						<c:when test="${book.cover_image==null}">
							<img
								src="<c:url value="https://scontent.fsgn2-6.fna.fbcdn.net/v/t39.30808-6/398262159_18209391406260640_7597857554949070393_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFwTk5fuC8l4qDapPa7T4YJJoyixhSmMrMmjKLGFKYys9lKMPVGdjMhVeOpefwFl-peKoFAhhdhLLjJk1SZR1Ek&_nc_ohc=NLbhWwnaXNEAX-cHF9J&_nc_ht=scontent.fsgn2-6.fna&oh=00_AfCWFfHtsvd8B4nFPEdl2kqxcRavc0u6W7OU2iDDa0lZdg&oe=6547EE35"/>"
								class="img-responsive" alt="${book.title }">
							<br />
						</c:when>
						<c:otherwise>
							<img
								src="<c:url value="/image?fname=products/${book.cover_image}"/>"
								class="img-responsive" alt="${book.title}" width="150px"
								height="150px">
							<br />
						</c:otherwise>
					</c:choose>

					<a href="<c:url value="/book?id=${book.bookid}"/>">${book.title} - rating(${book.rating}*)</a> 
					<br />
					<br />
					<br />
				</c:forEach>
				 <br /></td>
		</tr>

	</tbody>
</table>
