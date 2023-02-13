package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bo.GioHangBo;

/**
 * Servlet implementation class GioHangController
 */
@WebServlet("/GioHangController")
public class GioHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GioHangController() {
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
//		String masach = request.getParameter("mm");
//		String anh = request.getParameter("anh");
//		String msachHTG = request.getParameter("mm");
//		String sl = request.getParameter("txtsl");
		// long sl = Long.parseLong(request.getParameter("txtsl"));

		String masach = request.getParameter("mm");
		String anh = request.getParameter("anh");
		String tensach = request.getParameter("tm");
	
		
	    long gia = Long.parseLong(request.getParameter("gia"));

	    GioHangBo gh = null;
	    // Neu mua hang lan dau
	    if (session.getAttribute("gio") == null) {
	      gh = new GioHangBo();// cap vung nho
	      session.setAttribute("gio", gh);// tao session
	    }
	    
	    // b1: Luu session ra bien
	    gh = (GioHangBo) session.getAttribute("gio");
	    // b2: Thao tac tren bien
	    gh.Them(masach, tensach, anh, gia, (long) 1);
	    // b3: Luu bien vao session
	    session.setAttribute("gio", gh);

	    response.sendRedirect("HTGioHangController");
	    // RequestDispatcher rd = request.getRequestDispatcher("HTGioHangController");
	    // rd.forward(request, response);

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
