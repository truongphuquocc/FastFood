package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.AdminBean;
import Bean.KhachHangBean;
import Bean.LoaiHangBean;
import Bo.KhachHangBo;
import Bo.LoaiHangBo;

/**
 * Servlet implementation class AdminQuanLyKhachHangController
 */
@WebServlet("/AdminQuanLyKhachHangController")
public class AdminQuanLyKhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminQuanLyKhachHangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setCharacterEncoding("utf-8");
			request.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			AdminBean ad = (AdminBean) session.getAttribute("ad");
			if (ad != null) {
				KhachHangBo khbo = new KhachHangBo();
				ArrayList<KhachHangBean> dskh = null;
				dskh = khbo.getKhachHang();
				request.setAttribute("dskh", dskh);
				System.out.println((request.getParameter("makh")+"dskh"));
				if (request.getParameter("btnDelete") != null) {
					// lbo.deleteBook(request.getParameter("mamon"));
					//lbo.deleteCategory(request.getParameter("mm"));
					//dsloai = lbo.getloai();
					khbo.deleteKhachHang(request.getParameter("makh"));
					dskh = khbo.getKhachHang();
					request.setAttribute("dskh", dskh);
					RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminQuanLyKhachHang.jsp");
					rd.forward(request, response);
				}

				RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminQuanLyKhachHang.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("tb", "Bạn cần đăng nhập");
				RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminLogin.jsp");
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
