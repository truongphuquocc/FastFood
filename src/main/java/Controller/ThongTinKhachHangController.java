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
import Bo.KhachHangBo;

/**
 * Servlet implementation class ThongTinKhachHangController
 */
@WebServlet("/ThongTinKhachHangController")
public class ThongTinKhachHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThongTinKhachHangController() {
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
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			KhachHangBo khbo = new KhachHangBo();
			KhachHangBean kh = (KhachHangBean) session.getAttribute("hoten");
			KhachHangBean thongtinkh = khbo.laythongtin(kh.getTenDangNhap());
			request.setAttribute("ttkh", thongtinkh);
			
			String Hoten = request.getParameter("firstname");
			System.out.println(Hoten + "Hoten");
			String Sdt = request.getParameter("telephone");
			System.out.println(Sdt + "Sdt");
			String Email = request.getParameter("email");
			System.out.println(Email + "Email");
			
			if (request.getParameter("btnsave") != null) {
				khbo.ChangeInfo(kh.getTenDangNhap(), Hoten, Email, Sdt);
				KhachHangBean thongtinsau = khbo.laythongtin(kh.getTenDangNhap());
				request.setAttribute("ttkh", thongtinsau);
				session.setAttribute("hoten", thongtinsau);
				RequestDispatcher rd = request.getRequestDispatcher("KhachHang/ThongTin.jsp");
				rd.forward(request, response);
			}
			RequestDispatcher rd = request.getRequestDispatcher("KhachHang/ThongTin.jsp");
			rd.forward(request, response);
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
