package Controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.KhachHangBean;
import Bo.KhachHangBo;

/**
 * Servlet implementation class DoiMatKhauController
 */
@WebServlet("/DoiMatKhauController")
public class DoiMatKhauController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoiMatKhauController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String convertHashToString(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hashInBytes = md.digest(text.getBytes(StandardCharsets.UTF_8));
		StringBuilder sb = new StringBuilder();
		for (byte b : hashInBytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String matkhaucu = request.getParameter("oldPassword");
			System.out.println(matkhaucu + "matkhaucu");
			String Matkhaumoi = request.getParameter("newPassword");
			System.out.println(Matkhaumoi + "Matkhaumoi");
			String Xacnhanmatkhau = request.getParameter("confirmPassword");
			HttpSession session = request.getSession();
			KhachHangBean kh = (KhachHangBean) session.getAttribute("hoten");
			KhachHangBo khbo = new KhachHangBo();

			if (kh.getMatKhau().equals(convertHashToString(matkhaucu)) && !Matkhaumoi.isEmpty()) {
				if (Matkhaumoi.equals(Xacnhanmatkhau)) {
					if (khbo.ChangePassword(kh.getTenDangNhap(), convertHashToString(Matkhaumoi))) {
						RequestDispatcher rd = request.getRequestDispatcher("KhachHang/ThongTin.jsp");
						rd.forward(request, response);
					} else {
						RequestDispatcher rd = request.getRequestDispatcher("KhachHang/ThongTin.jsp");
						rd.forward(request, response);
					}

				} else {
					request.setAttribute("xn", "Xác nhận mật khẩu không đúng");
					RequestDispatcher rd1 = request.getRequestDispatcher("KhachHang/ThongTin.jsp");
					rd1.forward(request, response);
				}

			} else {
				request.setAttribute("smk", "Mat khau khong chinh xac");
				RequestDispatcher rd = request.getRequestDispatcher("KhachHang/ThongTin.jsp");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
