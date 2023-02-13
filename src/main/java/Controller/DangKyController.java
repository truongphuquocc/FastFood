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
import Bo.KhachHangBo;

/**
 * Servlet implementation class DangKyController
 */
@WebServlet("/DangKyController")
public class DangKyController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public DangKyController() {
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
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");

    try {
      String UserName = request.getParameter("username");
      request.setAttribute("UserName", UserName);
      String FullName = request.getParameter("fullname");
      request.setAttribute("FullName", FullName);
      String address = request.getParameter("address");
      request.setAttribute("address", address);
      String phonenumber = request.getParameter("phonenumber");
      request.setAttribute("phonenumber", phonenumber);
      String Email = request.getParameter("email");
      request.setAttribute("Email", Email);
      String password = request.getParameter("password");
      String confirm = request.getParameter("confirm");



      if (UserName != null && FullName != null && address != null && phonenumber != null
          && confirm != null && Email != null && password != null) {
        KhachHangBo khbo = new KhachHangBo();
        if (khbo.checkTendangnhap(UserName)) {
          System.out.println(password + "matkhau");

          String passwordMD5 = convertHashToString(password);
          System.out.println(passwordMD5 + "matkhauMD5");
          if (password.equals(confirm)) {
            boolean kh = khbo.ktdk(FullName, address, phonenumber, Email, UserName, passwordMD5);
            if (kh == true) {
              RequestDispatcher rd = request.getRequestDispatcher("MonAnController");
              rd.forward(request, response);
            }
          } else {
            request.setAttribute("mk", "Xác nhận mật khẩu không đúng");
            RequestDispatcher rd = request.getRequestDispatcher("KhachHang/DangKy.jsp");
            rd.forward(request, response);
          }
        } else {
          request.setAttribute("tb", "Tên đăng nhập bị trùng");
          RequestDispatcher rd = request.getRequestDispatcher("KhachHang/DangKy.jsp");
          rd.forward(request, response);
        }

      } else {// chay lan dau
        RequestDispatcher rd = request.getRequestDispatcher("KhachHang/DangKy.jsp");
        rd.forward(request, response);
      }

    } catch (Exception e) {
      // TODO: handle exception
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
