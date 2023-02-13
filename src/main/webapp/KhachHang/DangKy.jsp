<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


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
						<form id="login-form" class="form" method="post"
							action="DangKyController">
							<h3 class="text-center text-info"
								style="color: #cf111a !important">Register</h3>
							<div class="form-group">
								<input type="text" value="${UserName }" name=username
									placeholder="User Name" id="username" class="form-control ">
							<span style="color: #cf111a">${tb }</span>
							</div>
							
							<div class="form-group">
								<input type="text" value="${FullName }" name="fullname"
									placeholder="Full name" id="fullname" class="form-control">
							</div>
							<div class="form-group">
								<input type="text" value="${address }" name="address"
									id="address" placeholder="Address" class="form-control">
							</div>
							<div class="form-group">
								<input type="text" value="${phonenumber }" name="phonenumber"
									id="phonenumber" placeholder="Phone Number"
									class="form-control">
							</div>
							<div class="form-group">
								<input type="text" value="${Email }" name="email" id="email"
									placeholder="Email" class="form-control">
							</div>
							<div class="form-group">
								<input type="password" name="password" id="password"
									placeholder="Password" class="form-control">
							</div>
							<div class="form-group">
								<input type="password" name="confirm" id="confirm"
									placeholder="Confirm password" class="form-control"> <span style="color: #cf111a">${mk }</span>
							</div>

							<div class="form-group d-flex justify-content-center">

								<input type="submit" name="submit"
									class="small btn btn-outline-danger btn-md mr-4"
									value="Register"> <input type="submit" name=""
									formaction="SachController" formmethod="post"
									class=" small btn btn-primary btn-md" value="Back">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>