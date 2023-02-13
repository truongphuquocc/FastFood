package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bean.LoaiHangBean;
import Bean.MonAnBean;
import Bo.LoaiHangBo;
import Bo.MonAnBo;

/**
 * Servlet implementation class MonAnController
 */
@WebServlet("/MonAnController")
public class MonAnController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public MonAnController() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      request.setCharacterEncoding("utf-8");
      response.setCharacterEncoding("utf-8");

      String key = request.getParameter("txttk");

      if (request.getParameter("key") != null) {
        key = request.getParameter("key");
      }
      String ml = request.getParameter("ml");
      System.out.println(ml + "dddddđ");
      LoaiHangBo lbo = new LoaiHangBo();
      ArrayList<LoaiHangBean> dsloai = lbo.getloai();
      request.setAttribute("dsloai", dsloai);

      MonAnBo sbo = new MonAnBo();

      ArrayList<MonAnBean> dsmon = null;
      int currentPage = 1;
      if (request.getParameter("page") != null) {
        currentPage = Integer.parseInt(request.getParameter("page"));
      }

      int totalSach = sbo.getPageNumber();
      int endPage = totalSach / 12;
      if (totalSach % 12 != 0) {
        endPage++;
      }

      if (ml != null && ml != "") {
        dsmon = sbo.getPagingCategories(ml, currentPage);
        totalSach = sbo.getPageNumberCategories(ml);

        endPage = totalSach / 12;
        if (totalSach % 12 != 0) {
          endPage++;
        }

      } else if (key != null && key != "") {
        // ArrayList<sachbean> dsmonTKTD = sbo.Tim(key);
        dsmon = sbo.getPagingSearch(key, currentPage);
        // totalSach = dsmonTKTD.size();
        // totalSach = dsmon.size();
        totalSach = sbo.getPageNumberSearch(key);
        endPage = totalSach / 12;
        if (totalSach % 12 != 0) {
          endPage++;
        }
      } else {
        dsmon = sbo.getPaging(currentPage);

      }
      request.setAttribute("dsmon", dsmon);
      request.setAttribute("endPage", endPage);
      request.setAttribute("currentPage", currentPage);
      request.setAttribute("mloai", ml);
      request.setAttribute("keyTD", key);
      request.setAttribute("totalSach", totalSach);



      RequestDispatcher rd = request.getRequestDispatcher("KhachHang/TrangChu.jsp");
      rd.forward(request, response);
    } catch (Exception e) {
      e.printStackTrace();
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
