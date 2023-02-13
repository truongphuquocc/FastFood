package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
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
			LoaiBo lb = new LoaiBo();
			ArrayList<LoaiBean> dsloai;
			dsloai = lb.getloai();
			if (session.getAttribute("admin") != null) {

				SanPhamBo sbo = new SanPhamBo();
				SanPhamBean sbean;
				ArrayList<SanPhamBean> dssp;
				dssp = sbo.getsanpham();

				String del = request.getParameter("del");

				request.setAttribute("dssp", dssp);

				if (del != null) {
//					sbean = sbo.getchitietsanpham(del);
//			          request.setAttribute("dssp", sbean);
					ChiTietHoaDonBo ctbo = new ChiTietHoaDonBo();
					if (ctbo.checkXoa(del)) {
						ctbo.XoaChiTietHoaDon(del);
						sbo.deleteProduct(del);
						dssp = sbo.getsanpham();
						request.setAttribute("dssp", dssp);
						session.removeAttribute("check");
//						RequestDispatcher rd = request.getRequestDispatcher("AdminProductController");
//						rd.forward(request, response);
						response.sendRedirect("AdminProductController");
					} else {
						int check = 0;
						session.setAttribute("check", check);
						dssp = sbo.getsanpham();
						request.setAttribute("dssp", dssp);
						response.sendRedirect("AdminProductController");
					}
				}
				

//				RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminQuanLyMon.jsp");
//				rd.forward(request, response);
//				if (session.getAttribute("xoa11") != null) {
//					mabo.deleteMonAn(checkshowmodal);
//					session.removeAttribute("xoa11");
//					dsmon = mabo.GetMonAn();
//					request.setAttribute("dsmon", dsmon);
//
//					RequestDispatcher rd1 = request.getRequestDispatcher("Admin/AdminThemMon.jsp");
//					rd1.forward(request, response);
//				}

				RequestDispatcher rd = request.getRequestDispatcher("Admin/Products.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("AdminLoginController");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
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
