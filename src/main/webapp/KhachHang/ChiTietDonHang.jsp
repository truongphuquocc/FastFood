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
								<li><a title="Thông tin tài khoản"
									href="ThongTinKhachHangController"><i
										class="fa-solid fa-user"></i> Thông tin tài khoản</a></li>
								<li class=""><a title="Địa chỉ giao hàng" href="#"><i
										class="fa-solid fa-location-dot"></i> Địa chỉ giao hàng</a></li>
								<li class="active"><a title="Lịch sử đơn hàng"
									href="LichSuMuaHangController"><i
										class="fa-solid fa-clipboard-list"></i> Lịch sử đơn hàng</a></li>
							</ul>
						</div>
					</div>
					<div class="account-right d-block">
						<button class="f-back"></button>
						<h2 class="head-title">CHI TIẾT ĐƠN HÀNG</h2>

						<div class="account-content acc-history-detail">
							<div class="g-info">
								<div class="f-left">
									<div class="f-name">${sessionScope.hoten.getHoTen() }</div>
									<p class="f-address">${sessionScope.hoten.getDiaChi() }</p>
									<p class="f-phone">Điện thoại:
										${sessionScope.hoten.getSoDienThoai() }</p>
								</div>
								<div class="f-right">
									<div class="f-order">
										<div class="f-title">Mã đơn hàng:</div>
										<div class="f-text red-color">
											<strong>#${sessionScope.dshd.maHoaDon }</strong>
										</div>
									</div>
									<div class="f-time">
										<div class="f-title">Thời gian đặt:</div>
										<div class="f-text">${sessionScope.dshd.ngayMua }</div>
									</div>
									<!-- 									<div class="f-payment">
										<div class="f-title">Hình thức thanh toán:</div>
										<div class="f-text">Thanh toán khi nhận hàng</div>
									</div> -->
								</div>
							</div>
							<div class="table-responsive">
								<table class="list-order-detail">
									<thead>
										<tr>
											<th>Sản phẩm</th>
											<th>Số lượng</th>
											<th>Giá</th>
											<th class="f-sum">Thành tiền</th>
										</tr>
									</thead>
									<c:forEach items="${dsctlichsu }" var="item">
										<tbody>

											<tr>
												<td class="f-name">
													<div>
														<img src="${item.anh }" alt="Combo 111,000đ" />Combo
														111,000đ
													</div>
												</td>
												<td class="f-number"><span>${item.soLuongMua }</span></td>
												<td class="f-price"><span>${item.gia }</span><span>.</span><span>000</span><span>₫</span>
												</td>
												<td class="f-sum"><span>${item.thanhTien }</span><span>.</span><span>000</span><span>₫</span>
												</td>
											</tr>
										</tbody>
									</c:forEach>
								</table>
							</div>
							<div class="g-sum">
								<table>
									<tbody>
										<tr>
											<td><strong>Thành tiền</strong></td>
											<td><strong><span>111</span><span>.</span><span>000</span><span>₫</span></strong>
											</td>
										</tr>
									</tbody>
								</table>
								<div class="group-btn">

									<a title="Quay lại đơn hàng của tôi"
										class="btn btn-primary btn-back"
										href="/account/history?tab=delivery_complete">← Quay lại
										đơn hàng của tôi</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end Thông tin -->
		</div>
	</div>
</body>
</html>
