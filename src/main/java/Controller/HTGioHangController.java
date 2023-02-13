package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.KhachHangBean;
import Bo.GioHangBo;

/**
 * Servlet implementation class HTGioHangController
 */
@WebServlet("/HTGioHangController")
public class HTGioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HTGioHangController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		GioHangBo gh = (GioHangBo) session.getAttribute("gio");
		if (gh != null) {
			if (request.getParameter("btnsua") != null) {
				String mamon = request.getParameter("btnsua");
				long sl = Long.parseLong(request.getParameter("t" + mamon));
				System.out.println(sl);
				if (sl == 0) {
					gh.Xoa(mamon);
				} else
					gh.Sua(mamon, sl);

			}
			if (request.getParameter("btnxoa") != null) {
				String mamon = request.getParameter("btnxoa");
				gh.Xoa(mamon);

			}
			if (request.getParameter("btnXoaCheck") != null) {
				String[] gtcheck = request.getParameterValues("check");
				if (gtcheck != null) {
					for (String ss : gtcheck)
						gh.Xoa(ss);
				}
			}
			session.setAttribute("gio", gh);
			session.removeAttribute("check");
			

		} else {
			int check = 0;
			int check2 = 0;
			session.setAttribute("check2", check2);
			session.setAttribute("check", check);
		}
		RequestDispatcher rd2 = request.getRequestDispatcher("KhachHang/GioHang.jsp");
		rd2.forward(request, response);
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
