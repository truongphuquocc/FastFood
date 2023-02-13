package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Bean.AdminBean;
import Bean.LoaiHangBean;
import Bo.LoaiHangBo;
import Bo.MonAnBo;

/**
 * Servlet implementation class AdminThemLoaiController
 */
@WebServlet("/AdminThemLoaiController")
public class AdminThemLoaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminThemLoaiController() {
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
			AdminBean ad = (AdminBean) session.getAttribute("ad");
			if (ad != null) {
				DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
				LoaiHangBo loai = new LoaiHangBo();
				ArrayList<LoaiHangBean> dsloai = null;
				dsloai = loai.getloai();
				request.setAttribute("dsloai", dsloai);
				LoaiHangBo lbo = new LoaiHangBo();
				try {
					String tenloai = null, maloai = null, anhupload = null;

					List<FileItem> fileItems = upload.parseRequest(request);
					for (FileItem fileItem : fileItems) {
						if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
							String nameimg = fileItem.getName();
							if (!nameimg.equals("")) {
								String dirUrl = request.getServletContext().getRealPath("") + "Images";
								File dir = new File(dirUrl);
								if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
									dir.mkdir();
								}
								String fileImg = dirUrl + File.separator + nameimg;
								File file = new File(fileImg);// tạo file
								try {
									fileItem.write(file);// ghi file
									anhupload = "Images/" + nameimg;
									System.out.println(anhupload);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						} else {
							String tentk = fileItem.getFieldName();
							if (tentk.equals("txtmaloai"))
								maloai = fileItem.getString("UTF-8");
							if (tentk.equals("txttenloai"))
								tenloai = fileItem.getString("UTF-8");

						}
					}
					
					if (request.getParameter("btnBack") != null) {
						RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLyLoaiController");
						rd.forward(request, response);
					}

					int check = lbo.addCategory(maloai, tenloai, anhupload);

					if (check == 0) {
						request.setAttribute("checkadd", check);
						RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLyLoaiController");
						rd.forward(request, response);
					} else if (check == -1) {
						session.setAttribute("checkadd", check);
						RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLyLoaiController");
						rd.forward(request, response);
					} else {
						request.setAttribute("tb", check);
						RequestDispatcher rd = request.getRequestDispatcher("AdminQuanLyLoaiController");
						rd.forward(request, response);

					}

	

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				// RequestDispatcher rd = request.getRequestDispatcher("Admin/SuaSach.jsp");
				// rd.forward(request, response);
			} else {
				request.setAttribute("tb", "Bạn cần đăng nhập");
				RequestDispatcher rd = request.getRequestDispatcher("Admin/AdminLogin.jsp");
				rd.forward(request, response);
			}
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
