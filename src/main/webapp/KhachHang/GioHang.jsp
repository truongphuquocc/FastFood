<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap 5 Example</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" type="text/css" href="Css/GioHang.css">
<link rel="stylesheet" type="text/css" href="Css/base.css">
<link rel="stylesheet" type="text/css" href="Css/TrangChu.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" type="text/css" href="Css/TrangChu.css">
<!-- alert -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="/public/share/assets/plugins/sweet-alert/sweetalert.min.js"></script>
<script
	src="/public/share/assets/js/pages/sweet-alert/sweet-alert-data.js"></script>
<!-- alert -->

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


				<!-- Cart -->

				<div class="cart-content">
					<h2 class="head-title">
						<a href="MonAnController" class="add-more" name=""
							style="background-color: Transparent;">+ Thêm món ăn</a> Giỏ hàng
						của bạn
					</h2>

					<div class="cart-list">
						<c:forEach items="${sessionScope.gio.getall() }" var="item">
							<form action="HTGioHangController" method="post">
								<div class="cart-row">
									<button name="btnxoa" value="${item.maMonAn }" type="submit"
										class="btn-delete"></button>
									<input type="checkbox" style="display: none" name="check"
										value="${item.getMaMonAn() }" class="form-check-input">
									<div class="field-img">
										<%-- <img
										src="${item.getAnh() }"
										alt="${item.getAnh() }" /> --%>
										<img src="${item.getAnh()}" class="card-img-top"
											style="object-fit: contain; width: 100%; max-height: 100%;" />
									</div>
									<div class="field-info">
										<h3>
											<a href="">${item.getTenMonAn() }</a>
										</h3>
									</div>
									<div class="field-price">
										<span>${item.getGia() }</span> <span>.</span> <span>000</span>
										<span>đ</span>
									</div>
									<div class="qty sm-type">
										<div class="q-inner">
											<!-- <button class="btn-minute"><i class="fa-solid fa-minus"></i></button> -->

											<input min="0" name="t${item.maMonAn }" class="number"
												value="${item.getSoLuong() }">
											<button name="btnsua" value="${item.maMonAn }" type="submit"
												class="btn-plus">
												<i class="fa-solid fa-check"></i>
											</button>
										</div>
									</div>
								</div>
							</form>
						</c:forEach>

					</div>
					<!-- 					<form action="ThanhToanController" method="post">
						<div class="order-notes">
							<p>
								<strong>Ghi chú cho đơn hàng</strong>
							</p>
							<div class="form-group">
								<input type="text" name="txtghichu"
									placeholder="Vui lòng thêm lưu ý cho cửa hàng"
									class="form-control" />
							</div>
						</div>
					</form> -->
				</div>

				<div class="cart-right">
					<div class="box-border">
						<div class="delivery-to">
							<a href="" title="Thay đổi" class="btn-change-add"><span>Thay
									đổi</span></a><span class="lbl">Giao hàng đến</span>
							<div class="add">${ sessionScope.hoten.getDiaChi() }</div>
							<div class="store-name">Cửa hàng: CHICKEN SHOP</div>
						</div>
						<div class="note-time">Thời gian tiếp nhận đơn hàng trực
							tuyến từ 08:30 đến 21:00 hằng ngày</div>
					</div>
					<div class="box-border">
						<form action="ThanhToanController" method="post">
							<div class="order-notes" style="box-shadow: none;">
								<p>
									<strong>Ghi chú cho đơn hàng</strong>
								</p>
								<div class="form-group">
									<input type="text" name="txtghichu"
										placeholder="Vui lòng thêm lưu ý cho cửa hàng"
										class="form-control" />
								</div>
							</div>
							<div class="sub-total">
								<div class="lbl">Tổng cộng</div>
								<div class="price">
									<span>${sessionScope.gio.Tongtien()}</span><span>.</span><span>000</span><span>₫</span>
								</div>
							</div>

							<div class="total">
								<div class="lbl">Tổng cộng</div>
								<div class="price">
									<span>${sessionScope.gio.Tongtien() }</span><span>.</span><span>000</span><span>₫</span>
								</div>
							</div>
							<div class="btn-payment">
								<c:choose>
									<c:when
										test="${sessionScope.gio.getall().size() == 0 || check == 0}">
										<button name="btnThanhToan" class="disabled"
											style="background: #e99fa6; cursor: not-allowed" disabled
											type="submit" title="Tiếp tục">Tiếp tục</button>
									</c:when>
									<c:otherwise>
										<button name="btnThanhToan" class="disabled" type="submit"
											title="Tiếp tục">Tiếp tục</button>
									</c:otherwise>
								</c:choose>
							</div>
						</form>
					</div>

				</div>
				<c:if test="${sessionScope.gio.getall().size() == 0 || check == 0}">
					<div class="cart-empty body-mh-300 p-3 rounded"
						style="justify-content: center; background: white; display: flex; align-items: center;">
						<div style="text-align: center">
							<div class="icon-empty-cart">
								<img
									src="https://cdn0.fahasa.com/skin//frontend/ma_vanese/fahasa/images/checkout_cart/ico_emptycart.svg"
									class="center">
							</div>
							<p style="font-size: 14px; margin: 20px 0;">Chưa có sản phẩm
								trong giỏ hàng của bạn.</p>
							<div class="m-3">
								<a href="MonAnController" class="btn btn-danger"
									style="background: #ff5b6a">Mua sắm ngay</a>
							</div>
						</div>
					</div>
					<%
					session.removeAttribute("check");
					%>
				</c:if>
				<!-- end cart -->
			</div>

		</div>

	</div>
</body>
</html>
