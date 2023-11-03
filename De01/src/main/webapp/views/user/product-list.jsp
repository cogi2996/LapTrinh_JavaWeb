
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
			<c:forEach items="${authors}" var="author">
					<a href="<c:url value="/author?id=${author.author_id}"/>">${author.author_name}</a>
					<br />
				</c:forEach></td>
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

					<a href="<c:url value="/book?id=${book.bookid}"/>">${book.title}</a>
					<br />
					<br />
					<br />
				</c:forEach>
				<div class="col-md-8 col-sm-8">
					<ul class="pagination pull-right">
						<c:if test="${tag>1}">
							<li><a
								href="${pageContext.request.contextPath}/book?index=${tag-1}">&laquo;</a></li>
						</c:if>
						<c:forEach begin="1" end="${endP}" var="i">
							<li class='${tag==i?"active":"" }'><a
								href="${pageContext.request.contextPath}/book?index=${i}">${i}</a></li>
						</c:forEach>
						<c:if test="${tag<endP}">
							<li><a
								href="${pageContext.request.contextPath}/book?index=${tag+1}">&raquo;</a></li>
						</c:if>
					</ul>
				</div> <br /></td>
		</tr>

	</tbody>
</table>
