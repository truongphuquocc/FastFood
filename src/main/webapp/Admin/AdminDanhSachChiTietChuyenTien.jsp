<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css"
	integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>SB Admin 2 - Tables</title>

<!-- Custom fonts for this template -->
<link href="Admin/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="Admin/css/sb-admin-2.min.css" rel="stylesheet" />

<!-- Custom styles for this page -->
<link href="Admin/vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet" />
</head>

<body id="page-top">
	<!-- Page Wrapper -->
	<div id="wrapper">
		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">
			<!-- Sidebar - Brand -->
			<a
				class="sidebar-brand d-flex align-items-center justify-content-center"
				href="index.html">
				<div class="sidebar-brand-icon rotate-n-15">
					<i class="fas fa-laugh-wink"></i>
				</div>
				<div class="sidebar-brand-text mx-3">
					SB Admin <sup>2</sup>
				</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0" />

			<!-- Nav Item - Dashboard -->
			<li class="nav-item"><a class="nav-link" href="AdminController">
					<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
			</a></li>

			<!-- Nav Item - Charts -->

			<li class="nav-item"><a class="nav-link"
				href="AdminXacNhanController"> <i
					class="fas fa-fw fa-chart-area "></i> <span>X??c nh???n</span>
			</a></li>

			<li class="nav-item active"><a class="nav-link"
				href="AdminDanhSachChuyenTienController"> <i
					class="fas fa-fw fa-chart-area"></i> <span>Danh s??ch chuy???n
						ti???n</span></a></li>

			<li class="nav-item"><a class="nav-link"
				href="AdminQuanLyLoaiController"> <i
					class="fas fa-fw fa-chart-area"></i> <span>Qu???n l?? lo???i</span>
			</a></li>

			<li class="nav-item"><a class="nav-link"
				href="AdminQuanLyKhachHangController"> <i
					class="fas fa-fw fa-chart-area"></i> <span>Qu???n l?? kh??ch
						h??ng</span></a></li>

			<!-- Nav Item - Tables -->
			<li class="nav-item"><a class="nav-link"
				href="AdminQuanLyMonController"> <i class="fas fa-fw fa-table"></i>
					<span>Qu???n l?? m??n ??n</span></a></li>

			<!-- Divider -->
			<hr class="sidebar-divider d-none d-md-block" />

			<!-- Sidebar Toggler (Sidebar) -->
			<div class="text-center d-none d-md-inline">
				<button class="rounded-circle border-0" id="sidebarToggle"></button>
			</div>
		</ul>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<!-- Sidebar Toggle (Topbar) -->
					<form class="form-inline">
						<button id="sidebarToggleTop"
							class="btn btn-link d-md-none rounded-circle mr-3">
							<i class="fa fa-bars"></i>
						</button>
					</form>

					<!-- Topbar Search -->
					<form
						class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
						<div class="input-group">
							<input type="text" class="form-control bg-light border-0 small"
								placeholder="Search for..." aria-label="Search"
								aria-describedby="basic-addon2" />
							<div class="input-group-append">
								<button class="btn btn-primary" type="button">
									<i class="fas fa-search fa-sm"></i>
								</button>
							</div>
						</div>
					</form>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">
						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2" />
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <c:if
									test="${sessionScope.ad != null }">
									<span class="mr-2 d-none d-lg-inline text-gray-600 small">Hi:
										${ sessionScope.ad.getTenDangNhap() }</span>
									<img class="img-profile rounded-circle"
										src="Admin/img/undraw_profile.svg" />
								</c:if> <c:if test="${sessionScope.ad == null }">
									<span class="mr-2 d-none d-lg-inline text-gray-600 small">Login</span>
									<img class="img-profile rounded-circle"
										src="Admin/img/undraw_profile.svg" /></a> <!-- Dropdown - User Information -->
							</c:if>
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="AdminLoginController"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Login
									with Customer
								</a>
								<c:choose>
									<c:when test="${sessionScope.ad == null }">
										<a class="dropdown-item" href="AdminLoginController"> <i
											class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Login
										</a>
									</c:when>
									<c:otherwise>
										<div class="dropdown-divider"></div>
										<a class="dropdown-item" href="#" data-toggle="modal"
											data-target="#logoutModal"> <i
											class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
											Logout
										</a>
									</c:otherwise>
								</c:choose>
							</div></li>
					</ul>
				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Chi Ti???t danh s??ch chuy???n ti???n</h1>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Danh s??ch chi ti???t chuy???n ti???n</h6>
						</div>
						<div class="card-body">

							<div class="table-responsive">
								<form action="AdminXacNhanController">
									<button class="btn btn-sm btn-success"
										formaction="AdminXacNhanController" formmethod="post">
										<i class="fa-solid fa-check"></i>Quay L???i
									</button>
								</form>

								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>M?? CTHD</th>
											<th>M?? Ho?? ????n</th>
											<th>H??? t??n</th>
											<th>T??n M??n</th>
											<th>S??? l?????ng mua</th>
											<th>Gi??</th>
											<th>Th??nh Ti???n</th>
											<th>???? Mua</th>

										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>M?? CTHD</th>
											<th>M?? Ho?? ????n</th>
											<th>H??? t??n</th>
											<th>T??n M??n</th>
											<th>S??? l?????ng mua</th>
											<th>Gi??</th>
											<th>Th??nh Ti???n</th>
											<th>???? Mua</th>

										</tr>
									</tfoot>
									<tbody>
										<c:forEach items="${dsctdh }" var="item">
											<tr>
												<form
													action="AdminXacNhanChiTietController?mact=${item.maChiTietHoaDon}&mahd=${item.maHoaDon}"
													method="post">
													<td>${item.maChiTietHoaDon }</</td>
													<td>${item.maHoaDon }</</td>
													<td>${item.hoTen }</</td>
													<td>${item.tenMonAn }</</td>
													<td>${item.soLuongMua }</</td>
													<td>${item.gia }.000</</td>
													<td>${item.thanhTien }.000</</td>
													<td class="text-center"><c:choose>
															<c:when test="${item.daMua == false }">
																<p class="text-danger">Ch??a X??c Nh???n</p>
															</c:when>
															<c:otherwise>
																<p class="text-success">???? X??c Nh???n</p>
															</c:otherwise>
														</c:choose></td>

												</form>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2020</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->
		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">x</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="AdminDangXuatController">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="Admin/vendor/jquery/jquery.min.js"></script>
	<script src="Admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="Admin/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="Admin/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="Admin/vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="Admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="Admin/js/demo/datatables-demo.js"></script>
</body>
</html>
