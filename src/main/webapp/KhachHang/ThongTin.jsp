<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap 5 Example</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

<link rel="stylesheet" type="text/css" href="Css/ThongTin.css">
<link rel="stylesheet" type="text/css" href="Css/base.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<!-- Navbar-->
	<div class="superNav border-bottom py-2 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12 centerOnMobile">
					<select class="me-3 border-0 bg-light">
						<option value="en-us">EN-US</option>
					</select> <span
						class="d-none d-lg-inline-block d-md-inline-block d-sm-inline-block d-xs-none me-3"><strong>info@somedomain.com</strong></span>
					<span class="me-3"><i
						class="fa-solid fa-phone me-1 text-warning"></i> <strong>1-800-123-1234</strong></span>
				</div>
				<div
					class="col-lg-6 col-md-6 col-sm-12 col-xs-12 d-none d-lg-block d-md-block-d-sm-block d-xs-none text-end">
					<span class="me-3"><i
						class="fa-solid fa-truck text-muted me-1"></i><a
						class="text-muted" href="#">Shipping</a></span> <span class="me-3"><i
						class="fa-solid fa-file text-muted me-2"></i><a class="text-muted"
						href="#">Policy</a></span>
				</div>
			</div>
		</div>
	</div>
	<nav
		class="navbar navbar-expand-lg bg-white sticky-top navbar-light p-3 shadow-sm">
		<div class="container">
			<a class="navbar-brand" href="#"><i class="fa-solid fa-shop me-2"></i>
				<strong>CHICKEN SHOP</strong></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
				aria-controls="navbarNavDropdown" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="mx-auto my-3 d-lg-none d-sm-block d-xs-block">
				<div class="input-group">
					<form class="" action="MonAnController" method="get">
						<input type="text" name="txttk" class="form-control "
							style="color: red" />
						<button type="submit" class="btn text-white">Search</button>
					</form>

				</div>
			</div>

			<div class="collapse navbar-collapse" id="navbarNavDropdown">
				<form class="" action="MonAnController" method="get">
					<div class=" d-flex flex-row ms-auto d-none d-lg-block">
						<div class="input-group">

							<input name="txttk" type="text" class="form-control"
								style="color: #ff5b6a" />
							<button class="btn btn-custom text-white">Tìm</button>


						</div>
					</div>
				</form>

				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a
						class="nav-link mx-2 text-uppercase navbar-custom"
						href="MonAnController">Trang Chủ</a></li>
					<li class="nav-item"><a
						class="nav-link mx-2 text-uppercase navbar-custom"
						href="HTGioHangController">Giỏ Hàng</a></li>
					<li class="nav-item"><a
						class="nav-link mx-2 text-uppercase navbar-custom"
						href="LichSuMuaHangController">Lịch sử</a></li>
				</ul>
				<ul class="navbar-nav ms-auto text-auth">
					<li class="nav-item "><c:choose>
							<c:when test="${sessionScope.hoten == null }">
								<a class="nav-link mx-2 text-uppercase "
									href="DangNhapController"><span class="text-auth"><i
										class="fa fa-user"></i> LOG IN</span></a>
							</c:when>
							<c:otherwise>
								<a class="nav-link mx-2 text-uppercase "
									href="ThongTinKhachHangController"><span class="text-auth"><i
										class="fa fa-user"></i> Hi: ${ sessionScope.hoten.getHoTen() }</span></a>
							</c:otherwise>
						</c:choose></li>
					<li class="nav-item"><a class="nav-link mx-2 text-uppercase "
						href="DangXuatController"><span class="text-auth"><i
								class="fa fa-user"></i> LOG OUT</span></a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Navbar -->

	<div class="wrapper" style="height: 1000px">
		<div class="main">
			<div class="container"
				style="padding-top: 40px; min-height: 300px; padding-bottom: 40px; max-width: 1140px;">
				<div class="d-flex d-flex justify-content-between flex-row mx-auto">
					<div class="me-3">
						<a href="" class="text-decoration-none">
							<div class="">
								<img
									src="https://www.lotteria.vn/media/catalog/tmp/category/Promotion-01_1.jpg"
									width="72" alt="" class="rounded-1" />
								<p class="d-flex justify-content-center" style="color: #ff5b6a">
									Gà rán</p>
							</div>
						</a>
					</div>
				</div>

				<!-- Thông tin -->
				<div class="my-account">
					<div class="account-left" style="">
						<div class="b-avatar">
							<div class="f-name">
								<c:out value="${sessionScope.catchuoi }" />
							</div>
							<div class="f-fullname">${sessionScope.hoten.getHoTen() }</div>

						</div>
						<div class="b-menu">
							<ul>
								<li class="active"><a title="Thông tin tài khoản"
									href="ThongTinTaiKhoanController"><i
										class="fa-solid fa-user"></i> Thông tin tài khoản</a></li>

								<li class=""><a title="Lịch sử đơn hàng"
									href="LichSuMuaHangController"><i
										class="fa-solid fa-clipboard-list"></i> Lịch sử đơn hàng</a></li>
							</ul>
						</div>
					</div>
					<div class="account-right d-block">
						<button class="f-back"></button>
						<h2 class="head-title">Thông tin tài khoản</h2>
						<div class="account-content">
							<div class="acc-info-form">
						
								<h5>THÔNG TIN CÁ NHÂN</h5>
								<form action="ThongTinKhachHangController" method="post">
									<div class="form-group row">
										<label for="r_name" class="col-md-3 col-form-label">Họ
											tên</label>
										<div class="col-md-7">
											<input type="text" placeholder="Họ tên" class="form-control"
												id="r_name" name="firstname"
												value="${ttkh.hoTen }" />
										</div>
									</div>
									<div class="form-group row" style="display: none">
										<label for="r_birthday" class="col-md-3 col-form-label">Ngày
											sinh</label>
										<div class="col-md-7">
											<div class="react-datepicker-wrapper">
												<div class="react-datepicker__input-container">
													<input type="text" id="r_birthday" placeholder="Ngày sinh"
														autocomplete="off" class="form-control" value="" />
												</div>
											</div>
										</div>
									</div>
									<div class="form-group row">
										<label for="r_tel" class="col-md-3 col-form-label">Số
											điện thoại</label>
										<div class="col-md-7">
											<input type="text" placeholder="Số điện thoại"
												class="form-control" id="r_tel" name="telephone"
												value="${ttkh.soDienThoai }" />
										</div>
									</div>
									<div class="form-group row">
										<label for="r_email" class="col-md-3 col-form-label">Email</label>
										<div class="col-md-7">
											<input type="text" placeholder="Vui lòng nhập email của bạn"
												class="form-control" id="r_email" name="email"
												value="${ttkh.email }" />
										</div>
									</div>
									<div class="form-action">
										<button type="submit" class="btn btn-primary" name="btnsave"
											title="Lưu thông tin">Lưu thông tin</button>
									</div>
								</form>
								<br />
								<h5>Thay đổi mật khẩu</h5>
								<form action="DoiMatKhauController" method="post">
									<div class="form-group row">
										<label for="r_old_password" class="col-md-3 col-form-label">Mật
											khẩu cũ</label>
										<div class="col-md-7">
											<input type="password" placeholder="Nhập mật khẩu cũ"
												class="form-control" id="r_old_password" name="oldPassword" />
											<span style="color: #cf111a">${smk }</span>
										</div>

									</div>
									<div class="form-group row">
										<label for="r_new_password" class="col-md-3 col-form-label">Mật
											khẩu mới</label>
										<div class="col-md-7">
											<input type="password" placeholder="Nhập mật khẩu mới"
												class="form-control" id="r_new_password" name="newPassword" />
										</div>
									</div>
									<div class="form-group row">
										<label for="r_confirm_password"
											class="col-md-3 col-form-label">Nhập lại mật khẩu</label>
										<div class="col-md-7">
											<input type="password" placeholder="Nhập lại mật khẩu"
												class="form-control" id="r_confirm_password"
												name="confirmPassword" /> <span style="color: #cf111a">${xn }</span>
										</div>

									</div>

									<div class="form-action">

										<button type="submit" class="btn btn-primary">Cập
											nhật mật khẩu</button>


									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- end Thông tin -->
			</div>
		</div>
	</div>
</body>
</html>
