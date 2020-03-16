<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="/WEB-INF/resources/template/header.jsp" />
<div class="row justify-content-center d-flex flex-columns">

<!-- <script type="text/javascript">
  var url = window.location.href;
  var sessionInfo = url.substring(url.indexOf(';') + 1, url.length);
  if(sessionInfo.indexOf("ssionid") != -1){
  alert('session id var');
  username = sessionInfo.split('=')[0].toUpperCase();  
  id  = sessionInfo.split('=')[1];
  document.cookie = username + "=" + id;
}
</script>  -->

<c:if test="${fn:length(blogList) == 0}">
	<div class="alert alert-warning col-9 col-lg-6 mt-3">
		<strong>Üzgünüm :(</strong>
		<small>Malesef henüz konu ile ilgili yayınlanmış hiç blog yok!</small>
	</div>
	<br />
</c:if>

 <c:forEach items="${blogList}" var="blog">
	<div class="col-sm-11 wrapper-blog-list mt-4">
		<div class="card">
			<div class="card-header bg-danger">
				<span class="lead font-blog-title" style="font-weight: normal;">${blog.title}</span>
				<span class="float-right blogDate text-inverse"><small>${blog.formatedDate}</small></span>
			</div>
			<div class="card-block font-blog-body text-justify">
				<p class="card-text" >
					${blog.preview}
				</p>
			</div>	
			<div class="card-footer">
				<div class="wrapper-category-and-tag">
					<c:set var="blog" value="${blog}" scope="request" />
					<jsp:include page="../resources/component/TagCategoryComponent.jsp" />
					<a href="blog/${blog.id}"  class="button button-block button-caution button-tiny bg-danger cursorable float-right">Devamı için tıklayınız...</a>
				</div>
				
	        </div>
		</div>
	</div>
	
</c:forEach>
	
	<div class="wrapper-pagination mt-3 col-sm-12 justify-content-center d-flex">
		<div class="url" hidden="true">${paginationUrl}</div>
		<div class="totalBlog" hidden="true">${totalBlog}</div>
		<nav>
			<ul class="pagination" id="pagination"></ul>
		</nav>
	</div> 
</div>
<jsp:include page="/WEB-INF/resources/template/footer.jsp" />
<script type="text/javascript" src="resources/js/lib/pagination.js"></script>
<script type="text/javascript" src="resources/js/blogstore.js"></script>
