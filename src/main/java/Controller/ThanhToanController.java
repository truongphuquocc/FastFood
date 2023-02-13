package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bean.GioHangBean;
import Bean.KhachHangBean;
import Bo.GioHangBo;
import Bo.ThanhToanBo;

/**
 * Servlet implementation class ThanhToanController
 */
@WebServlet("/ThanhToanController")
public class ThanhToanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThanhToanController() {
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

			KhachHangBean kh = (KhachHangBean) session.getAttribute("hoten");
			GioHangBo gh = (GioHangBo) session.getAttribute("gio");

			if (request.getParameter("btnThanhToan") != null) {
				if (kh == null) {
					session.setAttribute("backtocart", "backtocart");
					RequestDispatcher rd2 = request.getRequestDispatcher("DangNhapController");
					rd2.forward(request, response);
				} else {
					String ghichu = request.getParameter("txtghichu");
					System.out.println(ghichu + "ghichu");
					ThanhToanBo ttbo = new ThanhToanBo();
					ttbo.ThemHoaDon(kh.MaKhachHang, ghichu);
					long maHD = ttbo.GetHoaDon();
					if (maHD != 0) {
						for (GioHangBean item : gh.ds) {
							ttbo.ThemCTHD(item.getMaMonAn(), item.getSoLuong(), (long) maHD);
						}

					}
					gh.XoaALL();

					response.sendRedirect("HTGioHangController");
				}
				RequestDispatcher rd2 = request.getRequestDispatcher("KhachHang/GioHang.jsp");
				rd2.forward(request, response);
			}
			RequestDispatcher rd2 = request.getRequestDispatcher("KhachHang/GioHang.jsp");
			rd2.forward(request, response);

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
