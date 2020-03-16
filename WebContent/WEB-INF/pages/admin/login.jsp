<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>admin:LoginPage</title>
</head>
<body>
<jsp:include page="/WEB-INF/resources/template/header.jsp" />
<h5 align="center" class="mt-5">Login-Form</h5>
<div class="row justify-content-center">
	<form action="login/process" method="post" class="mt-3">
		<div class="form-group row">
			<label class="col-xs-3">Username : </label>
			<div class="col-xs-9">
				<input id="username" type="text" name="username" class="form-control" required />
			</div>
		</div>
		<div class="form-group row mt-2">
			<label class="col-xs-3">Password : </label>
			<div class="col-xs-9">
				<input id="password" type="password" name="password" class="form-control" required />
				<input type="submit" value="login!" class="btn btn-outline-secondary float-right mt-1" />
			</div>
		</div>
	</form>
</div>

<jsp:include page="/WEB-INF/resources/template/footer.jsp" />
</body>
</html>