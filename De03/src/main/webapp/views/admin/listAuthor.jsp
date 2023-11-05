<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<a href='<c:url value="/admin-addAuthor"></c:url>'>Add New Author</a>
<table border="1" style="width: 100%;">
    <thead>
        <th>Author ID</th>
        <th>Author Name</th>
        <th>Date of Birth</th>
    </thead>
    <tbody>
        <c:forEach var="author" items="${listAuthor}">
            <tr>
                <td>${author.author_id}</td>
                <td>${author.author_name}</td>
                <td>${author.date_of_birth}</td>
                <td><a
                    href='<c:url value="/admin-updateAuthor?author_id=${author.author_id}"></c:url>'>Edit</a></td>
                <td><a
                    href='<c:url value="/admin-deleteAuthor?author_id=${author.author_id}"></c:url>'>Delete</a></td>
            	
            </tr>
        </c:forEach>
    </tbody>
    <div class="col-md-8 col-sm-8">
        <ul class="pagination pull-right">
            <c:if test="${tag > 1}">
                <li><a
                    href="${pageContext.request.contextPath}/admin-listAuthor?index=${tag-1}">&laquo;</a></li>
            </c:if>
            <c:forEach begin="1" end="${endP}" var="i">
                <li class='${tag == i ? "active" : "" }'><a
                    href="${pageContext.request.contextPath}/admin-listAuthor?index=${i}">${i}</a></li>
            </c:forEach>
            <c:if test="${tag < endP}">
                <li><a
                    href="${pageContext.request.contextPath}/admin-listAuthor?index=${tag+1}">&raquo;</a></li>
            </c:if>
        </ul>
    </div>
</table>

