<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<title>${blog.title} | Javalog</title>
<meta name="description" content="${blog.title} | Javalog"/>
<meta name="title" content="${blog.title} | Javalog"/>
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
<jsp:include page="/WEB-INF/resources/template/header.jsp" />
<div class="wrapper-blog mt-2 p-4 flex-column d-flex">
		<c:if test="${not empty admin }">
			<div id="blog-settings" style="position: absolute; right: 20px;">
				<a href="admin/panel/?blogId=${blog.id}" class="button button-rounded button-tiny" >Düzenle</a>
				<a href="admin/panel/blog/delete/?blogId=${blog.id}" class="button button-rounded button-caution button-tiny" >Sil</a>
			</div>
		</c:if>
		<div class="title my-3 font-blog-title">${blog.title}</div>
		<small class="date ml-2">
			<i class="fa fa-calendar-o text-danger" aria-hidden="true"></i>
			<code>${blog.getFormatedDate()}</code>
		</small>
		<div class="wrapper-category-and-tag-top mt-1 ml-2">
			<div class="wrapper-author float-md-left mr-3">
				<i class="fa fa-user text-danger" aria-hidden="true"></i>
				<a href="about/omer-byrk">${blog.author}</a>
			</div>
			<jsp:include page="../resources/component/TagCategoryComponent.jsp" />
		</div>
		<div class="content text-justify mt-3 font-blog-body">
			${blog.content}
		</div> 
		<hr style="width: 100%; color: black; height: 1px;" />
		<div class="display">
			<c:if test="${not empty admin }">
				Görüntülenme : ${blog.display} <br/>
			</c:if>
		</div>
		<div class="wrapper-category-and-tag-bottom"></div>
		<br/>
		<hr style="clear: both;"/>
		<div class="wrapper-comment-field mt-2">
			<div class="wrapper-comment-form col-12 col-md-7">
				<h5>Yorum Formu <i class="fa fa-commenting-o" aria-hidden="true"></i></h5>
				<form id="comment-form" action="comment/save" method="post" class="mt-3">
					<input type="hidden" name="blogId" value="${blog.id}">
					<div class="form-group">
						<label for="name">Name</label>
						<input id="name" type="text" name="name" class="form-control" />
					</div>
					<div class="form-group">
						<label for="email">Email</label>
						<input id="email" type="text" name="email"  class="form-control" />
					</div>
					<div class="form-group">
						<label for="opinion">Comment</label>
						<textarea id="opinion" name="opinion" class="form-control"  rows="5"></textarea>
					</div>
					<c:if test="${not empty admin }">
						<div class="form-group form-check">
							<label class="form-check-label">
								<input type="checkbox" name="admin" class="form-check-input" />
								Do you answer to the comment as admin ?
							</label>
						</div>
					</c:if>
					<div class="from-group">
						<div>
							<div class="g-recaptcha" data-sitekey="6Ld6Zg8UAAAAADV50ZqLXtszT3wfn63qCWcG75_a" ></div>
							<input id="comment-form-submit" type="submit" class="button button-caution button-3d float-right mt-1 button-small" value="Gönder" />
						</div>
					</div>
					<input type="reset" value="" class="comment-form-reset" style="display: none;" />
				</form>
			</div>
			
			<h5 style=" clear: both;">${fn:length(blog.commentList)} Comments</h5>
			<hr />
			
			<div class="wrapper-comment-list mt-2 flex-row flex-columns col-12" style=" clear: both;">
				<c:forEach items="${blog.commentList}" var="comment">
					<div class="media mt-4 ${comment.id}" id="0${comment.id}">
						<a href="#" class="media-left">
							<img class="media-object" src="resources/img/${comment.photoName}" height="64">
						</a>
						<div class="media-body ml-2">
							<h6 class="name"><span class="name">${comment.name}</span> <sup><i><small>${comment.tag}</small></i></sup></h6>
							<small class="wrapper-date ml-2" style="font: 12px consolas;">
								<span class="mark" style="color: red">@</span>
								<span class="date">${comment.formatedDate}</span>
							</small>
							<br/> 
							<span class="ml-2">${comment.opinion}</span>
							<br/>
							<div class="media-right mt-2">
								<button id="answer-button" type="button" receipt-name="${comment.name}" class="button button-border-caution button-tiny answer float-left" commentId="0${comment.id}">Cevapla</button>
								<c:if test="${not empty admin}">
									<button id="answer-delete-button" type="button" class="button button-border-caution button-tiny delete float-left ml-1" url="comment/delete" method="post" answerId="0${blog.id}" commentId="0${comment.id}">Sil</button>
								</c:if>
							</div>
							<br/>
							<hr />
							<c:forEach items="${comment.answerList}" var="answerObj">
								<div class="media mt-2" commentId="${comment.id}">
									<a href="#" class="media-left">
										<img class="media-object" src="resources/img/${answerObj.photoName}" height="64">
									</a>
									<div class="media-body ml-2">
										<h6 class="name"> <span class="name">${answerObj.name}</span> <sup><i><small>${answerObj.tag}</small></i></sup></h6>
										<span class="wrapper-date ml-2" style="font: 12px consolas;">
											<span class="mark" style="color: red">@</span>
											<span class="date text-muted"><small>${answerObj.formatedDate}</small></span>
										</span>
										<br/> 
										<span class="ml-2 bg-faded">${answerObj.answer}</span>
										<br/>
										<div class="media-right mt-2">
										<button id="answer-button" type="button" receipt-name="${answerObj.name}" class="button button-border-caution button-tiny answer float-left" commentId="0${comment.id}">Cevapla</button>
										<c:if test="${not empty admin}">
											<button id="answer-delete-button" type="button" class="button button-border-caution button-tiny delete float-left ml-1" url="answer/delete" method="post" answerId="0${answerObj.id}" commentId="0${comment.id}">Sil</button>
										</c:if>
										<br/>
									</div>
									</div>
								</div>
								<hr />
							</c:forEach>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
		<a href="blog/${blog.id}#answer-scroll" class="ScrollToAnswerForm" hidden="true">click</a>
		<!-- Kullanıcı yoruma cevap vereceği zaman , bu formu kopyalıyıp , yorumun altına alıyoruz  -->
		<div id="answer-scroll" class="jumbotron wrapper-hidden-answer-form col-12 mt-1" style="display: none">
			<h3 class="lead">Cevap Formu</h3>
			<button id="close-answer-form" style="position: absolute; right: 10; top: 10;" title="formu kapatın" class="button button-tiny p-1"><i class="fa fa-window-close" aria-hidden="true"></i></button>
			<form id="answer-form" action="answer/save" method="post">
				<input type="hidden" name="commentId" value="" class="comment-id" />
				<div class="form-group">
					<label for="name">Name</label>
					<input id="name" type="text" name="name" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="answer">Answer</label>
					<textarea id="answer" name="answer" class="form-control response-area"></textarea>
				</div>
				<c:if test="${not empty admin }">
					<div class="form-group form-check">
						<label class="form-check-label">
							<input type="checkbox" name="admin" class="form-check-input" />
							Do you answer to the comment as admin ?
						</label>
					</div>
				</c:if>
				<input type="submit" value="Post-Answer" class="button button-border-caution float-right mt-1 submit-response-form" />
				<input type="reset" class="answer-form-reset" style="display: none;" />
			</form>
		</div>
</div>
<jsp:include page="/WEB-INF/resources/template/footer.jsp" />
<script type="text/javascript" src="resources/js/lib/jquery-validate.js"></script>
<script type="text/javascript" src="resources/js/blog.js"></script>