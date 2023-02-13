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
import Bean.MonAnBean;
import Bo.MonAnBo;

/**
 * Servlet implementation class AdminXoaMonController
 */
@WebServlet("/AdminXoaMonController")
public class AdminXoaMonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminXoaMonController() {
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
				MonAnBo mabo = new MonAnBo();
				MonAnBean mabean;
				ArrayList<MonAnBean> dsmon;
				dsmon = mabo.GetMonAn();
				request.setAttribute("dsmon", dsmon);
				if (request.getParameter("btnDelete") != null) {
					String checkshowmodal = request.getParameter("mm");
					session.setAttribute("checkshowmodal", checkshowmodal);
					System.out.println(checkshowmodal + "MaMon");
					System.out.println(mabo.checkXoaMonAn(checkshowmodal) + "cmnn");
					boolean checkduocxoa = false;
					checkduocxoa = mabo.checkXoaMonAn(checkshowmodal);
					if (checkduocxoa == true) {
						System.out.println("Xoa duoc");
						dsmon = mabo.GetMonAn();
						request.setAttribute("dsmon", dsmon);
						mabo.xoaChiTietHoaDon(checkshowmodal);
						mabo.deleteMonAn(checkshowmodal);
						session.setAttribute("compl", "compl");
						dsmon = mabo.GetMonAn();
						request.setAttribute("dsmon", dsmon);
						// RequestDispatcher rd =
						// request.getRequestDispatcher("Admin/AdminQuanLyMon.jsp");
						// rd.forward(request, response);
						response.sendRedirect("AdminQuanLyMonController");

					} else {
						int check = 1;
						System.out.println("Khong Xoa duoc");
						session.setAttribute("check", check);
						dsmon = mabo.GetMonAn();
						// session.removeAttribute("check");
						request.setAttribute("dsmon", dsmon);
						// RequestDispatcher rd =
						// request.getRequestDispatcher("Admin/AdminQuanLyMon.jsp");
						// rd.forward(request, response);
						response.sendRedirect("AdminQuanLyMonController");
					}
				}
				RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminQuanLyMon.jsp");
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
