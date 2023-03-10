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
 * Servlet implementation class AdminXoaLoaiController
 */
@WebServlet("/AdminXoaLoaiController")
public class AdminXoaLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminXoaLoaiController() {
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
				
				String xoamodal = request.getParameter("btnxoa");
				System.out.println(xoamodal + "xoaaaaaa");
				
				if (request.getParameter("btnxoa") != null) {
					session.setAttribute("xoa11", xoamodal);
					System.out.println(request.getParameter("btnxoa") + "0222222222222");
					
				}
				else {
					System.out.println("nullllllllllllllllllllll");
				}
				
				
				String xoa11 = (String) session.getAttribute("xoa11");
				LoaiHangBo lbo = new LoaiHangBo();
				ArrayList<LoaiHangBean> dsloai = null;
				dsloai = lbo.getloai();
				request.setAttribute("dsloai", dsloai);
				if (request.getParameter("btnDelete") != null) {
					String checkshowmodal = request.getParameter("mm");
					if (lbo.checkDeleteCategory(checkshowmodal)) {
						session.setAttribute("checkshowmodal", checkshowmodal);
						dsloai = lbo.getloai();
						request.setAttribute("dsloai", dsloai);
						response.sendRedirect("AdminQuanLyLoaiController");
						System.out.println(session.getAttribute("xoa11") + "001111111111111111111");

						if (xoa11 != null) {
							lbo.deleteCategory(checkshowmodal);
							session.removeAttribute("xoa11");
							dsloai = lbo.getloai();
							request.setAttribute("dsloai", dsloai);
							RequestDispatcher rd1 = request.getRequestDispatcher("Admin/AdminQuanLyLoai.jsp");
							rd1.forward(request, response);
						}

					} else {
						int checkxoa = 0;
						session.setAttribute("checkxoa", checkxoa);
						dsloai = lbo.getloai();
						request.setAttribute("dsloai", dsloai);
						response.sendRedirect("AdminQuanLyLoaiController");
					}
				}
				RequestDispatcher rd1 = request.getRequestDispatcher("Admin/AdminQuanLyLoai.jsp");
				rd1.forward(request, response);
			} else {
				request.setAttribute("tb", "B???n c???n ????ng nh???p");
				RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminLogin.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
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
