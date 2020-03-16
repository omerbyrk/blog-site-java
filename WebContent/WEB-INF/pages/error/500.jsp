<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:include page="../../resources/template/header.jsp"></jsp:include>

<div align="center">
	500 Hatası: Server içi bir hata oluştu<br />
	Hata Nedeni: ${errorMessage}  <br/>
	Url: ${errorUrl} <br/>
</div>

<jsp:include page="../../resources/template/footer.jsp"></jsp:include>