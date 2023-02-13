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

import Bean.ChiTietLichSuMuaHangBean;
import Bean.KhachHangBean;
import Bean.LichSuMuaHangBean;
import Bo.ChiTietLichSuMuaHangBo;
import Bo.LichSuMuaHangBo;

/**
 * Servlet implementation class ChiTietLichSuController
 */
@WebServlet("/ChiTietLichSuController")
public class ChiTietLichSuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChiTietLichSuController() {
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
			HttpSession session = request.getSession();
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");

			ChiTietLichSuMuaHangBo ctlsmhbo = new ChiTietLichSuMuaHangBo();
			String MaHoaDon = request.getParameter("mhd");
			long MaHoaDonParse = Long.parseLong(MaHoaDon);
			System.out.println(MaHoaDon + "mhd");

			// ArrayList<LichSuMuaHangBean> dslichsu = null;

			ChiTietLichSuMuaHangBean dshd = ctlsmhbo.laymothoadon(MaHoaDonParse);
			System.out.println(dshd + "dshd");

			ArrayList<ChiTietLichSuMuaHangBean> dslichsu = ctlsmhbo.getLichSuMuaHang(MaHoaDonParse);

			request.setAttribute("dsctlichsu", dslichsu);
			session.setAttribute("dshd", dshd);

			RequestDispatcher rd = request.getRequestDispatcher("KhachHang/ChiTietDonHang.jsp");
			rd.forward(request, response);
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
