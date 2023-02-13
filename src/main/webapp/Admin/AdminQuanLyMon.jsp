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

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous" />
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

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

<!-- alert -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="/public/share/assets/plugins/sweet-alert/sweetalert.min.js"></script>
<script
	src="/public/share/assets/js/pages/sweet-alert/sweet-alert-data.js"></script>
<!-- alert -->
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
				href="AdminController">
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
					class="fas fa-fw fa-chart-area"></i> <span>Xác nhận</span>
			</a></li>

			<li class="nav-item"><a class="nav-link"
				href="AdminDanhSachChuyenTienController"> <i
					class="fas fa-fw fa-chart-area"></i> <span>Danh sách chuyển
						tiền</span></a></li>

			<li class="nav-item"><a class="nav-link"
				href="AdminQuanLyLoaiController"> <i
					class="fas fa-fw fa-chart-area"></i> <span>Quản lý loại</span></a></li>

			<li class="nav-item"><a class="nav-link"
				href="AdminQuanLyKhachHangController"> <i
					class="fas fa-fw fa-chart-area"></i> <span>Quản lý khách
						hàng</span></a></li>

			<!-- Nav Item - Tables -->
			<li class="nav-item active"><a class="nav-link"
				href="AdminQuanLyMonController"> <i class="fas fa-fw fa-table"></i>
					<span>Quản lý món ăn</span>
			</a></li>

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
					<h1 class="h3 mb-2 text-gray-800">Quản lý món</h1>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Danh sách món</h6>
						</div>

						<div class="card-body">
							<div class="mb-3">
								<a href="AdminQuanLyMonController?btnAdd=${1 }"
									class="btn btn-sm btn-success" type="submit"> <i
									class="fa-solid fa-plus"></i> Thêm Món
								</a>
							</div>
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>Mã món ăn</th>
											<th>Tên món ăn</th>
											<th>Ảnh</th>
											<th>Số lượng</th>
											<th>Giá</th>
											<th>Ngày nhập</th>
											<th>Active</th>
										</tr>
									</thead>
									<tfoot>
										<tr>
											<th>Mã món ăn</th>
											<th>Tên món ăn</th>
											<th>Ảnh</th>
											<th>Số lượng</th>
											<th>Giá</th>
											<th>Ngày nhập</th>
											<th>Active</th>
										</tr>
									</tfoot>
									<tbody>
										<c:forEach items="${dsmon }" var="item">
											<tr>
												<td>${item.maMonAn }</td>
												<td>${item.tenMonAn }</td>
												<td><img style="width: 70px" src='${item.anh }'></td>
												<td>${item.soLuong }</td>
												<td>${item.gia }</td>

												<td>${item.ngayNhap }</td>
												<td><a
													href="AdminXoaMonController?btnDelete=${1 }&mm=${item.maMonAn }"
													class="btn btn-sm btn-danger btn-circle"><i
														class="fa-solid fa-trash"></i></a> <a
													href="AdminQuanLyMonController?ms=${1 }&mm=${item.maMonAn}"
													class="btn btn-sm btn-success btn-circle"> <i
														class="fa-solid fa-user-pen"></i>
												</a></td>
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

	<!-- Logout Modal data-target="#my-modal" type="submit"-->
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


	<!-- Delete modal -->
	<div class="container d-flex justify-content-center">
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Bạn có muốn xoá loại hàng này không</div>
					<div class="modal-footer">

						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<!-- 						<form
							action="AdminXoaLoaiController?btnxoa=23"
							method="post">
							<button type="submit" class="btn btn-primary">Save
								changes</button>
						</form> -->

						<a href="AdminQuanLyMonController?btnxoa=${'1' }"
							class="btn btn-danger">Xác nhận xoá</a>

					</div>
				</div>
			</div>
		</div>
	</div>

	<%-- 	<c:if test="${sessionScope['checkshowmodal'] != null }">
		<script>
			$("#myModal").modal("show");
		</script>
		<%
		session.removeAttribute("checkshowmodal");
		%>
	</c:if> --%>

	<c:if test="${sessionScope.check != null }">
		<script type="text/javascript">
			Swal.fire({
				position : 'center',
				icon : 'error',
				title : 'Không thể xoá loại hàng này !!!',
				showConfirmButton : false,
				timer : 2500
			})
		</script>
		<%
		session.removeAttribute("check");
		%>
	</c:if>

	<c:if test="${sessionScope.compl != null }">
		<script type="text/javascript">
			Swal.fire({
				position : 'center',
				icon : 'success',
				title : 'Xoá thành công !!!',
				showConfirmButton : false,
				timer : 2500
			})
		</script>
		<%
		session.removeAttribute("compl");
		%>
	</c:if>

	<c:if test="${tb != null }">
		<script type="text/javascript">
			Swal.fire({
				position : 'center',
				icon : 'success',
				title : 'Thành công',
				showConfirmButton : false,
				timer : 2500
			})
		</script>
	</c:if>

	<c:if test="${sessionScope.checkadd == -1 }">
		<script type="text/javascript">
			Swal.fire({
				position : 'center',
				icon : 'error',
				title : 'Thêm thất bại vì trùng mã!!!',
				showConfirmButton : false,
				timer : 2500
			})
		</script>
		<%
		session.removeAttribute("checkadd");
		%>
	</c:if>
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
