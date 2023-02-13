package Controller;

import java.io.IOException;
import java.rmi.Remote;
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
import Bean.MonAnBean;
import Bo.LoaiHangBo;
import Bo.MonAnBo;

/**
 * Servlet implementation class AdminQuanLyMonController
 */
@WebServlet("/AdminQuanLyMonController")
public class AdminQuanLyMonController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminQuanLyMonController() {
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
//			String xoamodal = request.getParameter("btnxoa");

//			System.out.println(xoamodal + "xoaaaa");
//			if (request.getParameter("btnxoa") != null) {
//				session.setAttribute("xoa11", xoamodal);
//			}

			System.out.println(session.getAttribute("xoa11") + "xoaaaa");

			if (ad != null) {

				MonAnBo mabo = new MonAnBo();
				MonAnBean mabean;
				ArrayList<MonAnBean> dsmon;
				dsmon = mabo.GetMonAn();
				request.setAttribute("dsmon", dsmon);

				// String mm = request.getParameter("mm");

				System.out.println(request.getParameter("ms") + "btnedittttttttt");
				if (request.getParameter("ms") != null) {
					LoaiHangBo loai = new LoaiHangBo();
					ArrayList<LoaiHangBean> dsloai = null;
					dsloai = loai.getloai();
					request.setAttribute("dsloai", dsloai);
					mabean = mabo.getMotMon(request.getParameter("mm"));
					request.setAttribute("mabean", mabean);
					RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminSuaMon.jsp");
					rd.forward(request, response);
				}

				if (request.getParameter("btnAdd") != null) {
					LoaiHangBo loai = new LoaiHangBo();
					ArrayList<LoaiHangBean> dsloai = null;
					dsloai = loai.getloai();
					request.setAttribute("dsloai", dsloai);
					mabean = mabo.getMotMon(request.getParameter("mm"));
					request.setAttribute("mabean", mabean);
					RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminThemMon.jsp");
					rd.forward(request, response);
				}

//				if (request.getParameter("btnDelete") != null) {
//					
//					String checkshowmodal = request.getParameter("mm");
//					session.setAttribute("checkshowmodal", checkshowmodal);
//					System.out.println(checkshowmodal + "MaMon");
//					System.out.println(mabo.checkXoaMonAn(checkshowmodal) + "cmnn");
//					boolean checkduocxoa = false;
//					checkduocxoa = mabo.checkXoaMonAn(checkshowmodal);
//					if (checkduocxoa == true) {
//						System.out.println("Xoa duoc");
//						dsmon = mabo.GetMonAn();
//						request.setAttribute("dsmon", dsmon);						
//						mabo.xoaChiTietHoaDon(checkshowmodal);
//						mabo.deleteMonAn(checkshowmodal);
//						request.setAttribute("compl", "compl");
//						dsmon = mabo.GetMonAn();
//						request.setAttribute("dsmon", dsmon);
//						RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminQuanLyMon.jsp");
//						rd.forward(request, response);
//
//					} else {
//						int check = 1;
//						System.out.println("Khong Xoa duoc");
//						request.setAttribute("check", check);
//						dsmon = mabo.GetMonAn();
//						//session.removeAttribute("check");
//						request.setAttribute("dsmon", dsmon);
//						RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminQuanLyMon.jsp");
//						rd.forward(request, response);
//					}
//				}

				RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminQuanLyMon.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("tb", "Bạn cần đăng nhập");
				RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminLogin.jsp");
				rd.forward(request, response);
			}
		} catch (

		Exception e) {
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
