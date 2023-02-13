<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap 5 Example</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Font Icon -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<!-- Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="Css/TrangChu.css">
<!-- Google Font -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
	rel="stylesheet">

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
						class="nav-link mx-2 text-uppercase navbar-custom" href="MonAnController">Trang
							Chủ</a></li>
					<li class="nav-item"><a
						class="nav-link mx-2 text-uppercase navbar-custom" href="HTGioHangController">Giỏ
							Hàng</a></li>
					<li class="nav-item"><a
						class="nav-link mx-2 text-uppercase navbar-custom" href="LichSuMuaHangController">Lịch sử</a></li>
				</ul>
				<ul class="navbar-nav ms-auto text-auth">
					<li class="nav-item "><c:choose>
							<c:when test="${sessionScope.hoten == null }">
								<a class="nav-link mx-2 text-uppercase "
									href="DangNhapController"><span class="text-auth"><i
										class="fa fa-user"></i> LOG IN</span></a>
							</c:when>
							<c:otherwise>
								<a class="nav-link mx-2 text-uppercase " href="ThongTinKhachHangController"><span
									class="text-auth"><i class="fa fa-user"></i> Hi: ${ sessionScope.hoten.getHoTen() }</span></a>
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
		<div class="main" style="background-color: #fffcfe">
			<div class="container"
				style="padding-top: 40px; min-height: 300px; padding-bottom: 40px; max-width: 1140px;">
				<div class="d-flex d-flex justify-content-between flex-row mx-auto">
					<c:forEach var="l" items="${dsloai}">
						<div class="me-3">
							<a href="MonAnController?ml=${l.getMaLoai()}"
								class="text-decoration-none">
								<div class="" style="max-width: 72px">
									<img src="${l.getAnhLoai()}" width="72" alt=""
										class="rounded-1" />
									<p class="d-flex justify-content-center"
										style="color: #142f43; text-align: center;">
										${l.getTenLoai()}</p>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>


				<div class="container py-5">
					<div class="row justify-content-center">
						<c:forEach var="l" items="${dsmon}">
							<div class="col-md-8 col-lg-6 col-xl-3">
								<div class="card text-black"
									style="min-height: 400; min-width: 260; margin-bottom: 22px">
									<img src="${l.getAnh()}" class="card-img-top"
										style="object-fit: contain; width: 100%; max-height: 100%;" />
									<div class="card-body">
										<div class="text-left">
											<h3 class="card-title">${l.getTenMonAn()}</h3>
										</div>
										<div>
											<div class="d-flex justify-content-between">
												<span class="price">${l.getGia()}.000 ₫</span>
											</div>
										</div>
										<div
											class="d-flex justify-content-between total font-weight-bold mt-4">
											<%-- 											<form
												action="GioHangController?mm=${l.getMaMonAn() }&tm=${l.getTenMonAn() }&gia=${l.getGia() }">
												<button type="submit" class="btn text-white"
													style="width: 100%">Thêm vào giỏ hàng</button>
											</form> --%>
											<%-- 	<a class="btn btn-danger text-white"
												href="GioHangController?mm=${l.getMaMon()}&tm=${l.getTenMonAn()}&gia=${l.getGia()}"
												style="width: 100%"> Primary</a> --%>
											<a
									href="GioHangController?anh=${l.anh }&mm=${l.maMonAn }&tm=${l.tenMonAn }&gia=${l.gia }"
									class="btn btn-primary d-felx " style="background: #ff5b6a; width: 100%;">
									<i class="fa-solid fa-cart-plus"></i> Thêm Vào Giỏ Hàng
								</a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>


				<c:if test="${endPage > 1 }">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
							<li class="page-item"><a class="page-link"
								href="MonAnController?page=${Integer.parseInt(currentPage)-1}&ml=${mloai}&key=${keyTD}">Previous</a></li>
							<c:forEach begin="1" end="${endPage }" var="i">
								<li class="page-item ${i == currentPage ? 'active' : '' }"><a
									class="page-link"
									href="MonAnController?page=${i}&ml=${mloai}&key=${keyTD}">${i}</a></li>
							</c:forEach>
							<li class="page-item"><a class="page-link"
								href="MonAnController?page=${Integer.parseInt(currentPage)+1}&ml=${mloai}&key=${keyTD}">Next</a></li>
						</ul>
					</nav>
				</c:if>

			</div>
		</div>
	</div>
</body>
</html>