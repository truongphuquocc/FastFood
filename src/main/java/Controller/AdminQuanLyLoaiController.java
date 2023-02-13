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
import Bean.LoaiHangBean;
import Bo.LoaiHangBo;

/**
 * Servlet implementation class AdminQuanLyLoaiController
 */
@WebServlet("/AdminQuanLyLoaiController")
public class AdminQuanLyLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminQuanLyLoaiController() {
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
			/*
			 * String xoamodal = request.getParameter("btnxoa"); if
			 * (request.getParameter("btnxoa") != null) { session.setAttribute("xoa11",
			 * xoamodal); }
			 */
			if (ad != null) {
				LoaiHangBo lbo = new LoaiHangBo();
				LoaiHangBean lbean = null;
				ArrayList<LoaiHangBean> dsloai = null;
				dsloai = lbo.getloai();
				String key = request.getParameter("key");
				String ml = request.getParameter("ml");
				if (key != null)
					dsloai = lbo.Tim(key);
				request.setAttribute("dsloai", dsloai);

				if (request.getParameter("btnDelete") != null) {
					String checkshowmodal = request.getParameter("mm");
					if (lbo.checkDeleteCategory(checkshowmodal)) {
						lbo.deleteCategory(checkshowmodal);
						dsloai = lbo.getloai();
						request.setAttribute("dsloai", dsloai);
						response.sendRedirect("AdminQuanLyLoaiController");
					} else {
						int checkxoa = 0;
						session.setAttribute("checkxoa", checkxoa);
						dsloai = lbo.getloai();
						request.setAttribute("dsloai", dsloai);
						RequestDispatcher rd1 = request.getRequestDispatcher("Admin/AdminQuanLyLoai.jsp");
						rd1.forward(request, response);
					}
				}
				if (request.getParameter("btnEdit") != null) {
					LoaiHangBo loai = new LoaiHangBo();
					// ArrayList<LoaiHangBean> dsloai = null;
					dsloai = loai.getloai();
					request.setAttribute("dsloai", dsloai);
					lbean = lbo.getCategory(request.getParameter("mm"));
					request.setAttribute("lbean", lbean);

					RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminSuaLoai.jsp");
					rd.forward(request, response);
				}

				if (request.getParameter("btnAdd") != null) {
					RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminThemLoai.jsp");
					rd.forward(request, response);
				}

				RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminQuanLyLoai.jsp");
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
