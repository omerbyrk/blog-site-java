<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
	<div class="blog-categories float-md-left">
		<i class="fa fa-folder-open text-danger" aria-hidden="true"></i>
		<c:forEach items="${blog.categoryList}" var="category">
			<a href="${pageContext.request.contextPath}/category/${category.name}">${category.name}</a><i class="comma">,</i>
		</c:forEach>
	</div>
	<div class="blog-tags float-md-left ml-md-3">
		<i class="fa fa-tag text-danger" aria-hidden="true"></i>
		<c:forEach items="${blog.tagList}" var="tag">
			<a href="${pageContext.request.contextPath}/tag/${tag.name}">${tag.name}</a><i class="comma">,</i>
		</c:forEach>
	</div>
	
	<script type="text/javascript">
		$(".blog-categories, .blog-tags").each(function() {
			$(this).find(".comma:last-child").remove(0);
		});
	</script>
</div>