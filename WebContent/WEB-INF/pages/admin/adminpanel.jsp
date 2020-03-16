<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="h" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<jsp:include page="/WEB-INF/resources/template/header.jsp" />
<link rel="stylesheet" href="resources/css/newblog.css" />
<script src="https://cdn.ckeditor.com/4.8.0/full-all/ckeditor.js"></script>
<div id="blog-information" hidden>
	<span id="hasBlog"><c:out value="${blog.title != null}"/></span>
	<c:if test="${blog.title != null}">
		<c:forEach items="${blog.categoryList}" var="category"> <span class="blog-category">${category.name}</span></c:forEach>
		<span id="blog-content">${blog.content}</span>
		<c:forEach items="${blog.tagList}" var="tag"> <span class="blog-tag">${tag.name}</span></c:forEach>
	</c:if>
</div>

	<h4 class="h5 mt-2" align="center">Admin Paneli</h4>
	
	<div class="d-flex justify-content-center">
	
		<h:form id="new-blog-form" action="admin/panel/blog/add" method="post" modelAttribute="blog" cssClass="mt-2 col-11 col-md-9">
			<div class="form-group">
				<label for="title">Title</label>
				<h:input id="title" path="title" cssClass="form-control title" placeHolder="Title"/>
			</div>
			<div class="form-group" >
				<label for="category">Category List</label>
				<div class="d-flex flex-row">
					<h:select path="categoryList" multiple="true" id="category" cssClass="form-control col-8">
						<c:forEach items="${categoryList}" var="category">
							<h:option value="${category.id}" label="${category.name}: ${category.order}" category-order="${category.order}" category-id="${category.id}" category-name="${fn:replace(category.name, ' ', '')}" cssClass="categoryList"></h:option>
						</c:forEach>
					</h:select>
					<div class="flex-column d-flex col-4">
						<a id="new-category" href="#" type="button" class="button  button-rounded button-3d button-small my-2 float-right"  data-toggle="modal" data-target="#new-category-fw" >Ekle/Güncelle</a>
						<a id="delete-category" href="admin/category/delete" type="button" class="button  button-rounded button-3d button-small my-2 float-right" data-toggle="modal" data-target="#delete-category-fw" >Sil</a>
					</div>
				</div>
			</div> 
			
			
			
		   <div class="form-group">
				<label for="preview">Preview</label>
				<h:textarea path="preview" cssClass="form-control preview" rows="4" placeHolder="preview"/>
			</div>  
			
			<div class="form-group">
			    <label for="content">Content</label>
			    <textarea id="content" name="content"></textarea>
				<script>            
		            CKEDITOR.replace( 'content', {
		                extraPlugins: 'codesnippet'
		            } );
				</script>
			</div> 
			
			<div class="form-group">
				<label for="tags" class="col-xs-2" data-toggle="tooltip" data-placement="bottom" title="Split(',')"> <abbr title="">Tags</abbr></label>
				<input id="tags" type="text" name="tags" class="form-control tags" />
			</div>
			
			<label class="custom-control custom-checkbox">
			  <h:checkbox path="published" cssClass="custom-control-input"/>
			  <span class="custom-control-indicator"></span>
			  <span class="custom-control-description">Blog yayınlanmaya hazır mı ?</span>
			</label>
			
			<div class="btn-wrapper col-xs-10 push-xs-2">
				<input type="submit" class="btn btn-outline-danger btn-block mb-2" value="Blog Ekle" />
			</div>
			
		</h:form>
	</div>
		<div class="result-wrapper">
			<c:if test="${operationResult.display}">
				<div class="alert ${operationResult.alert} col-xs-10 push-xs-2">
					<strong>${operationResult.summary}</strong> ${operationResult.detail}
				</div>
			</c:if>
		</div>
	<div class="modal fade" id="new-category-fw" tabindex="-1" role="dialog" aria-labeledBy="myFormLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title"> New Category Form </h4>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				 		<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<h:form action="admin/category/add" method="POST" modelAttribute="category">
						<div class="form-group">
							<label for="id">ID</label>	
							<h:input path="id" type="number" cssClass="form-control" placeHolder="ID" readonly="true" required="required"/>
						</div>
						<div class="form-group">
							<label for="name">Name</label>	
							<h:input path="name" cssClass="form-control" placeHolder="name" required="required"/>
						</div>
						<div class="form-group">
							<label for="order">Order</label>	
							<h:input path="order" cssClass="form-control" placeHolder="Order"  required="required"/>
						</div>
						<input type="submit" class="button  button-rounded button-3d float-right" value="Ekle">
					</h:form>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="/WEB-INF/resources/template/footer.jsp" />
<script type="text/javascript" src="resources/js/lib/jquery-validate.js"></script>
<script type="text/javascript" src="resources/js/adminpanel.js" ></script>
</body>
</html>