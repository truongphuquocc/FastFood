package Controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Bean.KhachHangBean;
import Bo.KhachHangBo;
import nl.captcha.Captcha;

/**
 * Servlet implementation class DangNhapController
 */
@WebServlet("/DangNhapController")
public class DangNhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DangNhapController() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String convertHashToString(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hashInBytes = md.digest(text.getBytes(StandardCharsets.UTF_8));
		StringBuilder sb = new StringBuilder();
		for (byte b : hashInBytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String un = request.getParameter("un");
			String pass = request.getParameter("pass");
			session.setAttribute("taikhoan", un);
			String backtocart = (String) session.getAttribute("backtocart");
			KhachHangBo khBo = new KhachHangBo();

			Captcha captcha = (Captcha) session.getAttribute(Captcha.NAME);
			request.setCharacterEncoding("UTF-8");
			String answer = request.getParameter("answer");

			if (un != null && pass != null) {

				String passMD5 = convertHashToString(pass);
				KhachHangBean khbean = khBo.ktdn(un, passMD5);
				int count;
				if (session.getAttribute("countLogin") == null) {
					count = 0;
					session.setAttribute("countLogin", 0);
				} else {
					count = (int) session.getAttribute("countLogin");
				}
				if (khbean != null) {
					if(backtocart != null) {
						session.setAttribute("hoten", khbean);
						response.sendRedirect("ThanhToanController");
						
					}
					else if (count >= 2 && captcha.isCorrect(answer)) {
						count = 0;
						session.setAttribute("countLogin", count);
						session.setAttribute("hoten", khbean);

						response.sendRedirect("MonAnController");
					} else if (count < 2) {
						count = 0;
						session.setAttribute("countLogin", count);
						session.setAttribute("hoten", khbean);
						/*
						 * RequestDispatcher rd = request.getRequestDispatcher("MonAnController");
						 * rd.forward(request, response);
						 */
						response.sendRedirect("MonAnController");
					}
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("KhachHang/DangNhap.jsp?kt=1");
					rd.forward(request, response);
					count = count + 1;
					session.setAttribute("countLogin", count);
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("KhachHang/DangNhap.jsp");
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
