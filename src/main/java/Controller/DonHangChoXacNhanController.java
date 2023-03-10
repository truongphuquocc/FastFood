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

import Bean.KhachHangBean;
import Bean.LichSuMuaHangBean;
import Bo.LichSuMuaHangBo;

/**
 * Servlet implementation class DonHangChoXacNhanController
 */
@WebServlet("/DonHangChoXacNhanController")
public class DonHangChoXacNhanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DonHangChoXacNhanController() {
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

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		LichSuMuaHangBo lsmhbo = new LichSuMuaHangBo();
		KhachHangBean kh = (KhachHangBean) session.getAttribute("hoten");

		// ArrayList<LichSuMuaHangBean> dslichsu = null;
		try {
			if (kh != null) {
				ArrayList<LichSuMuaHangBean> dscho = lsmhbo.getDanhSachChoXacNhan(kh.getMaKhachHang());

				request.setAttribute("dscho", dscho);
				session.setAttribute("dscho", dscho);
				//session.setAttribute("dssize", dslichsu);
				String[] tu = kh.getHoTen().split(" ");
				for (String s : tu) {
					if (!s.equals("") && !s.equals(null)) {
						System.out.print(String.valueOf(s.charAt(0)));
						session.setAttribute("catchuoi", String.valueOf(s.charAt(0)));
					}
				}

				// System.out.print(tachChuoi(hoten)+"hoten sau khi tach");
				RequestDispatcher rd = request.getRequestDispatcher("KhachHang/DonHangChoXacNhan.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("tb", "B???n c???n ????ng nh???p");
				RequestDispatcher rd = request.getRequestDispatcher("KhachHang/DangNhap.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
