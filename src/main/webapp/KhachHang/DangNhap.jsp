<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="base.css">
</head>
<style>
body {
	margin: 0;
	padding: 0;
	background-color: #f5f5f5;
	height: 100vh;
}

button, input, [tabindex] {
	outline: none;
	border: none;
}

.small {
	min-width: 100px;
	padding: 8px 20px;
}

a.text-info:focus, a.text-info:hover {
	color: #117a8b !important;
	text-decoration: none;
}

.large {
	padding: 14px 16px;
	min-width: 140px;
}

.form-control:focus {
	box-shadow: none;
	border-color: #cf111a;
}

#login .container #login-row #login-column #login-box {
	margin-top: 120px;
	max-width: 600px;
	border-radius: 20px;
	background-color: #fff;
	border: 1px solid rgba(0, 0, 0, .125);
}

#login .container #login-row #login-column #login-box #login-form {
	padding: 20px;
}

#login .container #login-row #login-column #login-box #login-form #register-link
	{
	margin-top: -85px;
}
</style>
<body>
	<div id="login">
		<div class="container">
			<div id="login-row"
				class="row justify-content-center align-items-center">
				<div id="login-column" class="col-md-6">
					<div id="login-box" class="col-md-12">
						
						<form id="login-form" class="form"
							action="DangNhapController" method="post">


							<h3 class="text-center text-info"
								style="color: #cf111a !important">Login</h3>
							<div class="form-group">
								<input type="text" placeholder="Username" name="un"
									id="username" class="form-control"
									value="${sessionScope.taikhoan }">
							</div>
							<div class="form-group">
								<input type="text" placeholder="password" name="pass"
									id="password" class="form-control">
							</div>
							<c:if test="${countLogin >= 2}">

								<div class="form-row">
									<img class="col-md-6" src="simpleCaptcha.jpg" /> <input type="text"
										placeholder="Capcha" name="answer" id="username"
										class="form-control col-md-6">
								</div>
							</c:if>
							<%
							if (request.getParameter("kt") != null) {
							  out.print("Đăng Nhập Sai");
							}
							%>

							<div class="form-group d-flex justify-content-center">

								<input type="submit" name="but1"
									class="small btn btn-outline-danger btn-md mr-4" value="Login">
								<input type="submit" name="" formaction="MonAnController"
									formmethod="post" class=" small btn btn-primary btn-md"
									value="Back">
							</div>
							<div class="form-group">
								<div id="register-link" class="text-right"
									style="margin-top: 3px;">
									<a href="DangKyController" class="text-info">Register here</a>
								</div>
							</div>



							<%-- <c:out value="${sessionScope.countLogin}"></c:out> --%>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>